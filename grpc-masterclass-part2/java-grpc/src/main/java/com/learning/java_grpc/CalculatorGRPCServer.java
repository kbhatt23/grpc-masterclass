package com.learning.java_grpc;

import java.io.IOException;

import com.learning.java_grpc.basics.utils.CalculatorServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class CalculatorGRPCServer {

	public static final int PORT = 50015;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Server server = ServerBuilder.forPort(PORT)
		      .addService(new CalculatorServiceImpl())
		      .build();
		server.start();
		
		
		System.out.println("CalculatorGRPCServer: server started at port "+PORT);
		
		//once java application is forced to shutdown , lets shutdown the server
		Runtime.getRuntime().addShutdownHook(new Thread(() ->{
			System.out.println("CalculatorGRPCServer: shutting down server");
			server.shutdown();
		}));
		
		//once shutdown hook calls the shutdown it is freed
		server.awaitTermination();
	}
}
