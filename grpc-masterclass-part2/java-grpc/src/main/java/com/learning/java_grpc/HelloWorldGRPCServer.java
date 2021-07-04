package com.learning.java_grpc;

import java.io.IOException;

import com.learning.java_grpc.basics.HelloWorldServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HelloWorldGRPCServer {

	public static final int PORT = 50051;

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder
							.forPort(PORT)
							.addService(new HelloWorldServiceImpl())
							.build();

		//start the server -> non blocking fire and forget
		server.start();

		System.out.println("HelloWorldGRPCServer: Server started");

		//when java application is foreced to shutdown
		//this is non blocking asd well
		Runtime.getRuntime().addShutdownHook(new Thread(() ->{
			server.shutdown();
			System.out.println("HelloWorldGRPCServer: Server shutdown");
		}));
		
		//block the main thread so that server is alive forever
		server.awaitTermination();


	}
}
