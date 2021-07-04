package com.learning.java_grpc.basics;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: basics/greetings.proto")
public final class GreetingsServiceGrpc {

  private GreetingsServiceGrpc() {}

  public static final String SERVICE_NAME = "basics.GreetingsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest,
      com.learning.java_grpc.basics.GreetingResponse> getGreetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "greet",
      requestType = com.learning.java_grpc.basics.GreetingRequest.class,
      responseType = com.learning.java_grpc.basics.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest,
      com.learning.java_grpc.basics.GreetingResponse> getGreetMethod() {
    io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest, com.learning.java_grpc.basics.GreetingResponse> getGreetMethod;
    if ((getGreetMethod = GreetingsServiceGrpc.getGreetMethod) == null) {
      synchronized (GreetingsServiceGrpc.class) {
        if ((getGreetMethod = GreetingsServiceGrpc.getGreetMethod) == null) {
          GreetingsServiceGrpc.getGreetMethod = getGreetMethod = 
              io.grpc.MethodDescriptor.<com.learning.java_grpc.basics.GreetingRequest, com.learning.java_grpc.basics.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "basics.GreetingsService", "greet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.GreetingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreetingsServiceMethodDescriptorSupplier("greet"))
                  .build();
          }
        }
     }
     return getGreetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest,
      com.learning.java_grpc.basics.GreetingResponse> getGreetWithDeadLineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "greetWithDeadLine",
      requestType = com.learning.java_grpc.basics.GreetingRequest.class,
      responseType = com.learning.java_grpc.basics.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest,
      com.learning.java_grpc.basics.GreetingResponse> getGreetWithDeadLineMethod() {
    io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest, com.learning.java_grpc.basics.GreetingResponse> getGreetWithDeadLineMethod;
    if ((getGreetWithDeadLineMethod = GreetingsServiceGrpc.getGreetWithDeadLineMethod) == null) {
      synchronized (GreetingsServiceGrpc.class) {
        if ((getGreetWithDeadLineMethod = GreetingsServiceGrpc.getGreetWithDeadLineMethod) == null) {
          GreetingsServiceGrpc.getGreetWithDeadLineMethod = getGreetWithDeadLineMethod = 
              io.grpc.MethodDescriptor.<com.learning.java_grpc.basics.GreetingRequest, com.learning.java_grpc.basics.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "basics.GreetingsService", "greetWithDeadLine"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.GreetingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreetingsServiceMethodDescriptorSupplier("greetWithDeadLine"))
                  .build();
          }
        }
     }
     return getGreetWithDeadLineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.java_grpc.basics.MultipleGreetingRequest,
      com.learning.java_grpc.basics.GreetingResponse> getGreetRepeatedlyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "greetRepeatedly",
      requestType = com.learning.java_grpc.basics.MultipleGreetingRequest.class,
      responseType = com.learning.java_grpc.basics.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.learning.java_grpc.basics.MultipleGreetingRequest,
      com.learning.java_grpc.basics.GreetingResponse> getGreetRepeatedlyMethod() {
    io.grpc.MethodDescriptor<com.learning.java_grpc.basics.MultipleGreetingRequest, com.learning.java_grpc.basics.GreetingResponse> getGreetRepeatedlyMethod;
    if ((getGreetRepeatedlyMethod = GreetingsServiceGrpc.getGreetRepeatedlyMethod) == null) {
      synchronized (GreetingsServiceGrpc.class) {
        if ((getGreetRepeatedlyMethod = GreetingsServiceGrpc.getGreetRepeatedlyMethod) == null) {
          GreetingsServiceGrpc.getGreetRepeatedlyMethod = getGreetRepeatedlyMethod = 
              io.grpc.MethodDescriptor.<com.learning.java_grpc.basics.MultipleGreetingRequest, com.learning.java_grpc.basics.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "basics.GreetingsService", "greetRepeatedly"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.MultipleGreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.GreetingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreetingsServiceMethodDescriptorSupplier("greetRepeatedly"))
                  .build();
          }
        }
     }
     return getGreetRepeatedlyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest,
      com.learning.java_grpc.basics.GreetingResponse> getGreetForLongMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "greetForLong",
      requestType = com.learning.java_grpc.basics.GreetingRequest.class,
      responseType = com.learning.java_grpc.basics.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest,
      com.learning.java_grpc.basics.GreetingResponse> getGreetForLongMethod() {
    io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest, com.learning.java_grpc.basics.GreetingResponse> getGreetForLongMethod;
    if ((getGreetForLongMethod = GreetingsServiceGrpc.getGreetForLongMethod) == null) {
      synchronized (GreetingsServiceGrpc.class) {
        if ((getGreetForLongMethod = GreetingsServiceGrpc.getGreetForLongMethod) == null) {
          GreetingsServiceGrpc.getGreetForLongMethod = getGreetForLongMethod = 
              io.grpc.MethodDescriptor.<com.learning.java_grpc.basics.GreetingRequest, com.learning.java_grpc.basics.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "basics.GreetingsService", "greetForLong"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.GreetingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreetingsServiceMethodDescriptorSupplier("greetForLong"))
                  .build();
          }
        }
     }
     return getGreetForLongMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest,
      com.learning.java_grpc.basics.GreetingResponse> getGreetAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "greetAll",
      requestType = com.learning.java_grpc.basics.GreetingRequest.class,
      responseType = com.learning.java_grpc.basics.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest,
      com.learning.java_grpc.basics.GreetingResponse> getGreetAllMethod() {
    io.grpc.MethodDescriptor<com.learning.java_grpc.basics.GreetingRequest, com.learning.java_grpc.basics.GreetingResponse> getGreetAllMethod;
    if ((getGreetAllMethod = GreetingsServiceGrpc.getGreetAllMethod) == null) {
      synchronized (GreetingsServiceGrpc.class) {
        if ((getGreetAllMethod = GreetingsServiceGrpc.getGreetAllMethod) == null) {
          GreetingsServiceGrpc.getGreetAllMethod = getGreetAllMethod = 
              io.grpc.MethodDescriptor.<com.learning.java_grpc.basics.GreetingRequest, com.learning.java_grpc.basics.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "basics.GreetingsService", "greetAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.GreetingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreetingsServiceMethodDescriptorSupplier("greetAll"))
                  .build();
          }
        }
     }
     return getGreetAllMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreetingsServiceStub newStub(io.grpc.Channel channel) {
    return new GreetingsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreetingsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GreetingsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreetingsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GreetingsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GreetingsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void greet(com.learning.java_grpc.basics.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGreetMethod(), responseObserver);
    }

    /**
     */
    public void greetWithDeadLine(com.learning.java_grpc.basics.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGreetWithDeadLineMethod(), responseObserver);
    }

    /**
     * <pre>
     *server streaming
     * </pre>
     */
    public void greetRepeatedly(com.learning.java_grpc.basics.MultipleGreetingRequest request,
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGreetRepeatedlyMethod(), responseObserver);
    }

