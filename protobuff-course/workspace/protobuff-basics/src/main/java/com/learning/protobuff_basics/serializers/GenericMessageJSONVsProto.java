package com.learning.protobuff_basics.serializers;

import com.google.protobuf.Any;
import com.learning.protobuff_basics.beans.GenericMessageProto;
import com.learning.protobuff_basics.beans.ObjectHolderTypeOne;

public class GenericMessageJSONVsProto {

	private static final String FILE_PATH = "files/genericJsonProto.bin";

	public static void main(String[] args) {

		int size = 10000;

		handleProto(size);
		handleJsonData(size);
	}

	private static void handleJsonData(int size) {
		long start = System.currentTimeMillis();
		JSONSerde<GenericMessageJSON> jsonSerializer = new JSONSerde<>();
		for (int i = 0; i < size; i++) {
			GenericMessageJSON genericMessageJSON = new GenericMessageJSON();
			genericMessageJSON.setData(new ObjectHolder("jai shree ram-" + i));
			genericMessageJSON.setType(ObjectHolder.class);
			jsonSerializer.serialize(genericMessageJSON, FILE_PATH);

			GenericMessageJSON deserialize = jsonSerializer.deserialize(FILE_PATH, GenericMessageJSON.class);
			if (!deserialize.equals(genericMessageJSON))
				System.out.println("wrong serialzation happened in JSON format");
		}

		long end = System.currentTimeMillis();
		System.out.println("json total time taken " + (end - start) + " ms.");
	}

	private static void handleProto(int size) {
		long start = System.currentTimeMillis();
		MessageSerde<GenericMessageProto> protoSerializer = new ProtoSerde<>();
		for (int i = 0; i < size; i++) {
			ObjectHolderTypeOne data = ObjectHolderTypeOne.newBuilder().setField1("jai shree ram-" + i).build();
			Any pack = Any.pack(data);

			GenericMessageProto finalData = GenericMessageProto.newBuilder().setAnyData(pack)
					.setType(String.class.getName()).build();

			protoSerializer.serialize(finalData, FILE_PATH);

			GenericMessageProto deserialize = protoSerializer.deserialize(FILE_PATH, GenericMessageProto.class);
			if (!deserialize.equals(finalData))
				System.out.println("wrong serialzation happened in Proto format");
		}

		long end = System.currentTimeMillis();
		System.out.println("proto total time taken " + (end - start) + " ms.");
	}
}
