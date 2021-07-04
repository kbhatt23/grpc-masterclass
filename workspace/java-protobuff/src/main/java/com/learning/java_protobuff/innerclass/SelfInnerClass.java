package com.learning.java_protobuff.innerclass;

//lexical scope
public class SelfInnerClass {
	
	private String id;
	
	public String name;
	
	private static String staticProperty = "static property";
	
	
	static {
		System.out.println("outer class ki static call");
		
	}
	
	
	public InnerClassAnder reference;
	
	public SelfInnerClass() {
		reference= new InnerClassAnder();
	}
	
	public void waah() {
		System.out.println("jai shree ram with public inner "+reference.innerclassPublic);
	}
	
	//innner class
	class InnerClassAnder{
		
		public void printPrivate(){
			System.out.println("private print "+id);
		}
		
		private int innerclassPrivate = 99;
		public int innerclassPublic = 108;
	}
	//static inner class can access static fields of outer class
	//staic inner class ca exist independetly
	static class InnerStaticAnder{
		//both static and non static method can exist
		
		static {
			System.out.println("inner static class ki static call");
			
		}
		
		public void printPrivate(){
			System.out.println("static private print "+staticProperty);
		}
		
		public static void printPrivateStatic(){
			System.out.println("stacic method of static inner class");
		}

	}
}
