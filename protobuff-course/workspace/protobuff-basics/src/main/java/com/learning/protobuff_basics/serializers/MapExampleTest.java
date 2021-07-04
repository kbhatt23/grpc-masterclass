package com.learning.protobuff_basics.serializers;

import java.util.HashMap;

import com.learning.protobuff_basics.beans.Address;
import com.learning.protobuff_basics.beans.MapExample;
import com.learning.protobuff_basics.beans.MapExample.Builder;

public class MapExampleTest {

	public static void main(String[] args) {
		Builder builder = MapExample.newBuilder().setId(1);
		
		for(int i = 1 ; i <=5 ; i++) {
			builder.putAddressMap(i, Address.newBuilder().setAddress1("address-1-"+i)
					.setState("DL")
					.setCity("DL")
					.setCountry("IN")
					.setAddress2("address-2-"+i)
					.build());
		}
		
		HashMap<Integer, Address> hashMap = new HashMap<Integer,Address>();
		hashMap.put(6, Address.newBuilder().setAddress1("address-1-"+6).build());
		hashMap.put(7, Address.newBuilder().setAddress1("address-1-"+7).build());
		
		MapExample build = builder.putAllAddressMap(hashMap).build();
		
		System.out.println("printing example for id "+build.getId());
		
		build.getAddressMap()
		.forEach((k,v) -> {
			System.out.println("address found with id "+k+" and value "+v);
		});
	}
}
