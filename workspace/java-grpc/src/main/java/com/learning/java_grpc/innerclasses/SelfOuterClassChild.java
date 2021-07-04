package com.learning.java_grpc.innerclasses;

public class SelfOuterClassChild extends SelfOuterClass{

	
	public static void main(String[] args) {
		SelfOuterClassChild obj = new SelfOuterClassChild();
		obj.name = "sita-ram";
		
		System.out.println(obj.name);
		
		//private not accesible
		//System.out.println(obj.id);
		
	}
}
