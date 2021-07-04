package com.learning.java_grpc.bankservicerpc;

import java.util.Objects;

import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;

public class AuthenticationServerInterceptor implements ServerInterceptor {

	@Override
	public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
			ServerCallHandler<ReqT, RespT> next) {
		String token = headers.get(Key.of("user-token", Metadata.ASCII_STRING_MARSHALLER));
		if (validate(token)) {
			return next.startCall(call, headers);
		} else {
			Status unauthenticatedStatus = Status.UNAUTHENTICATED.withDescription("passed invaid token " + token);
			call.close(unauthenticatedStatus, headers);
			return new ServerCall.Listener<ReqT>() {
			};
		}
	}

	private boolean validate(String token) {
		return Objects.nonNull(token) && token.equals("bank-client-secret");
	}
}
