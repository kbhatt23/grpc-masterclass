package com.learning.protobuff_basics.serializers;

import com.learning.protobuff_basics.beans.SimpleEmployee;

public class SimpleEmployeeBadTags {

	private static final String FILES_EMPLOYEE_BIN = "files/employee.bin";

	public static void main(String[] args) {
		SimpleEmployee employee = SimpleEmployee.newBuilder().setId(1).setFirstName("krishna").setLastName("kanhayya").build();
		
		//this willserialzie like
		//1 - 1
		//2 - krishna
		//3 - kanhayya
		//in short serialzation uses tag and not field name
		
		//during serizlation it maps the tag and copy value to that field mapping the tag
		
		MessageSerde<SimpleEmployee> serde = new ProtoSerde<>();
		
		//serde.serialize(employee, FILES_EMPLOYEE_BIN);
		
		System.out.println("emp to serailze "+employee);
		
		SimpleEmployee deserialize = serde.deserialize(FILES_EMPLOYEE_BIN, SimpleEmployee.class);
		System.out.println("deserizlaed employee "+deserialize);
		
		System.out.println("are objects equal "+(deserialize.equals(employee)));
		
	}
}
