package com.learning.protobuff_basics.serializers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONSerde<T> implements MessageSerde<T> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void serialize(T object, String file) {
		try {
			byte[] bytes = objectMapper.writeValueAsBytes(object);
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
			return objectMapper.readValue(readAllBytes, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
