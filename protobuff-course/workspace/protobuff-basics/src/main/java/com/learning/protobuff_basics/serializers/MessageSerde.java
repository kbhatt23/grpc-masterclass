package com.learning.protobuff_basics.serializers;

public interface MessageSerde<T> {

	public void serialize(T object, String file);

	public T deserialize(String file, Class<T> type);
}
