package com.learning.protobuff_basics.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ByteString;
import com.learning.protobuff_basics.beans.PayloadRequest;

public class PayLoadRequestSerdeDemo2 {

	private static final String FILE_PATH = "files/genericJsonProtoa1.bin";
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) {
		
		//Payload payload = new Payload("jai shree sita rama lakshman hanuman", String.class);
		//Payload payload = new Payload(new ObjectHolder("jai shree ram"), ObjectHolder.class);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
		StringHolder data = new StringHolder();
		data.setName("rama");
		Payload payload = new Payload(data, StringHolder.class);
		
		serialize(payload);
		
		Payload deserialize = deserialize();
		
		//System.out.println(deserialize);
		}
		long end = System.currentTimeMillis();
		System.out.println("total time taken: " + (end - start));
	}	

	private static Payload deserialize() {
		JSONSerde<Payload> protoSerializer = new JSONSerde<>();
		
		return protoSerializer.deserialize(FILE_PATH, Payload.class);
	}

	private static void serialize(Payload payload) {
		
		JSONSerde<Payload> protoSerializer = new JSONSerde<>();
		try {
			protoSerializer.serialize(payload, FILE_PATH);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
