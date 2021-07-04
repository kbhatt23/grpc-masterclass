package com.learning.java_grpc.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.learning.java_grpc.GreetingsGRPCServer;
import com.learning.java_grpc.basics.GreetingsServiceGrpc.GreetingsServiceBlockingStub;
import com.learning.java_grpc.basics.GreetingsServiceGrpc.GreetingsServiceStub;
import com.learning.java_grpc.basics.utils.ThreadUtils;

import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

@TestInstance(Lifecycle.PER_CLASS)
class GreetingsServiceImplTest {
	private static final String SPACE = " ";

	private ManagedChannel channel;
	
	private GreetingsServiceBlockingStub blockingStub ;
	
	private GreetingsServiceStub asyncStub;
	@BeforeAll
	public void setup() {
		channel = ManagedChannelBuilder.forAddress("localhost", GreetingsGRPCServer.PORT)
								.usePlaintext()
								.build();
		blockingStub = GreetingsServiceGrpc.newBlockingStub(channel);
		asyncStub = GreetingsServiceGrpc.newStub(channel);
	}
	
	@AfterAll
	public void cleanup() {
		channel.shutdown();
	}
	
	@Test
	void greet() {
		String firstName = "kanishk";
		String lastName = "bhatt";
		
		GreetingResponse response = blockingStub.greet(GreetingRequest.newBuilder()
								.setHuman(Human.newBuilder()
										.setFirstName(firstName)
										.setLastName(lastName).build())
								.build());
		
		assertEquals("jai shree ram says "+firstName+SPACE+lastName, response.getMessage());
	}
	@Test
	void greetRepeatedly() throws InterruptedException {
		List<String> fullNames = Arrays.asList("kanishk bhatt","sita ram", "lekshmi narayan","uma mahesh");
		
		List<Human> humans = fullNames.stream()
		         .map(fullName -> fullName.split(SPACE))
		         .map(names -> Human.newBuilder().setFirstName(names[0])
		        		 .setLastName(names[1]).build())
		         .collect(Collectors.toList());
		
		MultipleGreetingRequest request = MultipleGreetingRequest.newBuilder().addAllHumans(humans).build();
		
		CountDownLatch latch = new CountDownLatch(1);
		
		//remember the stream is always ordered
		//hence the reqponse will always be ordered, it ensures that the order response is ordered
		
		//we must know that items come in a stream so we need observers
		//this call is non blocing and async like daemon threads
		asyncStub.greetRepeatedly(request, new StreamObserver<GreetingResponse>() {
			
			private AtomicInteger counter = new AtomicInteger();
			
			@Override
			public void onNext(GreetingResponse response) {
			//	System.out.println("message recieved "+response.getMessage());
				assertEquals("jai shree ram says "+fullNames.get(counter.getAndIncrement()),response.getMessage());
			}
			
			@Override
			public void onError(Throwable t) {
				//System.out.println("error occurred "+t.getMessage());
			}
			
			@Override
			public void onCompleted() {
				//System.out.println("all greetings recieved");
				assertEquals(fullNames.size(), counter.get());
				latch.countDown();
			}
		});
		
		latch.await();
	}
	

	@Test
	public void greetForLong() throws InterruptedException {
		List<String> fullNames = Arrays.asList("kanishk bhatt","sita ram", "lekshmi narayan","uma mahesh");
		String expectedMessage = fullNames.stream()
										.map(name -> "jai shree ram says "+name)
										.collect(Collectors.joining(","));
		
		CountDownLatch latch = new CountDownLatch(1);
		
		StreamObserver<GreetingResponse> responseObserver = new StreamObserver<GreetingResponse>() {
			AtomicInteger counter = new AtomicInteger();
			//will get called only once at the end when all data is passed
			@Override
			public void onNext(GreetingResponse response) {
				counter.incrementAndGet();
				assertEquals(expectedMessage, response.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("greetForLong: error occurred "+t.getMessage());
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				latch.countDown();
				//only one response recieved by server
				assertEquals(1, counter.get());
			}
		};
		
		//toekn for client to send multiple requests
		StreamObserver<GreetingRequest> token = asyncStub.greetForLong(responseObserver);
		fullNames.stream()
		    .forEach(name -> {
		    	String[] names = name.split(SPACE);
		    	token.onNext(GreetingRequest.newBuilder()
		    				.setHuman(Human.newBuilder()
		    							.setFirstName(names[0]).setLastName(names[1]).build())
		    				.build());
		    	ThreadUtils.sleep(1000);
		    });
		
		//we have to tell server taht we are done
		token.onCompleted();
		
		latch.await();
	}
	
	
	@Test
	public void greetAll() throws InterruptedException {
		List<String> fullNames = Arrays.asList("kanishk bhatt","sita ram", "lekshmi narayan","uma mahesh");
		
		CountDownLatch latch = new CountDownLatch(1);
		
		StreamObserver<GreetingResponse> responseObserver =  new StreamObserver<GreetingResponse>() {

			AtomicInteger counter;
			
			@Override
			public void onNext(GreetingResponse response) {
				if(counter == null)
					counter = new AtomicInteger();
				
				assertEquals("jai shree ram says "+fullNames.get(counter.getAndIncrement()), response.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				latch.countDown();
				assertEquals(fullNames.size(), counter.get());
			}
		};
		StreamObserver<GreetingRequest> token = asyncStub.greetAll(responseObserver);
		
		fullNames.forEach(name -> token.onNext(GreetingRequest.newBuilder().setHuman(Human.newBuilder().setFirstName(name.split(" ")[0])
				.setLastName(name.split(" ")[1])
				.build()).build()));
		
		token.onCompleted();
		
		latch.await();
	}
	
	@Test
	public void greetWithDeadLineSuccess() {
		String name = "kanishk bhatt";
		String[] names = name.split(SPACE);
		GreetingResponse response = blockingStub.withDeadline(Deadline.after(2000, TimeUnit.MILLISECONDS))
		      .greetWithDeadLine(GreetingRequest.newBuilder().setHuman(Human.newBuilder().setFirstName(names[0]).setLastName(names[1]).build()).build())
		      
		      ;
		
		assertEquals("jai shree ram says "+name, response.getMessage());
	}
	
	@Test
	public void greetWithDeadLineError() {
		String name = "kanishk bhatt";
		String[] names = name.split(SPACE);
		
		//deadlineexceeded exception is expected -> similar to timeout exception
		Assertions.assertThrows(Status.DEADLINE_EXCEEDED.asRuntimeException().getClass(), () -> {
			GreetingResponse response = blockingStub.withDeadline(Deadline.after(500, TimeUnit.MILLISECONDS))
				      .greetWithDeadLine(GreetingRequest.newBuilder().setHuman(Human.newBuilder().setFirstName(names[0]).setLastName(names[1]).build()).build())
				      
				      ;
		});
		
	}
}
