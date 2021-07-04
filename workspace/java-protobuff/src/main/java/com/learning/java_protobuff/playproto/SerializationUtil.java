package com.learning.java_protobuff.playproto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.AbstractMessageLite;
import com.learning.java_protobuff.beans.Person;

public class SerializationUtil {

	public static final String JSON_PATH_STR = "serialized/jperson-01.ser";
	
	public static final String PROTO_PATH_STR = "serialized/person-01.ser";

	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	private static final Path JSON_PATH = Paths.get(JSON_PATH_STR);
	private static final Path PROTO_PATH = Paths.get(PROTO_PATH_STR);

	public static void serializeJSON(Object object) {
		try {
			Files.deleteIfExists(JSON_PATH);
			byte[] writeValueAsBytes = MAPPER.writeValueAsBytes(object);
			Files.write(JSON_PATH, writeValueAsBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <T> T deSerializeJSON(Class<T> type) {

		try {
			byte[] readAllBytes = Files.readAllBytes(JSON_PATH);
			return MAPPER.readValue(readAllBytes, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void serializeProto(AbstractMessageLite object) {
		try {
			Files.deleteIfExists(PROTO_PATH);
			byte[] writeValueAsBytes = object.toByteArray();
			Files.write(PROTO_PATH, writeValueAsBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Person deSerializeProtoPerson() {

		try {
			byte[] readAllBytes = Files.readAllBytes(PROTO_PATH);
			return Person.parseFrom(readAllBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static <T> T jacksonTestAllAtOnce(T object) {

		try {
			//serialzie
			byte[] writeValueAsBytes = MAPPER.writeValueAsBytes(object);
			
			//deserialze -> both at once
			return (T) MAPPER.readValue(writeValueAsBytes, object.getClass());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
	public static Person protoTestAllAtOnce(Person object) {

		try {
			//serialzie
			byte[] writeValueAsBytes = object.toByteArray();
			
			//deserialze -> both at once
			return Person.parseFrom(writeValueAsBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
}
