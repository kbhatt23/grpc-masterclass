package com.learning.java_grpc.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.learning.java_grpc.HelloWorldGRPCServer;
import com.learning.java_grpc.beans.basics.HelloWorldRequest;
import com.learning.java_grpc.beans.basics.HelloWorldResponse;
import com.learning.java_grpc.beans.basics.HelloWorldServiceGrpc;
import com.learning.java_grpc.beans.basics.HelloWorldServiceGrpc.HelloWorldServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

//no need of static methods for setup and cleaup
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HelloWorldServiceImplTest {
	
	private HelloWorldServiceBlockingStub blockingStub ;
	
	private ManagedChannel channel;

	//just call once beofer all the test
	@BeforeAll
	public void setup() {
		//we create one channel for each client adn server pair -> can be subschanneled
		channel = ManagedChannelBuilder.forAddress("localhost", HelloWorldGRPCServer.PORT)
		                      .usePlaintext() // disable ssl for dev/local environment
		                      .build();
		
		blockingStub = HelloWorldServiceGrpc.newBlockingStub(channel);
	}
	
	@Test
	void sayHello() {

		String name = "sita-ram";
		HelloWorldRequest request = HelloWorldRequest.newBuilder().setName(name).build();
		
		HelloWorldResponse response = blockingStub.sayHello(request);
		
		assertEquals("hello "+name, response.getMessage());
	}
	
	@AfterAll
	public void cleanup() {
		channel.shutdown();
	}
}
