package com.learning.java_grpc;

import java.util.concurrent.TimeUnit;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Deadline;
import io.grpc.MethodDescriptor;

//interceptor for client

public class TimeoutInterceptor implements ClientInterceptor{

	@Override
	public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
			CallOptions callOptions, Channel next) {
		
		System.out.println("client interceptor for deadline is called");
		//lets not override specific behaviour
		Deadline deadline = callOptions.getDeadline();
		if(deadline == null) {
			//if not set specifically
			callOptions.withDeadline(Deadline.after(2, TimeUnit.SECONDS));
		}
		return next.newCall(method, callOptions
				);
	}

}
