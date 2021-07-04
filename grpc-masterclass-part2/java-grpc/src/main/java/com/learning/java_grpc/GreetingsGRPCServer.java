package com.learning.java_grpc;

import java.io.IOException;

import com.learning.java_grpc.basics.GreetingsServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GreetingsGRPCServer {
	public static final int PORT = 50051;
	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(PORT)
		             .addService(new GreetingsServiceImpl())
		             .build();
		
		
		server.start();
		
		System.out.println("GreetingsGRPCServer started at port "+PORT);
		
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			server.shutdown();
			System.out.println("GreetingsGRPCServer shutting down server");
		}));
		
		server.awaitTermination();
	}
}
