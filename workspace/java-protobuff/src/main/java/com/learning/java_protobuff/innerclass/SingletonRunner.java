package com.learning.java_protobuff.innerclass;

public class SingletonRunner {

	public static void main(String[] args) {
		 EagerStaticSingleton instance = EagerStaticSingleton.getInstance();
		 
		 EagerStaticSingleton instance2 = EagerStaticSingleton.getInstance();
		 
		 EagerStaticSingleton instance3 = EagerStaticSingleton.getInstance();
		 
		 System.out.println(instance.hashCode());
		 
		 System.out.println(instance2.hashCode());
		 
		 System.out.println(instance3.hashCode());
	}
}
