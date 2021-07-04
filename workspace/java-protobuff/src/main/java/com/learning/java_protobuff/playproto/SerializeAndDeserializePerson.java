package com.learning.java_protobuff.playproto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.learning.java_protobuff.beans.Person;

public class SerializeAndDeserializePerson {

	public static void main(String[] args) {
		
		Person person = Person.newBuilder().setAge(101).setName("kanhayya").build();
		
		System.out.println("person before serialization "+person);
		
		Path path = Paths.get("serialized/person.ser");
	
		try {
			//always clean up before new run
			Files.deleteIfExists(path);
			Files.write(path,person.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//deserialzation
		try {
			byte[] readAllBytes = Files.readAllBytes(path);
			Person deserailzedPerson = Person.parseFrom(readAllBytes);
			System.out.println("deserialized person "+deserailzedPerson );
			System.out.println("are both equals "+(deserailzedPerson.equals(person)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
