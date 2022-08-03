package dev.pagefault.eve.dirtd.task;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.TaskLogTable;
import dev.pagefault.eve.dbtools.model.TaskLog;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dirtd.daemon.Taskable;

public abstract class DirtTask implements Runnable {

	private static Logger log = LogManager.getLogger();

	private Taskable executor;
	private DbPool dbPool;
	private Connection db;

	private boolean enabled;
	private boolean started;

	public abstract String getTaskName();

	protected abstract void runTask();

	public void setExecutor(Taskable executor) {
		this.executor = executor;
	}

	protected Taskable getExecutor() {
		return executor;
	}

	public void setDbPool(DbPool dbPool) {
		this.dbPool = dbPool;
	}

	protected Connection getDb() {
		return db;
	}

	@Override
	public final void run() {
		log.info("Started task " + getTaskName());

		log.trace("Acquiring database connection from pool");
		try {
			db = dbPool.acquire();
		} catch (SQLException e) {
			log.fatal("Failed to acquire database connection, aborting task " + getTaskName() + ": " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}

		long startTime = Calendar.getInstance().getTimeInMillis();
		runTask();
		long endTime = Calendar.getInstance().getTimeInMillis();

		int duration = (int) ((endTime - startTime) / 1000);
		TaskLog tl = new TaskLog();
		tl.setTaskName(getTaskName());
		tl.setStartTime(new Timestamp(startTime));
		tl.setFinishTime(new Timestamp(endTime));
		tl.setSuccess(true);
		try {
			TaskLogTable.insertTaskLog(db, tl);
		} catch (SQLException e) {
			log.warn("Failed to update TaskStatus for " + getTaskName() + ": " + e.getLocalizedMessage());
			log.debug(e);
		}

		log.trace("Releasing database connection to pool");
		DbPool.resetConnection(db);
		dbPool.release(db);

		log.info("Completed task " + getTaskName() + " in " + duration + " seconds");
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

}
