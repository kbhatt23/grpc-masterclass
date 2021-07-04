package com.learning.java_grpc.bankservicerpc;

import java.io.IOException;

import com.learning.java_grpc.snakeladdergrpc.SnakeLadderServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class SnakeLadderServiceGRPCServer {

	public static void main(String[] args) throws InterruptedException, IOException {
		Server server = ServerBuilder.forPort(9000).addService(new SnakeLadderServiceImpl()).build();
		
		server.start();
		
		System.out.println("Snake ladder service started");
		server.awaitTermination();
		
		
	}
}
