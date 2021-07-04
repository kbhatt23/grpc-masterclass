package com.learning.java_grpc.innerclasses;

import java.io.Serializable;

import com.learning.java_grpc.innerclasses.SelfOuterClass.SelfInnerClass;
import com.learning.java_grpc.innerclasses.SelfOuterClass.SelfInnerStaticClass;

public class SelfOuterClassUSage {

	public static void main(String[] args) {
		SelfOuterClass outer=  new SelfOuterClass();
		
		SelfInnerClass inner = outer.new SelfInnerClass();
		
		inner.manageInner();
		
		outer.manageOuter();
		
		
		SelfInnerStaticClass staticObj = new SelfInnerStaticClass();
		
		staticObj.manageInner();
	}
}

enum WaahEnum /* extends SelfOuterClassUSage */implements Serializable {
	
}
