package com.learning.java_grpc.bankservicerpc.clientloadbalancer;

import java.net.URI;

import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.grpc.NameResolver.Args;

public class BankNameResolverProvider extends  NameResolverProvider{

	@Override
	protected boolean isAvailable() {
		return true;
	}

	@Override
	protected int priority() {
		return 5;
	}

	@Override
	public String getDefaultScheme() {
		return "dns";
	}

	
	@Override
	public NameResolver newNameResolver(URI targetUri, Args args) {
		String uriStr = targetUri.toString();
		
		System.out.println("newNameResolver: resolving name for url "+uriStr);
		return new BankNameResolver(uriStr);
	}
}
