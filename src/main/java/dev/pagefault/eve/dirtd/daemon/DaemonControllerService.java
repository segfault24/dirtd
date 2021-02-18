package dev.pagefault.eve.dirtd.daemon;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import dev.pagefault.eve.dbtools.db.StructAuthTable;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.DirtConstants;
import dev.pagefault.eve.dirtd.esi.EsiUtils;
import dev.pagefault.eve.dirtd.task.InvMarketGroupsTask;
import dev.pagefault.eve.dirtd.task.InvTypesTask;
import dev.pagefault.eve.dirtd.task.StructureTask;
import dev.pagefault.eve.grpc.Common.Empty;
import dev.pagefault.eve.grpc.Common.RequestStatus;
import dev.pagefault.eve.grpc.Daemon.Property;
import dev.pagefault.eve.grpc.Daemon.PropertyStatus;
import dev.pagefault.eve.grpc.Daemon.Struct;
import dev.pagefault.eve.grpc.DaemonControllerGrpc;
import io.grpc.stub.StreamObserver;

public class DaemonControllerService extends DaemonControllerGrpc.DaemonControllerImplBase {

	private static Logger log = LogManager.getLogger();

	private DbPool dbPool;
	private TaskExecutor executor;

	public DaemonControllerService(DbPool dbPool, TaskExecutor executor) {
		this.dbPool = dbPool;
		this.executor = executor;
	}

	@Override
	public void forceTypeUpdate(Empty request, StreamObserver<RequestStatus> responseObserver) {
		InvTypesTask i = new InvTypesTask();
		i.forceUpdate(true);
		executor.scheduleTask(i);
		InvMarketGroupsTask g = new InvMarketGroupsTask();
		g.forceUpdate(true);
		executor.scheduleTask(g);
		responseObserver.onNext(
				RequestStatus.newBuilder().setSuccess(true).setMessage("Queued type & group update tasks").build());
		responseObserver.onCompleted();
	}

	@Override
	public void addStruct(Struct request, StreamObserver<RequestStatus> responseObserver) {
		Connection db = null;
		try {
			db = dbPool.acquire();
		} catch (SQLException e) {
			responseObserver.onNext(RequestStatus.newBuilder().setSuccess(false)
					.setMessage("Failed to acquire database connection").build());
			responseObserver.onCompleted();
			return;
		}

		RequestStatus status;
		long structId = request.getStructid();
		int keyId;
		try {
			keyId = Utils.getIntProperty(db, DirtConstants.PROPERTY_SCRAPER_KEY_ID);
		} catch (NumberFormatException e) {
			// retry?
			keyId = Utils.getIntProperty(db, DirtConstants.PROPERTY_SCRAPER_KEY_ID);
		}
		// manually run the task
		StructureTask st = new StructureTask(structId, keyId);
		st.setExecutor(executor);
		st.setDbPool(dbPool);
		st.run();
		// create a link between the struct and the key
		try {
			StructAuthTable.insert(db, structId, keyId);
			status = RequestStatus.newBuilder().setSuccess(true)
					.setMessage("structure task successful, structauth link created").build();
		} catch (SQLException e) {
			status = RequestStatus.newBuilder().setSuccess(false).setMessage("failed to create structauth link")
					.build();
		}

		responseObserver.onNext(status);
		responseObserver.onCompleted();
		dbPool.release(db);
	}

	@Override
	public void setProperty(Property request, StreamObserver<PropertyStatus> responseObserver) {
		Connection db = null;
		try {
			db = dbPool.acquire();
		} catch (SQLException e) {
			RequestStatus rstatus = RequestStatus.newBuilder().setSuccess(false)
					.setMessage("Failed to acquire database connection").build();
			responseObserver.onNext(PropertyStatus.newBuilder().setStatus(rstatus).setProperty(request).build());
			responseObserver.onCompleted();
			return;
		}

		RequestStatus rstatus = null;
		if (request.getPropertyName().equalsIgnoreCase(DirtConstants.PROPERTY_NUM_THREADS)) {
			try {
				int s = Integer.parseInt(request.getPropertyValue());
				if (s <= 0) {
					rstatus = RequestStatus.newBuilder().setSuccess(false).setMessage("Invalid pool size").build();
				} else {
					executor.setCorePoolSize(s);
					dbPool.setMinPoolSize(s);
					Utils.setProperty(db, DirtConstants.PROPERTY_NUM_THREADS, request.getPropertyValue());
					rstatus = RequestStatus.newBuilder().setSuccess(true).setMessage("Pool size updated").build();
				}
			} catch (NumberFormatException e) {
				rstatus = RequestStatus.newBuilder().setSuccess(false).setMessage("Invalid pool size").build();
			}
		} else if (request.getPropertyName().equalsIgnoreCase(DirtConstants.PROPERTY_LOG_LEVEL)) {
			try {
				Level l = Level.valueOf(request.getPropertyValue());
				Configurator.setRootLevel(l);
				rstatus = RequestStatus.newBuilder().setSuccess(true).setMessage("Log level updated successfully")
						.build();
			} catch (IllegalArgumentException e) {
				rstatus = RequestStatus.newBuilder().setSuccess(true).setMessage("Failed to update log level").build();
			}
		} else {
			Utils.setProperty(db, request.getPropertyName(), request.getPropertyValue());
			rstatus = RequestStatus.newBuilder().setSuccess(true).setMessage("Property updated successfully").build();
		}

		responseObserver.onNext(PropertyStatus.newBuilder().setStatus(rstatus).setProperty(request).build());
		responseObserver.onCompleted();
		dbPool.release(db);
	}

	@Override
	public void getProperty(Property request, StreamObserver<PropertyStatus> responseObserver) {
		Connection db = null;
		try {
			db = dbPool.acquire();
		} catch (SQLException e) {
			RequestStatus rstatus = RequestStatus.newBuilder().setSuccess(false)
					.setMessage("Failed to acquire database connection").build();
			responseObserver.onNext(PropertyStatus.newBuilder().setStatus(rstatus).setProperty(request).build());
			responseObserver.onCompleted();
			return;
		}

		String propertyValue = Utils.getProperty(db, request.getPropertyName());
		RequestStatus rstatus = RequestStatus.newBuilder().setSuccess(true).setMessage("Success").build();
		Property prop = Property.newBuilder().setPropertyName(request.getPropertyName()).setPropertyValue(propertyValue)
				.build();
		responseObserver.onNext(PropertyStatus.newBuilder().setStatus(rstatus).setProperty(prop).build());
		responseObserver.onCompleted();
		dbPool.release(db);
	}

	@Override
	public void status(Empty request, StreamObserver<RequestStatus> responseObserver) {
		String message = "\n";
		message += "   uptime: " + executor.getUptime() + "\n";
		message += "esi calls: " + EsiUtils.esiCalls + "  errors: " + EsiUtils.esiErrors + "\n";
		message += "sso calls: " + EsiUtils.ssoCalls + "  errors: " + EsiUtils.ssoErrors + "\n";
		message += " poolsize: " + executor.getPoolSize() + "\n";
		message += " complete: " + executor.getCompletedTaskCount() + "\n";
		message += "   queued: " + executor.getQueue().size() + "\n";
		message += "   active: " + executor.getActiveCount() + "\n";
		responseObserver.onNext(RequestStatus.newBuilder().setSuccess(true).setMessage(message).build());
		responseObserver.onCompleted();
	}

}
