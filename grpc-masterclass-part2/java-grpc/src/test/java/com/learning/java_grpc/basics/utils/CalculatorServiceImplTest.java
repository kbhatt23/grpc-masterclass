package com.learning.java_grpc.basics.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.learning.java_grpc.CalculatorGRPCServer;
import com.learning.java_grpc.basics.CalculatorServiceGrpc;
import com.learning.java_grpc.basics.FindAverageResponse;
import com.learning.java_grpc.basics.SquareRootResponse;
import com.learning.java_grpc.basics.CalculatorServiceGrpc.CalculatorServiceBlockingStub;
import com.learning.java_grpc.basics.CalculatorServiceGrpc.CalculatorServiceStub;
import com.learning.java_grpc.basics.FindAverageRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

@TestInstance(Lifecycle.PER_CLASS)
class CalculatorServiceImplTest {

	private ManagedChannel channel;
	
	private CalculatorServiceStub asyncStub;
	
	private CalculatorServiceBlockingStub blockingStub;
	
	@BeforeAll
	public void setup() {
		 channel = ManagedChannelBuilder.forAddress("localhost", CalculatorGRPCServer.PORT)
			.usePlaintext()
			.build();
			;
			
		asyncStub = CalculatorServiceGrpc.newStub(channel);
		blockingStub = CalculatorServiceGrpc.newBlockingStub(channel);
	}
	
	@AfterAll
	public void cleanup() {
		channel.shutdown();
	}

	@Test
	void average() throws InterruptedException {

		List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 6, 7, 7, 8, 3, 2, 5, 6, 67, 7, 8, 43, 5, 4, 6, 67, 3);

		double expectedAverage = numbers.stream().mapToInt(i -> i).average().orElse(-1);
		
		CountDownLatch countDownLatch = new CountDownLatch(1);

		StreamObserver<FindAverageResponse> responseObserver = new StreamObserver<FindAverageResponse>() {

			//single response recived by client
			@Override
			public void onNext(FindAverageResponse response) {
				assertEquals(expectedAverage, response.getAverage());
				assertEquals(numbers, response.getNumbersList());
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("CalculatorServiceImplTest.average: error occurred "+t.getMessage());
				countDownLatch.countDown();
			}

			@Override
			public void onCompleted() {
				countDownLatch.countDown();
			}
		};

		StreamObserver<FindAverageRequest> token = asyncStub.average(responseObserver);
		
		numbers.forEach(number -> token.onNext(FindAverageRequest.newBuilder().setNumber(number).build()));
		
		//after passing all data client says i am done, let me get final result
		token.onCompleted();
		
		countDownLatch.await();
	}
	
	@Test
	public void squareRootPositive() {
	int number = 23;
	double expected = Math.sqrt(number);
	
	SquareRootResponse squareRoot = blockingStub.squareRoot(FindAverageRequest.newBuilder().setNumber(number).build());
	
	assertEquals(number, squareRoot.getNumber());
	
	assertEquals(expected, squareRoot.getSquareRoot());
	}
	
	@Test
	public void squareRootNegative() {
	int number = -23;
	
	
	Assertions.assertThrows(StatusRuntimeException.class, () ->{
		blockingStub.squareRoot(FindAverageRequest.newBuilder().setNumber(number).build());
	});
	}

	
}
