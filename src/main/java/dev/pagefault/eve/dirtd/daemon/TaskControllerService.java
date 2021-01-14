package dev.pagefault.eve.dirtd.daemon;

import dev.pagefault.eve.dirtd.daemon.TaskExecutor.TaskNotFoundException;
import dev.pagefault.eve.grpc.Common.RequestStatus;
import dev.pagefault.eve.grpc.Task.TaskRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.grpc.TaskControllerGrpc;
import io.grpc.stub.StreamObserver;

public class TaskControllerService extends TaskControllerGrpc.TaskControllerImplBase {

	private static Logger log = LogManager.getLogger();

	private TaskExecutor executor;

	public TaskControllerService(TaskExecutor executor) {
		this.executor = executor;
	}

	@Override
	public void startTask(TaskRequest request, StreamObserver<RequestStatus> responseObserver) {
		log.debug("grpc - startTask (" + request.getTaskname() + ")");
		try {
			executor.start(request.getTaskname());
			responseObserver.onNext(RequestStatus.newBuilder().setSuccess(true).setMessage("Started task successfully").build());
		} catch(TaskNotFoundException e) {
			responseObserver.onNext(RequestStatus.newBuilder().setSuccess(false).setMessage("Failed to find task").build());
		}
		responseObserver.onCompleted();
	}

	@Override
	public void stopTask(TaskRequest request, StreamObserver<RequestStatus> responseObserver) {
		log.debug("grpc - stopTask (" + request.getTaskname() + ")");
		try {
			if (request.getTaskname().isEmpty()) {
				executor.stopAll();
				responseObserver.onNext(RequestStatus.newBuilder().setSuccess(true).setMessage("Stopped all tasks successfully").build());
			} else {
				executor.stop(request.getTaskname(), false);
				responseObserver.onNext(RequestStatus.newBuilder().setSuccess(true).setMessage("Stopped task successfully").build());
			}
		} catch(TaskNotFoundException e) {
			responseObserver.onNext(RequestStatus.newBuilder().setSuccess(false).setMessage("Failed to find task").build());
		}
		responseObserver.onCompleted();
	}

	@Override
	public void enableTask(TaskRequest request, StreamObserver<RequestStatus> responseObserver) {
		log.debug("grpc - enableTask (" + request.getTaskname() + ")");
		try {
			executor.enable(request.getTaskname());
			responseObserver.onNext(RequestStatus.newBuilder().setSuccess(true).setMessage("Enabled task successfully").build());
		} catch(TaskNotFoundException e) {
			responseObserver.onNext(RequestStatus.newBuilder().setSuccess(false).setMessage("Failed to find task").build());
		}
		responseObserver.onCompleted();
	}

	@Override
	public void disableTask(TaskRequest request, StreamObserver<RequestStatus> responseObserver) {
		log.debug("grpc - disableTask (" + request.getTaskname() + ")");
		try {
			executor.disable(request.getTaskname());
			responseObserver.onNext(RequestStatus.newBuilder().setSuccess(true).setMessage("Disabled task successfully").build());
		} catch(TaskNotFoundException e) {
			responseObserver.onNext(RequestStatus.newBuilder().setSuccess(false).setMessage("Failed to find task").build());
		}
		responseObserver.onCompleted();
	}

	@Override
	public void statusTask(TaskRequest request, StreamObserver<RequestStatus> responseObserver) {
		log.debug("grpc - statusTask (" + request.getTaskname() + ")");
		try {
			String status = executor.status(request.getTaskname());
			responseObserver.onNext(RequestStatus.newBuilder().setSuccess(true).setMessage(status).build());
		} catch(TaskNotFoundException e) {
			responseObserver.onNext(RequestStatus.newBuilder().setSuccess(false).setMessage("Failed to find task").build());
		}
		responseObserver.onCompleted();
	}

}
