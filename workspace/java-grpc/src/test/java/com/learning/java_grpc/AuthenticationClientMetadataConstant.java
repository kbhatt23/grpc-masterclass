package com.learning.java_grpc;

import io.grpc.Metadata;
import io.grpc.Metadata.Key;

public class AuthenticationClientMetadataConstant  {
	
	 private static final Metadata META_DATA ;
	 
	 static {
		 META_DATA = new Metadata();
		 META_DATA.put(Key.of("user-token", Metadata.ASCII_STRING_MARSHALLER),
				 "bank-client-secreta");
		 
	 }
	 
	 public static Metadata getTokenClient() {
		 return META_DATA;
	 }
}
