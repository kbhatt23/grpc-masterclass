package com.learning.java_grpc.bankservicerpc.clientloadbalancer;

import java.util.List;

import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;

public class BankNameResolver extends NameResolver {

	private String service;
	
	private Listener2 listener;

	public BankNameResolver(String service) {
		this.service = service;
	}

	@Override
	public String getServiceAuthority() {
		return "bank-service";
	}

	@Override
	public void shutdown() {

	}

	@Override
	public void start(Listener2 listener) {
		List<EquivalentAddressGroup> instances = ServiceRegistry.getInstances(this.service);
		ResolutionResult resolutionResult = ResolutionResult.newBuilder().setAddresses(instances).build();
		listener.onResult(resolutionResult);
	}
	
	@Override
	public void refresh() {
		List<EquivalentAddressGroup> instances = ServiceRegistry.getInstances(this.service);
		ResolutionResult resolutionResult = ResolutionResult.newBuilder().setAddresses(instances).build();
		listener.onResult(resolutionResult);
	}
}
