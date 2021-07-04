package com.learning.java_protobuff.innerclass;

public class PowerWithAddition {

public static void main(String[] args) {
	System.out.println(power(11, 0));
	System.out.println(powerPlus(11, 0));
	System.out.println(multiply(4, 6));
	
	System.out.println(Math.pow(11, 13));
}
	
	static long power(int number , int power) {
		long result = 1;
		for(int j = 0 ; j < power ; j++){
			result *= number;
		}
		
		return result;
	}
	
	static long powerPlus(int number , int power) {
		long result = 1;
		for(int j = 0 ; j < power ; j++){
			result  = multiply(result, number);
		}
		return result;
	}
	
	public static  long multiply(long number , int times) {
		long result = 0;
		for(int i = 0 ; i < times ; i++) {
			result = result+number;
		}
		return result;
	}
}
