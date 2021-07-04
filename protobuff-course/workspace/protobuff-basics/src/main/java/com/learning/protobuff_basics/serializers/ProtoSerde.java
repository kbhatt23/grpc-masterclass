package com.learning.protobuff_basics.serializers;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.MessageLite;

public class ProtoSerde<T extends MessageLite> implements MessageSerde<T> {

	@Override
	public void serialize(T object, String file) {
		try {
			byte[] bytes = object.toByteArray();
			Path path = Paths.get(file);
			Files.deleteIfExists(path);
			Files.write(path, bytes);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public T deserialize(String file, Class<T> type) {
		Path path = Paths.get(file);
		try {
			byte[] readAllBytes = Files.readAllBytes(path);
			Method declaredMethod = 
			type.getDeclaredMethod("parseFrom", byte[].class);
			return (T) declaredMethod.invoke(null, readAllBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
