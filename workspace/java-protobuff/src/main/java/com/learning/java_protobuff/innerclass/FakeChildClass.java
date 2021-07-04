package com.learning.java_protobuff.innerclass;

public class FakeChildClass extends SelfInnerClass{
	
	@Override
	public void waah() {
		System.out.println("jai radha amdhav");
	}
	
	public static void main(String[] args) {
		FakeChildClass obj = new FakeChildClass();
	}
}
