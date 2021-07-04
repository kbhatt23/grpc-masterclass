package com.learning.java_protobuff.playproto;

import com.learning.java_protobuff.beans.Person;

public class JsonVsProtoBuffPerformance {

	public static void main(String[] args) {

		Runnable jsonTask = () -> {

			for (int i = 0; i < 10000; i++) {
				JPerson jPerson = new JPerson("krishna-" + i, i);
				SerializationUtil.serializeJSON(jPerson);

				JPerson deSerializeJSON = SerializationUtil.deSerializeJSON(JPerson.class);
				if (!deSerializeJSON.equals(jPerson)) {
					System.out.println("wrong data deserialzed " + deSerializeJSON);
				}
			}
		};

		Runnable protoTask = () -> {

			for (int i = 0; i < 10000; i++) {
				Person person = Person.newBuilder().setAge(i).setName("krishna-" + i).build();
				SerializationUtil.serializeProto(person);

				Person deSerializeJSON = SerializationUtil.deSerializeProtoPerson();
				if (!deSerializeJSON.equals(person)) {
					System.out.println("wrong data deserialzed " + deSerializeJSON);
				}
			}
		};

		for (int i = 0; i < 5; i++) {
			testPerformance(jsonTask, "JSON");

			testPerformance(protoTask, "PROTO");
		}
	}

	public static void testPerformance(Runnable runnable, String method) {

		long start = System.currentTimeMillis();

		runnable.run();

		long end = System.currentTimeMillis();
		System.out.println("total time taken for " + method + ": " + (end - start) + " ms.");

	}
}
