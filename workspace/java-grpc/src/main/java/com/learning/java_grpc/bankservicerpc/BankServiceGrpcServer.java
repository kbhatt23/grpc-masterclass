package com.learning.java_grpc.bankservicerpc;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class BankServiceGrpcServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(6565)
		   .addService(new BankManagementServiceImpl())
		   .intercept(new AuthenticationServerInterceptor()) // will get called before it calls our rpc service method
		   .build();
		
		server.start();
		System.out.println("Bank management service started");
		
		server.awaitTermination();
	}
}