    /**
     * <pre>
     *client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingRequest> greetForLong(
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGreetForLongMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingRequest> greetAll(
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGreetAllMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGreetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.java_grpc.basics.GreetingRequest,
                com.learning.java_grpc.basics.GreetingResponse>(
                  this, METHODID_GREET)))
          .addMethod(
            getGreetWithDeadLineMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.java_grpc.basics.GreetingRequest,
                com.learning.java_grpc.basics.GreetingResponse>(
                  this, METHODID_GREET_WITH_DEAD_LINE)))
          .addMethod(
            getGreetRepeatedlyMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.learning.java_grpc.basics.MultipleGreetingRequest,
                com.learning.java_grpc.basics.GreetingResponse>(
                  this, METHODID_GREET_REPEATEDLY)))
          .addMethod(
            getGreetForLongMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.learning.java_grpc.basics.GreetingRequest,
                com.learning.java_grpc.basics.GreetingResponse>(
                  this, METHODID_GREET_FOR_LONG)))
          .addMethod(
            getGreetAllMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.learning.java_grpc.basics.GreetingRequest,
                com.learning.java_grpc.basics.GreetingResponse>(
                  this, METHODID_GREET_ALL)))
          .build();
    }
  }

  /**
   */
  public static final class GreetingsServiceStub extends io.grpc.stub.AbstractStub<GreetingsServiceStub> {
    private GreetingsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreetingsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreetingsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void greet(com.learning.java_grpc.basics.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGreetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void greetWithDeadLine(com.learning.java_grpc.basics.GreetingRequest request,
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGreetWithDeadLineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *server streaming
     * </pre>
     */
    public void greetRepeatedly(com.learning.java_grpc.basics.MultipleGreetingRequest request,
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGreetRepeatedlyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingRequest> greetForLong(
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGreetForLongMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingRequest> greetAll(
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGreetAllMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class GreetingsServiceBlockingStub extends io.grpc.stub.AbstractStub<GreetingsServiceBlockingStub> {
    private GreetingsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreetingsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreetingsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public com.learning.java_grpc.basics.GreetingResponse greet(com.learning.java_grpc.basics.GreetingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGreetMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.learning.java_grpc.basics.GreetingResponse greetWithDeadLine(com.learning.java_grpc.basics.GreetingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGreetWithDeadLineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *server streaming
     * </pre>
     */
    public java.util.Iterator<com.learning.java_grpc.basics.GreetingResponse> greetRepeatedly(
        com.learning.java_grpc.basics.MultipleGreetingRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGreetRepeatedlyMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GreetingsServiceFutureStub extends io.grpc.stub.AbstractStub<GreetingsServiceFutureStub> {
    private GreetingsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreetingsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreetingsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.java_grpc.basics.GreetingResponse> greet(
        com.learning.java_grpc.basics.GreetingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGreetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.java_grpc.basics.GreetingResponse> greetWithDeadLine(
        com.learning.java_grpc.basics.GreetingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGreetWithDeadLineMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GREET = 0;
  private static final int METHODID_GREET_WITH_DEAD_LINE = 1;
  private static final int METHODID_GREET_REPEATEDLY = 2;
  private static final int METHODID_GREET_FOR_LONG = 3;
  private static final int METHODID_GREET_ALL = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreetingsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreetingsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GREET:
          serviceImpl.greet((com.learning.java_grpc.basics.GreetingRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse>) responseObserver);
          break;
        case METHODID_GREET_WITH_DEAD_LINE:
          serviceImpl.greetWithDeadLine((com.learning.java_grpc.basics.GreetingRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse>) responseObserver);
          break;
        case METHODID_GREET_REPEATEDLY:
          serviceImpl.greetRepeatedly((com.learning.java_grpc.basics.MultipleGreetingRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GREET_FOR_LONG:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.greetForLong(
              (io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse>) responseObserver);
        case METHODID_GREET_ALL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.greetAll(
              (io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.GreetingResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreetingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreetingsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learning.java_grpc.basics.Greetings.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GreetingsService");
    }
  }

  private static final class GreetingsServiceFileDescriptorSupplier
      extends GreetingsServiceBaseDescriptorSupplier {
    GreetingsServiceFileDescriptorSupplier() {}
  }

  private static final class GreetingsServiceMethodDescriptorSupplier
      extends GreetingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreetingsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GreetingsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreetingsServiceFileDescriptorSupplier())
              .addMethod(getGreetMethod())
              .addMethod(getGreetWithDeadLineMethod())
              .addMethod(getGreetRepeatedlyMethod())
              .addMethod(getGreetForLongMethod())
              .addMethod(getGreetAllMethod())
              .build();
        }
      }
    }
    return result;
  }
}
