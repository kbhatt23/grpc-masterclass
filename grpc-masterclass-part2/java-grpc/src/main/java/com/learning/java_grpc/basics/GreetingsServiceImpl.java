package com.learning.java_grpc.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.learning.java_grpc.basics.GreetingsServiceGrpc.GreetingsServiceImplBase;
import com.learning.java_grpc.basics.utils.ThreadUtils;

import io.grpc.Context;
import io.grpc.stub.StreamObserver;

public class GreetingsServiceImpl extends GreetingsServiceImplBase{

	@Override
	public void greet(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
		System.out.println("GreetingsServiceImpl.greet : greet requested by "+request);
		
		//mimicking real task
		ThreadUtils.sleep(1000);
		
		Human human = request.getHuman();
		String fullName = human.getFirstName() + " "+ human.getLastName();
		
		//here we can only call on next only once in response observer
		//calling on next multiple times will cause exception
		responseObserver.onNext(GreetingResponse.newBuilder().setMessage("jai shree ram says "+fullName).build());
		
		responseObserver.onCompleted();
	}
	
	@Override
	public void greetRepeatedly(MultipleGreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
		System.out.println("GreetingsServiceImpl.greetRepeatedly : greet requested by "+request);
		List<Human> humans = request.getHumansList();
		
		humans.forEach(human ->{
			ThreadUtils.sleep(1000);
			String fullName = human.getFirstName() + " "+ human.getLastName();
			responseObserver.onNext(GreetingResponse.newBuilder().setMessage("jai shree ram says "+fullName).build());
		});
		
		//after all data is sent , lets complete the channel
		responseObserver.onCompleted();
	}
	
	//client streaming
	@Override
	public StreamObserver<GreetingRequest> greetForLong(StreamObserver<GreetingResponse> responseObserver) {

		return new StreamObserver<GreetingRequest>() {
			private List<String> responseMessages;

			@Override
			public void onNext(GreetingRequest request) {
				//once server receives one request from customer what to do
				//however we wont be sending response for each request
				//lets do the task and return only one response
				System.out.println("GreetingsServiceImpl.greetForLong : greet requested by "+request);
				if(responseMessages == null)
					responseMessages = new ArrayList<>();
				Human human = request.getHuman();
				responseMessages.add("jai shree ram says "+human.getFirstName()+" "+human.getLastName());
			}

			@Override
			public void onError(Throwable t) {
				String error = "GreetingsServiceImpl.greetForLong : Error Occurred "+t.getMessage();
				System.out.println(error);
				responseObserver.onError(new IllegalStateException(error));
			}

			@Override
			public void onCompleted() {
				System.out.println("GreetingsServiceImpl.greetForLong : All task completed");
				String message = responseMessages.stream()
				      .collect(Collectors.joining(","));
				responseObserver.onNext(GreetingResponse.newBuilder().setMessage(message).build());
				
				responseObserver.onCompleted();
				      
			}
			
		};
	}
	
	
	@Override
	public StreamObserver<GreetingRequest> greetAll(StreamObserver<GreetingResponse> responseObserver) {
		return new StreamObserver<GreetingRequest>() {

			//for each request from client
			@Override
			public void onNext(GreetingRequest request) {
				System.out.println("GreetingsServiceImpl.greetAll greet rqeuested by "+request);
				
				//mimicking delay
				ThreadUtils.sleep(2000);
				
				//lets respond back for every request
				Human human = request.getHuman();
				responseObserver.onNext(GreetingResponse.newBuilder().setMessage("jai shree ram says "+human.getFirstName()+" "+human.getLastName()).build());
			}

			@Override
			public void onError(Throwable t) {
				String error = "GreetingsServiceImpl.greetAll : Error Occurred "+t.getMessage();
				System.out.println(error);
				responseObserver.onError(new IllegalStateException(error));
			}
			
			//what do do when client says i am done
			@Override
			public void onCompleted() {
				System.out.println("GreetingsServiceImpl.greetAll All greetings done");
				responseObserver.onCompleted();
			}
			
		};
	}
	
	@Override
	public void greetWithDeadLine(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
		System.out.println("GreetingsServiceImpl.greetWithDeadLine: greet requested by " + request);
		Context context = Context.current();
		// mimicking real task
		for (int i = 0; i < 5; i++) {
			ThreadUtils.sleep(200);
			// enforcing to stop the work by server
			// in case deadline exceeded then even server should not work hard to continue
			// working, ignore reaming work
			if(context.isCancelled()) {
				System.out.println("GreetingsServiceImpl.greetWithDeadLine: request timed out with data: " + request);
				return;
			}
		}

		Human human = request.getHuman();
		String fullName = human.getFirstName() + " " + human.getLastName();

		// here we can only call on next only once in response observer
		// calling on next multiple times will cause exception
		responseObserver.onNext(GreetingResponse.newBuilder().setMessage("jai shree ram says " + fullName).build());

		responseObserver.onCompleted();
	}
}
