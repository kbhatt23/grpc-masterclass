package com.learning.spring_boot_grpc_server.simplemessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learning.spring_boot_grpc_server.simplemessage.SimpleMessageServiceGrpc.SimpleMessageServiceImplBase;
import io.grpc.Status;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class SimpleMessageServiceImpl extends SimpleMessageServiceImplBase{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void squareNumber(SimpleMessageRequest request, StreamObserver<SimpleMessageResponse> responseObserver) {
		logger.info("squareNumber: called with request "+request);
		
		int number = request.getNumber();
		
		//default is 0 if not passed
	
		if(number == 0) {
			String mssage = "squareNumber: invalid number "+number+" passed fo task";
			logger.error(mssage);
			Status status = Status.FAILED_PRECONDITION.withDescription(mssage);
			responseObserver.onError(status.asException());
			return;
		}
		
		responseObserver.onNext(SimpleMessageResponse.newBuilder()
				.setNumber(number)
				.setNumberSquare(number*number)
				.build());
		responseObserver.onCompleted();
	}
}
