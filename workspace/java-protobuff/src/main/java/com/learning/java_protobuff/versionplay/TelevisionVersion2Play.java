package com.learning.java_protobuff.versionplay;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.learning.java_protobuff.beans.TeleCategory;
import com.learning.java_protobuff.beans.Television;

public class TelevisionVersion2Play {

	public static void main(String[] args) {

		
		Path path = Paths.get("serialized/televions-v02.ser");
		//value saved is: -> 1=onida,2=101.00,3=1(enum)
//		Television televisonOld = Television.newBuilder().setBrand("onida").setPrice(101.99).setTeleCategory(TeleCategory.HD).build();
//		
//		//write to file with version 2
//		//serialze the version 02 format
//		try {
//			Files.deleteIfExists(path);
//			Files.write(path, televisonOld.toByteArray());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//now lets deserialze the file after upgrading the version - >remove old fields and add new fields
		//remember the serialzed version is old meaning producer/client is sending old version of proto as data format
		//we are updated to enw version and hence have less proeprties
		
		try {
			byte[] readAllBytes = Files.readAllBytes(path);
			Television finalData = Television.parseFrom(readAllBytes);
			//also now here we do not have getter for old property that is removed -> year
			System.out.println(finalData);
			//below proeprties are not present in client data , so default value will be pushed
			System.out.println(finalData.getYear());
			System.out.println(finalData.getBrand());
			System.out.println(finalData.getAge());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
