package com.learning.java_grpc;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.learning.java_grpc.snakeladder.RegisterUserRequest;
import com.learning.java_grpc.snakeladder.RegisterUserResponse;
import com.learning.java_grpc.snakeladder.SnakeLadderDashBoard;
import com.learning.java_grpc.snakeladder.SnakeLadderRequest;
import com.learning.java_grpc.snakeladder.SnakeLadderResponse;
import com.learning.java_grpc.snakeladder.SnakeLadderServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SnakeLadderServiceTest {

	private SnakeLadderServiceGrpc.SnakeLadderServiceBlockingStub blockingStub;
	private SnakeLadderServiceGrpc.SnakeLadderServiceStub asyncStub;

	@BeforeAll
	public void setup() {
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
		this.blockingStub = SnakeLadderServiceGrpc.newBlockingStub(managedChannel);

		this.asyncStub = SnakeLadderServiceGrpc.newStub(managedChannel);
	}

	@Test
	public void registerAndPlayGame() {
		int numberOfUSers = 5;
		// 5 users => unary blocking
		for (int i = 0; i < numberOfUSers; i++) {
			RegisterUserResponse registerUserResponse = this.blockingStub
					.registerUser(RegisterUserRequest.newBuilder().setName("User" + i).build());
			System.out.println("registerAndPlayGame: User registration response " + registerUserResponse);
		}

		AtomicBoolean isGameOver = new AtomicBoolean(false);

		StreamObserver<SnakeLadderRequest> requestStream = this.asyncStub
				.playGame(new StreamObserver<SnakeLadderResponse>() {

					@Override
					public void onNext(SnakeLadderResponse response) {
						if (!response.getIsValidUser()) {
							System.out.println("registerAndPlayGame: invalid user passed");
						} else {
							List<SnakeLadderDashBoard> dashboardList = response.getDashboardList();
							if (dashboardList != null && !dashboardList.isEmpty()) {
								System.out.println("registerAndPlayGame: current dashboard " + dashboardList.stream()
										.map(entry -> entry.getName() + " : " + entry.getPosition())
										.collect(Collectors.joining(" , ")));
								System.out.println("==============================");
							}
						}

					}

					@Override
					public void onError(Throwable t) {
						System.out.println("registerAndPlayGame: error occurred " + t);
						isGameOver.set(true);
					}

					@Override
					public void onCompleted() {
						System.out.println("registerAndPlayGame: game completed");
						isGameOver.set(true);
					}
				});

		while (!isGameOver.get()) {
			for (int i = 0; i < numberOfUSers; i++) {
				requestStream.onNext(SnakeLadderRequest.newBuilder().setName("User" + i).build());
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		// remeberd it will never end until task is actually completed by server, on
		// next only


		System.out.println("game completed");

	}
}
