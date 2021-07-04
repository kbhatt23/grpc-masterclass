package com.learning.java_grpc.bankservicerpc.clientloadbalancer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.grpc.EquivalentAddressGroup;

public class ServiceRegistry {

	
	private static final Map<String, List<EquivalentAddressGroup>> SERVICES = new HashMap<>();
	
	//service -> bank-service, addresses -> ["localhost:6565","localhost:7575"]
	public static void register(String service, List<String> addresses) {
		
		List<EquivalentAddressGroup> equivalentGroups = addresses.stream()
		         .map(address -> address.split(":"))
		         .map(arrayITtems -> new InetSocketAddress(arrayITtems[0], Integer.parseInt(arrayITtems[1])) )
		         .map(EquivalentAddressGroup::new)
		         .collect(Collectors.toList())
		         ;
		SERVICES.put(service, equivalentGroups);
		
	}
	
	public static List<EquivalentAddressGroup> getInstances(String service){
		return SERVICES.get(service);
	}
}
