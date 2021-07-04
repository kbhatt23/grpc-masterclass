package com.learning.protobuff_basics.serializers;

import com.learning.protobuff_basics.beans.EvolvableMessageOuterClass.EvolvableMessage;

public class EvolvableMessageTest {

	private static final String JSON_PATH = "files/jsonfile.bin";
	private static final MessageSerde<EvolvableMessage> serde = new ProtoSerde<>();
	

	public static void main(String[] args) {
		
		handleSerialization();
		//handleDeserialization();
	}

	
	private static void handleSerialization() {
		EvolvableMessage message = EvolvableMessage.newBuilder().setId(1)
		    .setFirstName("sita-ram")
		    .setLastName("ichwaku")
		    //in compatibility mode it will go away
		    //.setMiddleName("wooh")
		    .build();
		
		
		serde.serialize(message, JSON_PATH);
	}
	
	private static void handleDeserialization() {
		
		EvolvableMessage deserialize = serde.deserialize(JSON_PATH, EvolvableMessage.class);
		System.out.println("deserialized object: "+deserialize);
		//extra popertyinconsumer but that proeprty wotn exist in producer
		//so it wi set deafault vaue to nth level, here it is empty string
		//System.out.println("middle name "+deserialize.getMiddleName()+" with lenght "+deserialize.getMiddleName().length());
	}
}
