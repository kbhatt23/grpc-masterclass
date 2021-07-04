package com.learning.java_grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.learning.java_grpc.bankservice.BankManagementServiceGrpc;
import com.learning.java_grpc.bankservice.BankManagementServiceGrpc.BankManagementServiceStub;
import com.learning.java_grpc.bankservice.BiDirectionalRequest;
import com.learning.java_grpc.bankservice.BiDirectionalResponse;
import com.learning.java_grpc.bankservice.DepositCashRequest;
import com.learning.java_grpc.bankservice.Money;
import com.learning.java_grpc.bankservice.QueryBalanceRequest;
import com.learning.java_grpc.bankservice.QueryBalanceResponse;
import com.learning.java_grpc.bankservice.TransferRequest;
import com.learning.java_grpc.bankservice.TransferResponse;
import com.learning.java_grpc.bankservice.WithdrawMoneyRequest;

import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankServiceTest {

	// unary stub
	private BankManagementServiceGrpc.BankManagementServiceBlockingStub blockingStub;

	// non blocking stub
	private BankManagementServiceStub asyncStub;

	// for each test we will create new cahnnel and new stub
	@BeforeAll
	public void setup() {
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext()
				//.intercept(new TimeoutInterceptor()) // adding custom interceptor
				//interceptor gets called after our stub method call
				//.intercept(MetadataUtils.newAttachHeadersInterceptor(AuthenticationClientMetadataConstant.getTokenClient()))
				.build();
		this.blockingStub = BankManagementServiceGrpc.newBlockingStub(managedChannel);
		this.asyncStub = BankManagementServiceGrpc.newStub(managedChannel);
	}

	@Order(1)
	@Test
	public void unaryBalanceTest() {
		for (int counter = 1; counter <= 10; counter++) {
			String userAccount = "User" + counter;
			QueryBalanceRequest request = QueryBalanceRequest.newBuilder().setAccontNumber(userAccount).build();
			try {
			QueryBalanceResponse balance = this.blockingStub.withWaitForReady()
					//below is also cross cutting concerns, lets use interceptor for that
					//.withDeadline(Deadline.after(1, TimeUnit.SECONDS)) //timeout exception if data does not recieved within 2 seconds
					.getBalance(request);

			// expected object
			QueryBalanceResponse expected = QueryBalanceResponse.newBuilder().setAccontBalance(100 * counter)
					.setAccontNumber(userAccount).build();

			assertEquals(expected, balance);
			}catch (Exception e) {
				//this way we are able to let other test move on
				System.out.println("exception occurred "+e.getMessage());
			}
		}

	}

	@Test
	public void blockingAmountTest() {
		System.out.println("blockingAmountTest started");
		int amountToWitdraw = 40;
		int counter = 1;
		int currency = 10;

		String accountNumber = "User" + counter;

		double initialBalance = this.blockingStub
				.getBalance(QueryBalanceRequest.newBuilder().setAccontNumber(accountNumber).build()).getAccontBalance();

		WithdrawMoneyRequest request = WithdrawMoneyRequest.newBuilder().setAccountNumber(accountNumber)
				.setAmount(amountToWitdraw).build();
		Iterator<Money> withdrawIterator = this.blockingStub.withdraw(request);

		while (withdrawIterator.hasNext()) {
			int amount = withdrawIterator.next().getAmount();
			assertEquals(currency, amount);
		}

		System.out.println("blockingAmountTest all money recieved");

		// after withdraw verify
		double remainingBalance = initialBalance - amountToWitdraw;

		double assumeddBalnace = this.blockingStub
				.getBalance(QueryBalanceRequest.newBuilder().setAccontNumber(accountNumber).build()).getAccontBalance();

		assertEquals(remainingBalance, assumeddBalnace);

	}

	@Test
	public void asyncAmountTest() {
		int amountToWitdraw = 40;
		int currency = 10;

		String accountNumber = "User1";

		double initialBalance = this.blockingStub
				.getBalance(QueryBalanceRequest.newBuilder().setAccontNumber(accountNumber).build()).getAccontBalance();

		WithdrawMoneyRequest request = WithdrawMoneyRequest.newBuilder().setAccountNumber(accountNumber)
				.setAmount(amountToWitdraw).build();
		
		CountDownLatch latch = new CountDownLatch(1);

		// it calls in async mode so main thread have to be blocked
		// once thread is free we awssume everything is done and we can validate the
		// reaminging balance
		this.asyncStub.withdraw(request, new StreamObserver<Money>() {

			@Override
			public void onNext(Money value) {
				System.out.println("asyncAmountTest: validating current money");
				assertEquals(currency, value.getAmount());
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("asyncAmountTest: error occurred " + t.getMessage());
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				System.out.println("aasyncAmountTest: all task completed");
				latch.countDown();
			}
		});

//		try {
//			Thread.sleep((((amountToWitdraw / currency) * 1000) + 1000));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("asyncAmountTest: all money recieved");

		// after withdraw verify
		double remainingBalance = initialBalance - amountToWitdraw;

		double assumeddBalnace = this.blockingStub
				.getBalance(QueryBalanceRequest.newBuilder().setAccontNumber(accountNumber).build()).getAccontBalance();

		assertEquals(remainingBalance, assumeddBalnace);

	}
	
	//stream f request and single response
	@Test
	public void streamingMoneyDeposit() {
		//async stub is non blocking and daemon so we must block runner main thread
		CountDownLatch latch = new CountDownLatch(1);
		
		StreamObserver<DepositCashRequest> depositStream = this.asyncStub.deposit(new StreamObserver<QueryBalanceResponse>() {

			@Override
			public void onNext(QueryBalanceResponse value) {
				//single on next as server send one single repsonse
				System.out.println("streamingMoneyDeposit: final balance response "+value);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("streamingMoneyDeposit: error response "+t.getMessage());
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				System.out.println("streamingMoneyDeposit: Stream response completed");
				latch.countDown();
			}
			
		});
		
		String accountNumber = "User1";
		double initialBalance = this.blockingStub.getBalance(QueryBalanceRequest.newBuilder().setAccontNumber(accountNumber).build()).getAccontBalance();
		
		//stream of request
		//every one second send 
		int counter = 4;
		int currency = 100;
		for(int i =0 ; i < counter ; i ++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			depositStream.onNext(DepositCashRequest.newBuilder().setAccountNumber(accountNumber).setAmount(currency).build());
		}
		//lets complete the request stream
		depositStream.onCompleted();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		double finalBalance = this.blockingStub.getBalance(QueryBalanceRequest.newBuilder().setAccontNumber(accountNumber).build()).getAccontBalance();
		
		assertEquals(finalBalance, initialBalance + (counter*currency));
		System.out.println("streamingMoneyDeposit: All task completed");
		
	}
	
	@Test
	public void biDirectionalLearningTest() {
		CountDownLatch latch = new CountDownLatch(1);
		StreamObserver<BiDirectionalRequest> learnBidirectionalStream = this.asyncStub.learnBidirectional(new StreamObserver<BiDirectionalResponse>() {

			@Override
			public void onNext(BiDirectionalResponse response) {

				System.out.println("biDirectionalLearningTest: response recieved "+response);
				long number = response.getNumber();
				assertEquals(number * number, response.getSquare());
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("biDirectionalLearningTest: error occurred "+t.getMessage());
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				System.out.println("biDirectionalLearningTest: All tasks completed");
				latch.countDown();
			}
		});
		
			for(int i = 1 ; i < 11 ; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				learnBidirectionalStream.onNext(BiDirectionalRequest.newBuilder().setNumber(i).build());
			}
			
			learnBidirectionalStream.onCompleted();
			
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void testTransferAmount() {
		String fromAccount = "User2";
		String toAccount = "User1";
		
		double fromAccountInitialBalance = this.blockingStub.getBalance(QueryBalanceRequest.newBuilder().setAccontNumber(fromAccount).build()).getAccontBalance();
		double toAccountInitialBalance = this.blockingStub.getBalance(QueryBalanceRequest.newBuilder().setAccontNumber(toAccount).build()).getAccontBalance();
		
		int counter = 4;
		
		int currency = 10;
		
		CountDownLatch latch  = new CountDownLatch(1);
		
		StreamObserver<TransferRequest> transferMoneyReqeuestStream = this.asyncStub.transferMoney(new StreamObserver<TransferResponse>() {

			@Override
			public void onNext(TransferResponse response) {
				System.out.println("testTransferAmount: response recieved "+response);
				assertNotNull(response.getTransactionId());
				assertEquals(currency, response.getAmount());
				assertEquals(fromAccount, response.getFromAccount());
				assertEquals(toAccount, response.getToAccount());
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("testTransferAmount: Error occurred "+t.getMessage());
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				System.out.println("testTransferAmount: All Tasks completed");
				latch.countDown();
			}
		});
		
		for(int i = 0 ; i < counter ; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			transferMoneyReqeuestStream.onNext(TransferRequest.newBuilder().setFromAccount(fromAccount)
					.setAmount(currency).setToAccount(toAccount).build()
					);
			
		}
		
		
		try {
			Thread.sleep(counter*1000+1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		transferMoneyReqeuestStream.onCompleted();
		
		//lets do management now
		
		double fromAccountNewBalance = this.blockingStub.getBalance(QueryBalanceRequest.newBuilder().setAccontNumber(fromAccount).build()).getAccontBalance();
		double toAccountNewBalance = this.blockingStub.getBalance(QueryBalanceRequest.newBuilder().setAccontNumber(toAccount).build()).getAccontBalance();		
	
		int totalTransactionCost = currency*counter;
		assertEquals(fromAccountNewBalance,fromAccountInitialBalance - totalTransactionCost);
		
		assertEquals(toAccountNewBalance,toAccountInitialBalance + totalTransactionCost);
	}
}
