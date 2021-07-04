package com.learning.java_grpc.bankservicerpc;

import java.util.Random;

import com.learning.java_grpc.bankservice.BankManagementServiceGrpc.BankManagementServiceImplBase;
import com.learning.java_grpc.bankservice.BiDirectionalRequest;
import com.learning.java_grpc.bankservice.BiDirectionalResponse;
import com.learning.java_grpc.bankservice.DepositCashRequest;
import com.learning.java_grpc.bankservice.Money;
import com.learning.java_grpc.bankservice.QueryBalanceRequest;
import com.learning.java_grpc.bankservice.QueryBalanceResponse;
import com.learning.java_grpc.bankservice.TransferRequest;
import com.learning.java_grpc.bankservice.TransferResponse;
import com.learning.java_grpc.bankservice.WithdrawMoneyRequest;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class BankManagementServiceImpl extends BankManagementServiceImplBase{


	
	@Override
	public void getBalance(QueryBalanceRequest request, StreamObserver<QueryBalanceResponse> responseObserver) {
		//super.getBalance(request, responseObserver);
		
		//faake delay
		//so that we can demonstrate deadline/timeout
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		String accontNumber = request.getAccontNumber();
		if(!BankAccountDataBase.accountExists(accontNumber)) {
			System.out.println("getBalance: sending error data");
			Status accountBotExistStatus = Status.FAILED_PRECONDITION.withDescription("Account number "+accontNumber+" do not exist");
			responseObserver.onError(accountBotExistStatus.asException());
		}else {
			System.out.println("getBalance: sending valid data");
			QueryBalanceResponse response = QueryBalanceResponse.newBuilder().setAccontNumber(accontNumber).setAccontBalance(BankAccountDataBase.getAccountBalance(accontNumber))
			.build();
			
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}
	}
	
	@Override
	public void withdraw(WithdrawMoneyRequest request, StreamObserver<Money> responseObserver) {
		String accountNumber = request.getAccountNumber();
		int amountToWithDraw = request.getAmount();
		if(!BankAccountDataBase.accountExists(accountNumber)) {
			System.out.println("getBalance: sending error data");
			Status accountBotExistStatus = Status.FAILED_PRECONDITION.withDescription("Account number "+accountNumber+" do not exist");
			responseObserver.onError(accountBotExistStatus.asException());
			return;
		}
		if(BankAccountDataBase.getAccountBalance(accountNumber) < amountToWithDraw) {
			System.out.println("getBalance: sending error data");
			Status accountBotExistStatus = Status.FAILED_PRECONDITION.withDescription("Account number "+accountNumber+" do not have more than "+amountToWithDraw+" money");
			responseObserver.onError(accountBotExistStatus.asException());
			return;
		}
		int currency  = 10;
		for(int i = 0 ; i < amountToWithDraw/currency ; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			BankAccountDataBase.withdraw(accountNumber, currency);
			responseObserver.onNext(Money.newBuilder().setAmount(currency).build());
		}
		responseObserver.onCompleted();
	}
	
	//multiple request streams and single reponse back
	@Override
	public StreamObserver<DepositCashRequest> deposit(StreamObserver<QueryBalanceResponse> responseObserver) {

		return new StreamObserver<DepositCashRequest>() {
			
			String accountNumber;

			@Override
			public void onNext(DepositCashRequest request) {
				//no need to check deposit amount as there is no max limit
				System.out.println("deposit: depositing request "+request);
				
				String accountNumber = request.getAccountNumber();
				int amount = request.getAmount();
				//each stream request
				if(!BankAccountDataBase.accountExists(accountNumber)) {
					System.out.println("deposit: sending error data");
					Status accountBotExistStatus = Status.FAILED_PRECONDITION.withDescription("Account number "+accountNumber+" do not exist");
					responseObserver.onError(accountBotExistStatus.asException());
					return;
				}
				if(this.accountNumber == null)
					this.accountNumber = accountNumber;
				
				
				BankAccountDataBase.deposit(accountNumber, amount);
			}

			@Override
			public void onError(Throwable t) {

				System.out.println("deposit: error occurred "+t.getMessage());
				//also publish error message
				responseObserver.onError(t);
				
			}

			@Override
			public void onCompleted() {

				// all data passed so complete the response also
				// can nly apps single response in client stam grpc
				//no need to check deposit amount as there is no max limit
				System.out.println("deposit: processed deposit for account "+accountNumber);
				responseObserver.onNext(QueryBalanceResponse.newBuilder().setAccontBalance(BankAccountDataBase.getAccountBalance(this.accountNumber)).setAccontNumber(this.accountNumber).build());
				responseObserver.onCompleted();
			}
			
		};
	}
	
	@Override
	public StreamObserver<BiDirectionalRequest> learnBidirectional(
			StreamObserver<BiDirectionalResponse> responseObserver) {

		return new StreamObserver<BiDirectionalRequest>() {

			@Override
			public void onNext(BiDirectionalRequest request) {
				//on each request we can pass one response each
				//no need to wait for request stream to be completed
				
				System.out.println("learnBidirectional: finding square of "+request);
				
				long number = request.getNumber();
				responseObserver.onNext(BiDirectionalResponse.newBuilder().setNumber(number).setSquare(number * number).build());
			}

			@Override
			public void onError(Throwable t) {

				System.out.println("learnBidirectional: error occurred "+t.getMessage());
				responseObserver.onError(t);
			}

			@Override
			public void onCompleted() {

				//all requests completed
				System.out.println("learnBidirectional: All tasks completed");
				//no need to send another new onnext event as all tasks are processed already
				responseObserver.onCompleted();
			}
			
		};
	}
	
	@Override
	public StreamObserver<TransferRequest> transferMoney(StreamObserver<TransferResponse> responseObserver) {
		
		return new StreamObserver<TransferRequest>() {
			
			Random random = new Random();

			@Override
			public void onNext(TransferRequest request) {
				System.out.println("transferMoney: transform request recieved "+request);
				String fromAccount = request.getFromAccount();
				String toAccount = request.getToAccount();
				if(!BankAccountDataBase.accountExists(fromAccount)) {
					System.out.println("transferMoney: sending error data");
					Status status = Status.FAILED_PRECONDITION.withDescription("transferMoney: Account "+fromAccount+" do not exists");
					responseObserver.onError(status.asException());
					return;
				}
				
				if(!BankAccountDataBase.accountExists(toAccount)) {
					System.out.println("transferMoney: sending error data");
					Status status = Status.FAILED_PRECONDITION.withDescription("transferMoney: Account "+fromAccount+" do not exists");
					responseObserver.onError(status.asException());
					return;
				}
				
				//amount should be less than balance of fromAccount
				double transferAmount = request.getAmount();
				if(BankAccountDataBase.getAccountBalance(fromAccount) < transferAmount) {
					System.out.println("transferMoney: sending error data");
					Status status = Status.FAILED_PRECONDITION.withDescription("transferMoney: Account "+fromAccount+" do not ahve enough balance to transfr amount "+transferAmount);;
					responseObserver.onError(status.asException());
					return;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				BankAccountDataBase.deposit(toAccount, transferAmount);
				BankAccountDataBase.withdraw(fromAccount, transferAmount);
				
				responseObserver.onNext(TransferResponse.newBuilder().setAmount(transferAmount).setFromAccount(fromAccount)
						.setToAccount(toAccount).setTransactionId(
								new StringBuilder().append(fromAccount).append("-").append(toAccount)
								.append(random.nextInt())
								.toString()
								).build()
						);
				
				System.out.println("transferMoney: succesfully processed transaction for "+request);
				
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("transferMoney: Error ocurred "+t.getMessage());
			}

			@Override
			public void onCompleted() {
				System.out.println("transferMoney: all tasks completed");
				responseObserver.onCompleted();
			}
		};
		
	}
	
	
}
