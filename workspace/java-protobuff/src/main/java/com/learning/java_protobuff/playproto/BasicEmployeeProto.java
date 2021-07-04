package com.learning.java_protobuff.playproto;

import com.learning.java_protobuff.beans.Person;

public class BasicEmployeeProto {

	public static void main(String[] args) {
		Person build = Person.newBuilder().setAge(100).setName("krishna").build();
		
		System.out.println("built person "+build);
	}
}
