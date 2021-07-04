package com.learning.java_grpc.bankservicerpc;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//for each method first check accountExists method
public class BankAccountDataBase {

	private static final Map<String, Double> balanceMap;
	
	static {
		balanceMap =IntStream.rangeClosed(1, 10)
		        .boxed()
		        .collect(Collectors.toMap(i -> "User"+i,  i -> i * 100d));
		
	}
	
	public static double getAccountBalance(String accountNumber)
	{
		
		return balanceMap.get(accountNumber);
	}
	
	public static boolean accountExists(String accountNumber) {
		return balanceMap.containsKey(accountNumber);
	}
	
	public static void deposit(String accountNumber , double amount) {
		balanceMap.computeIfPresent(accountNumber, (account,balance) -> balance+ amount);
	}
	
	public static void withdraw(String accountNumber , double amount) {
		balanceMap.computeIfPresent(accountNumber, (account,balance) -> balance -  amount);
	}
	
}
