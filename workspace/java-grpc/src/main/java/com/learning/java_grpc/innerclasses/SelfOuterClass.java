package com.learning.java_grpc.innerclasses;
//public or default only
public class SelfOuterClass {

	private int id = 1;
	
	public String name = "radhe-krishna";
	
	private static String property = "jai radha madhav";
	
	private SelfInnerClass innerInstance;
	
	public SelfOuterClass() {
		innerInstance = new SelfInnerClass();
	}
	
	
	public void manageOuter() {
		//private fields are accesible
		//but we need instance of inner class as reference
		System.out.println("outer id "+id+" outer name "+name+" inner id "+innerInstance.id+" inner name "+innerInstance.name);
	}
	
	//inner class can be private as well as public or default
	//it can access private intance variable fo main outer class , without creating instance of outer class
	//however we can not create instance of inner class withoujt instance of outer class
	//outer class can view private fields of inner class, but only after creating instance of inner class
	public class SelfInnerClass{
		
		private int id = 11;
		
		public String name = "waah inner";
		
		public void manageInner() {
			System.out.println("innerID "+this.id+" and innername "+this.name+" outer id "+SelfOuterClass.this.id+" outer name "+
					SelfOuterClass.this.
					name);
		}
	}
	
	//static class can also be private, public or default or prorecetd
	// static class can have static as well as instance variable inside it
	//but static inner class object can be created without creating outer object
	//hence static inner class can not access instance variable for outer class directly
	//however it can hold reference and use it
	//all the static variale of ouyter calss are visible to static inner class
	
	public static class SelfInnerStaticClass{
		
		private int innerID = 11;
		
		public String innerName = "waah inner";
		
		private SelfOuterClass selfOuterClass;
		
		public SelfInnerStaticClass() {
			this.selfOuterClass = new SelfOuterClass();
		}
		
		//refernec is needed
		//static proeprty of outer class directly visible
		
		public void manageInner() {
			System.out.println("innerID "+innerID+" and innername "+innerName+" outer id "+selfOuterClass.id+" outer name "+selfOuterClass.name
					+" outer static proeprty "+ property
					);
			
			
		}
	}
}
