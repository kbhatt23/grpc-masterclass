package com.learning.java_grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.learning.java_grpc.bankservice.BankManagementServiceGrpc;
import com.learning.java_grpc.bankservice.DepositCashRequest;
import com.learning.java_grpc.bankservice.Money;
import com.learning.java_grpc.bankservice.QueryBalanceRequest;
import com.learning.java_grpc.bankservice.QueryBalanceResponse;
import com.learning.java_grpc.bankservice.WithdrawMoneyRequest;
import com.learning.java_grpc.bankservice.BankManagementServiceGrpc.BankManagementServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankServiceLoadBalancerTest {

	// unary stub
	private BankManagementServiceGrpc.BankManagementServiceBlockingStub blockingStub;
	
	// non blocking stub
	private BankManagementServiceStub asyncStub;

	// for each test we will create new cahnnel and new stub
	@BeforeAll
	public void setup() {
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8585).usePlaintext().build();
		this.blockingStub = BankManagementServiceGrpc.newBlockingStub(managedChannel);
		this.asyncStub = BankManagementServiceGrpc.newStub(managedChannel);
	}

	@Test
	public void unaryBalanceTest() {
		for (int counter = 1; counter <= 10; counter++) {
			String userAccount = "User" + counter;
			QueryBalanceRequest request = QueryBalanceRequest.newBuilder().setAccontNumber(userAccount).build();

			QueryBalanceResponse balance = this.blockingStub.withWaitForReady().getBalance(request);

			// expected object
			QueryBalanceResponse expected = QueryBalanceResponse.newBuilder().setAccontBalance(100 * counter)
					.setAccontNumber(userAccount).build();

			assertEquals(expected, balance);
		}

	}

	@Test
	public void unaryBalanceTestAutoSchedule() {

		for (int counter = 1; counter <= 10; counter++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String userAccount = "User" + counter;
			QueryBalanceRequest request = QueryBalanceRequest.newBuilder().setAccontNumber(userAccount).build();

			QueryBalanceResponse balance = this.blockingStub.withWaitForReady().getBalance(request);

			// expected object
			QueryBalanceResponse expected = QueryBalanceResponse.newBuilder().setAccontBalance(100 * counter)
					.setAccontNumber(userAccount).build();

			assertEquals(expected, balance);
		}

	}
	
	//stream f request and single response
		@Test
		public void streamingMoneyDepositLoadBalance() {
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
			
			String accountNumber = "User" + ThreadLocalRandom.current().nextInt(1, 11);
			
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
			
			
			System.out.println("streamingMoneyDepositLoadBalance: All task completed");
			
		}
	
	

}
