package com.learning.java_grpc.basics;

import com.learning.java_grpc.beans.basics.HelloWorldRequest;
import com.learning.java_grpc.beans.basics.HelloWorldResponse;
import com.learning.java_grpc.beans.basics.HelloWorldServiceGrpc.HelloWorldServiceImplBase;

import io.grpc.stub.StreamObserver;

public class HelloWorldServiceImpl extends HelloWorldServiceImplBase{

	@Override
	public void sayHello(HelloWorldRequest request, StreamObserver<HelloWorldResponse> responseObserver) {
		System.out.println("HelloWorldServiceImpl: sayHello called for request "+request);
		
		responseObserver.onNext(HelloWorldResponse.newBuilder().setMessage("hello "+request.getName()).build());
		
		responseObserver.onCompleted();
	}
}
