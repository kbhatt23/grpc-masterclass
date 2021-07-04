package com.learning.java_grpc.miscellaneous;

public class ReverseString {

	public static void main(String[] args) {
		
		String str= "kanishk";
		
		String reverse = "";
		for(int i = 0 ; i < str.length() ; i++) {
			reverse = str.charAt(i)+reverse ;
		}
		
		System.out.println(reverse);
	}
}
