package com.learning.java_grpc.bankservicerpc.loadbancer;

import java.io.IOException;

import com.learning.java_grpc.bankservicerpc.BankManagementServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class BankServiceGrpcServer1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(6565)
		   .addService(new BankManagementServiceImpl()).build();
		
		server.start();
		System.out.println("Bank management service started");
		
		server.awaitTermination();
	}
}
