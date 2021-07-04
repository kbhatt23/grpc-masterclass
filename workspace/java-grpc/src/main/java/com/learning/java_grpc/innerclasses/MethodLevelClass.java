package com.learning.java_grpc.innerclasses;

//method level classes
public class MethodLevelClass {

	public void sayHello() {
		System.out.println("jai uma shankar");
	}
	public static void main(String[] args) {
		MethodLevelClass o  = new MethodLevelClass()
				;
		o.manage();
		
		o.manageRepeatable();
	}
	public void manage() {
		//we create object and class
		//and forget about class completely
		MethodLevelClass obj = 	new MethodLevelClass() {
			public void sayHello() {
				System.out.println("jai shree ram");
			}
			
		};
		
		obj.sayHello();
		
		
		//another object
	}
	
	public void manageRepeatable() {
		//we create object and class
		//and forget about class completely
		class Adder extends MethodLevelClass {
			public void sayHello() {
				System.out.println("jai kanhayya");
			}
			
		};
		
		Adder obj = new Adder();
		
		obj.sayHello();
		
		
		//another object
		Adder obj1 = new Adder();
		obj1.sayHello();
	}
	
	public void manageRepeatableFake() {
		
		//Adder obj = new Adder();
	}
}
