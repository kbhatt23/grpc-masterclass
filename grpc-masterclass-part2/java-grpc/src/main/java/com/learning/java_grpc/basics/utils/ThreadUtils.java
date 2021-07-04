package com.learning.java_grpc.basics.utils;

public class ThreadUtils {

	public static void sleep(long ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
