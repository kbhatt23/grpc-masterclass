package com.learning.java_grpc.basics.utils;

import com.learning.java_grpc.basics.FindAverageRequest;
import com.learning.java_grpc.basics.FindAverageResponse;
import com.learning.java_grpc.basics.SquareRootResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import io.grpc.Status;
import com.learning.java_grpc.basics.CalculatorServiceGrpc.CalculatorServiceImplBase;

import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceImplBase{

	
	@Override
	public StreamObserver<FindAverageRequest> average(StreamObserver<FindAverageResponse> responseObserver) {
		return new StreamObserver<FindAverageRequest>() {

			AtomicInteger size ;
			
			AtomicLong sum ;
			
			List<Integer> numbers;
			
			//what to do when client sends one request data
			@Override
			public void onNext(FindAverageRequest request) {
				int number = request.getNumber();
				System.out.println("CalculatorServiceImpl: number recieved "+number);
				if(size == null)
					size = new AtomicInteger();
				
				size.getAndIncrement();
				
				if(sum == null)
					sum = new AtomicLong();
				sum.addAndGet(number);
				
				if(numbers == null)
					numbers = new ArrayList<>();
				
				numbers.add(number);
			}

			@Override
			public void onError(Throwable t) {
				String message = "CalculatorServiceImpl: error occurred "+t.getMessage();
				System.out.println(message);
				responseObserver.onError(new IllegalStateException(message));
			}

			@Override
			public void onCompleted() {
				System.out.println("CalculatorServiceImpl: average calcualtion completed");
				double average = sum.get()/size.get();
				responseObserver.onNext(FindAverageResponse.newBuilder().setAverage(average).addAllNumbers(numbers).build());
				
				responseObserver.onCompleted();
			}
			
		};
	}
	
	@Override
	public void squareRoot(FindAverageRequest request, StreamObserver<SquareRootResponse> responseObserver) {
		int number = request.getNumber();
		System.out.println("CalculatorServiceImpl.squareRoot: requested by number "+number);
		
		if(number < 0) {
			String error = "CalculatorServiceImpl.squareRoot: negative number passed "+number;
			responseObserver.onError(Status.FAILED_PRECONDITION.withDescription(error).asException());
			System.out.println(error);
		}else {
			double sqrt = Math.sqrt(number);
			responseObserver.onNext(SquareRootResponse.newBuilder().setNumber(number).setSquareRoot(sqrt).build());
			responseObserver.onCompleted();
		}
	}
}
