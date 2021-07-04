package com.learning.protobuff_basics.serializers;

import com.learning.protobuff_basics.beans.SimpleMessage;

public class JsonVsProtoSimpleMessage {

	private static final String JSON_PATH = "files/jsonfile.bin";

	public static void main(String[] args) {
		
		int size = 10000;
		
		handleProto(size);
		handleJsonData(size);
	}

	private static void handleJsonData(int size) {
		long start = System.currentTimeMillis();
		JSONSerde<SelfSimpleMessage> jsonSerializer = new JSONSerde<>();
		for(int i = 0 ; i < size; i++) {
			SelfSimpleMessage item = new SelfSimpleMessage(i, "jai shree ram-"+i);
			jsonSerializer.serialize(item, JSON_PATH);
			
			SelfSimpleMessage deserialize = jsonSerializer.deserialize(JSON_PATH, SelfSimpleMessage.class);
			if(!deserialize.equals(item))
				System.out.println("wrong serialzation happened in JSON format");
		}
		
		long end  = System.currentTimeMillis();
		System.out.println("json total time taken "+(end-start) +" ms.");
	}
	
	private static void handleProto(int size) {
		long start = System.currentTimeMillis();
		MessageSerde<SimpleMessage> protoSerializer = new ProtoSerde<>();
		for(int i = 0 ; i < size; i++) {
			SimpleMessage item = SimpleMessage.newBuilder().setId(i).setMessage("jai shree ram-"+i).build();
			protoSerializer.serialize(item, JSON_PATH);
			
			SimpleMessage deserialize = protoSerializer.deserialize(JSON_PATH, SimpleMessage.class);
			if(!deserialize.equals(item))
				System.out.println("wrong serialzation happened in Proto format");
		}
		
		long end  = System.currentTimeMillis();
		System.out.println("proto total time taken "+(end-start) +" ms.");
	}
}
