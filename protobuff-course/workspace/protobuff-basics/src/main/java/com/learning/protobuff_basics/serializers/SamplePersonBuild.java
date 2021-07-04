package com.learning.protobuff_basics.serializers;

import java.util.Arrays;

import com.learning.protobuff_basics.beans.Address;

import com.learning.protobuff_basics.beans.Person;
import com.learning.protobuff_basics.beans.Person.NestedGender;

public class SamplePersonBuild {

	public static void main(String[] args) {
		
		Person person = Person.newBuilder()
		   .setFirstName("sita-ram")
//		   .setLastName("")  no last name 
		   .setAge(101)
		   .addEmails("debuisrambhakt@gmail.com")
		   .addEmails("kanishkiskrishnabhkat@gmail.com")
		   .addAllEmails(Arrays.asList("k2@gmail.com","lifeisgood@gmail.com"))
		  // .setGender(NestedGender.MALE)
		   .setHeight(1008d)
		  // .setAddress(Address.newBuilder().setAddress1("one").setCity("delhi").setCountry("IN").build())
		   .build();
		
		
		System.out.println(person);
		
		//address will be set as empty object
		//meaning an adress object with "" string proeprties
		System.out.println("address state length "+person.getAddress().getState().length());
		System.out.println("lastname length "+person.getLastName().length());
		System.out.println("gender is "+person.getGender()); // alawys returns 0th tagged enum whihcis unknown
	}
}
