package com.learning.spring_boot_grpc_client.simplemessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.learning.spring_boot_grpc_client.simplemessage.SimpleMessageServiceGrpc.SimpleMessageServiceBlockingStub;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class SimpleMessageClientService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@GrpcClient("simple-message-service")
	private SimpleMessageServiceBlockingStub blockingStub;
	
	
	public SimpleMessageDTO findResponse(int number) {
		logger.info("findResponse: called for number "+number);
		SimpleMessageRequest request = SimpleMessageRequest.newBuilder().setNumber(number).build();
		//looks like emthod call but it is netweok call - woow
		SimpleMessageResponse squareNumber = blockingStub.squareNumber(request);
		
		logger.info("findResponse: response "+squareNumber+" recieved for request "+request);
		return new SimpleMessageDTO(number, squareNumber.getNumberSquare());
	}
	
}
