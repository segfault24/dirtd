package dev.pagefault.eve.dirtd.daemon;

import dev.pagefault.eve.grpc.Task.TaskRequest;
import dev.pagefault.eve.grpc.Task.TaskRequestStatus;

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
	public void startTask(TaskRequest request, StreamObserver<TaskRequestStatus> responseObserver) {
		log.info("grpc - received TaskRequest on startTask (" + request.getTaskname() + ")");
		responseObserver.onNext(TaskRequestStatus.newBuilder().setSuccess(true).setMessage("This is a test TaskRequestStatus message!").build());
		responseObserver.onCompleted();
	}

	@Override
	public void stopTask(TaskRequest request, StreamObserver<TaskRequestStatus> responseObserver) {
		log.info("grpc - received TaskRequest on stopTask (" + request.getTaskname() + ")");
		responseObserver.onNext(TaskRequestStatus.newBuilder().setSuccess(true).setMessage("This is a test TaskRequestStatus message!").build());
		responseObserver.onCompleted();
	}

	@Override
	public void enableTask(TaskRequest request, StreamObserver<TaskRequestStatus> responseObserver) {
		log.info("grpc - received TaskRequest on enableTask (" + request.getTaskname() + ")");
		responseObserver.onNext(TaskRequestStatus.newBuilder().setSuccess(true).setMessage("This is a test TaskRequestStatus message!").build());
		responseObserver.onCompleted();
	}

	@Override
	public void disableTask(TaskRequest request, StreamObserver<TaskRequestStatus> responseObserver) {
		log.info("grpc - received TaskRequest on disableTask (" + request.getTaskname() + ")");
		responseObserver.onNext(TaskRequestStatus.newBuilder().setSuccess(true).setMessage("This is a test TaskRequestStatus message!").build());
		responseObserver.onCompleted();
	}

	@Override
	public void statusTask(TaskRequest request, StreamObserver<TaskRequestStatus> responseObserver) {
		log.info("grpc - received TaskRequest on statusTask (" + request.getTaskname() + ")");
		responseObserver.onNext(TaskRequestStatus.newBuilder().setSuccess(true).setMessage("This is a test TaskRequestStatus message!").build());
		responseObserver.onCompleted();
	}

}
