package com.learning.java_grpc.innerclasses;

import java.util.Arrays;

public class AppendHAsh {
public static void main(String[] args) {
	String s = "neo";
	String s2 = "trinity";
String prepend = createSortedchars(s, s2);
System.out.println(prepend.hashCode());
System.out.println(prepend.hashCode());
System.out.println(prepend.hashCode());
System.out.println(prepend.hashCode());
String potpend = createSortedchars(s2, s);
System.out.println(potpend.hashCode());
System.out.println(potpend.hashCode());
System.out.println(potpend.hashCode());
System.out.println(potpend.hashCode());

}

public static String createSortedchars(String a, String b) {
	String combined = a+b;
	
	char[] combinedChars = combined.toCharArray();
	Arrays.sort(combinedChars);
	
	return new String(combinedChars);
}
}
