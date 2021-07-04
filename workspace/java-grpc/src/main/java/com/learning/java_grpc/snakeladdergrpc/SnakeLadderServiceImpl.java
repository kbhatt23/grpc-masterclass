package com.learning.java_grpc.snakeladdergrpc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.learning.java_grpc.snakeladder.RegisterUserRequest;
import com.learning.java_grpc.snakeladder.RegisterUserResponse;
import com.learning.java_grpc.snakeladder.SnakeLadderDashBoard;
import com.learning.java_grpc.snakeladder.SnakeLadderRequest;
import com.learning.java_grpc.snakeladder.SnakeLadderResponse;
import com.learning.java_grpc.snakeladder.SnakeLadderServiceGrpc.SnakeLadderServiceImplBase;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class SnakeLadderServiceImpl extends SnakeLadderServiceImplBase {

	private static final int BOARD_SIZE = 100;

	private static final Map<String, Integer> USERS_POSITION = new HashMap<>();

	private static final Map<Integer, Integer> LADDER_POSITIONS;

	private static final Map<Integer, Integer> SNAKE_POSITIONS;

	static {
		LADDER_POSITIONS = new HashMap<>();
		LADDER_POSITIONS.put(4, 14);
		LADDER_POSITIONS.put(8, 30);
		LADDER_POSITIONS.put(28, 76);
		LADDER_POSITIONS.put(21, 42);
		LADDER_POSITIONS.put(50, 67);
		LADDER_POSITIONS.put(71, 91);
		LADDER_POSITIONS.put(88, 99);

		SNAKE_POSITIONS = new HashMap<>();
		SNAKE_POSITIONS.put(32, 10);
		SNAKE_POSITIONS.put(36, 6);
		SNAKE_POSITIONS.put(62, 18);
		SNAKE_POSITIONS.put(88, 24);
		SNAKE_POSITIONS.put(95, 56);
		SNAKE_POSITIONS.put(97, 78);
		SNAKE_POSITIONS.put(48, 26);
	}

	// unary blovckign let each user register one by one and get respond back one by
	// one
	@Override
	public void registerUser(RegisterUserRequest request, StreamObserver<RegisterUserResponse> responseObserver) {

		// username is nul or empty or already registered
		String name = request.getName();
		if (name == null || name.isEmpty() || USERS_POSITION.containsKey(name)) {
			String errorMessage = "registerUser: Invalid username passed " + name;
			System.out.println(errorMessage);
			responseObserver.onError(Status.FAILED_PRECONDITION.withDescription(errorMessage).asException());
			return;
		}

		// assuming each have to get 1 or 6 once game starts
		USERS_POSITION.put(name, -1);

		RegisterUserResponse response = RegisterUserResponse.newBuilder().setName(name).setUserId(name).build();
		System.out.println("registerUser: user registration done for " + response);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<SnakeLadderRequest> playGame(StreamObserver<SnakeLadderResponse> responseObserver) {
		return new StreamObserver<SnakeLadderRequest>() {
			String winner;

			@Override
			public void onNext(SnakeLadderRequest request) {
				System.out.println("=======================================");
				
				String name = request.getName();
				if (name == null || name.isEmpty() || !USERS_POSITION.containsKey(name)) {
					String errorMessage = "playGame: Invalid username passed " + name;
					System.out.println(errorMessage);
					// can not do this as on error stream is cancelled
					// however after filter bad user we need to continue with other new sream
					// requests, so sending on next messag with errorfalg as true
					// responseObserver.onError(Status.FAILED_PRECONDITION.withDescription(errorMessage).asException());
					// no need to let him see the user dashboard, jut tell u r invalid user
					responseObserver.onNext(SnakeLadderResponse.newBuilder().setIsValidUser(false).build());
					return;
				}
				// play dice
				int diceResult = ThreadLocalRandom.current().nextInt(1, 7);
				int currentPosition = USERS_POSITION.get(name);
				// first step ,
				if (currentPosition == -1) {
					if (diceResult == 1 || diceResult == 6) {
						System.out.println("playGame: user " + name + " started its game at position 1");
						USERS_POSITION.put(name, 1);
					} else {
						System.out.println("playGame: user " + name + " must wait for next chance");
					}
					// send every players position
					sendDashboardMEssage(responseObserver);
					return;
				}

				int newPosition = diceResult + currentPosition;
				if (newPosition == BOARD_SIZE) {
					USERS_POSITION.put(name, newPosition);
					// complete the game
					winner = name;
					sendDashboardMEssage(responseObserver);
					onCompleted();
				} else if (newPosition > BOARD_SIZE) {
					// can not update position
					System.out.println("playGame: user " + name + " must wait for next chance");
					sendDashboardMEssage(responseObserver);
				} else {
					// still in game
					// check for ladder and snake
					if (LADDER_POSITIONS.containsKey(newPosition)) {
						System.out.println("playGame: user " + name + " uses ladder from " + newPosition + " to reach "
								+ LADDER_POSITIONS.get(newPosition) + " with dice " + diceResult);
						USERS_POSITION.put(name, LADDER_POSITIONS.get(newPosition));
					} else if (SNAKE_POSITIONS.containsKey(newPosition)) {
						System.out.println("playGame: user " + name + " uses snake from " + newPosition + " to reach "
								+ SNAKE_POSITIONS.get(newPosition) + " with dice " + diceResult);
						USERS_POSITION.put(name, SNAKE_POSITIONS.get(newPosition));
					} else {
						System.out.println(
								"playGame: user " + name + " reaches " + newPosition + " with dice " + diceResult);
						USERS_POSITION.put(name, newPosition);
					}
					sendDashboardMEssage(responseObserver);
				}
				

			}

			private void sendDashboardMEssage(StreamObserver<SnakeLadderResponse> responseObserver) {
				List<SnakeLadderDashBoard> dashboards = USERS_POSITION.entrySet().stream()
						.map(entry -> SnakeLadderDashBoard.newBuilder().setName(entry.getKey())
								.setPosition(entry.getValue()).build())
						.collect(Collectors.toList());
				SnakeLadderResponse response = SnakeLadderResponse.newBuilder().setIsValidUser(true)
						.addAllDashboard(dashboards).build();

				responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("playGame: error occurred " + t);
				responseObserver.onError(t);
			}

			@Override
			public void onCompleted() {
				System.out.println("playGame: game completed, winner is  " + winner);
				responseObserver.onCompleted();
			}
		};
	}

}
