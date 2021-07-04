package com.learning.java_protobuff.playproto;

import com.learning.java_protobuff.beans.Person;

public class JsonVsProtoBuffPerformance2 {

	public static void main(String[] args) {

		Runnable jsonTask = () -> {

			for (int i = 0; i < 1000000; i++) {
				JPerson jPerson = new JPerson("krishna-" + i, i);
				JPerson jacksonTestAllAtOnce = SerializationUtil.jacksonTestAllAtOnce(jPerson);

				if (!jacksonTestAllAtOnce.equals(jPerson)) {
					System.out.println("wrong data deserialzed " + jacksonTestAllAtOnce);
				}
			}
		};

		Runnable protoTask = () -> {

			for (int i = 0; i < 10000; i++) {
				Person person = Person.newBuilder().setAge(i).setName("krishna-" + i).build();
				Person protoTestAllAtOnce = SerializationUtil.protoTestAllAtOnce(person);

				if (!protoTestAllAtOnce.equals(person)) {
					System.out.println("wrong data deserialzed " + protoTestAllAtOnce);
				}
			}
		};

		long jsonTotal = 0;
		long protoTotal = 0;
		for (int i = 0; i < 50; i++) {
			jsonTotal += testPerformance(jsonTask, "JSON");

			protoTotal += testPerformance(protoTask, "PROTO");
		}
		
		System.out.println("PROTO average time taken "+(protoTotal/50));
		
		System.out.println("JSON average time taken "+(jsonTotal/50));
	}

	public static long testPerformance(Runnable runnable, String method) {

		long start = System.currentTimeMillis();

		runnable.run();

		long end = System.currentTimeMillis();

		return end - start;
	}
}
