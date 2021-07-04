package com.learning.java_protobuff.innerclass;

//bill pugh
public final class EagerStaticSingleton {
	
	
	private EagerStaticSingleton() {
	}
	
	//lazy
	private static class InstanceCreator{
		
		private static final EagerStaticSingleton INSTANCE = new EagerStaticSingleton();
		
	}
	
	public static EagerStaticSingleton getInstance() {
		return InstanceCreator.INSTANCE;
	}
}

