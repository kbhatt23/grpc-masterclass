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
    comments = "Source: utils/calculator.proto")
public final class CalculatorServiceGrpc {

  private CalculatorServiceGrpc() {}

  public static final String SERVICE_NAME = "utils.CalculatorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learning.java_grpc.basics.FindAverageRequest,
      com.learning.java_grpc.basics.FindAverageResponse> getAverageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "average",
      requestType = com.learning.java_grpc.basics.FindAverageRequest.class,
      responseType = com.learning.java_grpc.basics.FindAverageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.learning.java_grpc.basics.FindAverageRequest,
      com.learning.java_grpc.basics.FindAverageResponse> getAverageMethod() {
    io.grpc.MethodDescriptor<com.learning.java_grpc.basics.FindAverageRequest, com.learning.java_grpc.basics.FindAverageResponse> getAverageMethod;
    if ((getAverageMethod = CalculatorServiceGrpc.getAverageMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getAverageMethod = CalculatorServiceGrpc.getAverageMethod) == null) {
          CalculatorServiceGrpc.getAverageMethod = getAverageMethod = 
              io.grpc.MethodDescriptor.<com.learning.java_grpc.basics.FindAverageRequest, com.learning.java_grpc.basics.FindAverageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "utils.CalculatorService", "average"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.FindAverageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.FindAverageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("average"))
                  .build();
          }
        }
     }
     return getAverageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learning.java_grpc.basics.FindAverageRequest,
      com.learning.java_grpc.basics.SquareRootResponse> getSquareRootMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SquareRoot",
      requestType = com.learning.java_grpc.basics.FindAverageRequest.class,
      responseType = com.learning.java_grpc.basics.SquareRootResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learning.java_grpc.basics.FindAverageRequest,
      com.learning.java_grpc.basics.SquareRootResponse> getSquareRootMethod() {
    io.grpc.MethodDescriptor<com.learning.java_grpc.basics.FindAverageRequest, com.learning.java_grpc.basics.SquareRootResponse> getSquareRootMethod;
    if ((getSquareRootMethod = CalculatorServiceGrpc.getSquareRootMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getSquareRootMethod = CalculatorServiceGrpc.getSquareRootMethod) == null) {
          CalculatorServiceGrpc.getSquareRootMethod = getSquareRootMethod = 
              io.grpc.MethodDescriptor.<com.learning.java_grpc.basics.FindAverageRequest, com.learning.java_grpc.basics.SquareRootResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "utils.CalculatorService", "SquareRoot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.FindAverageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learning.java_grpc.basics.SquareRootResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("SquareRoot"))
                  .build();
          }
        }
     }
     return getSquareRootMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculatorServiceStub newStub(io.grpc.Channel channel) {
    return new CalculatorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculatorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalculatorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculatorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalculatorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CalculatorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.FindAverageRequest> average(
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.FindAverageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAverageMethod(), responseObserver);
    }

    /**
     */
    public void squareRoot(com.learning.java_grpc.basics.FindAverageRequest request,
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.SquareRootResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSquareRootMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAverageMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.learning.java_grpc.basics.FindAverageRequest,
                com.learning.java_grpc.basics.FindAverageResponse>(
                  this, METHODID_AVERAGE)))
          .addMethod(
            getSquareRootMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learning.java_grpc.basics.FindAverageRequest,
                com.learning.java_grpc.basics.SquareRootResponse>(
                  this, METHODID_SQUARE_ROOT)))
          .build();
    }
  }

  /**
   */
  public static final class CalculatorServiceStub extends io.grpc.stub.AbstractStub<CalculatorServiceStub> {
    private CalculatorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.FindAverageRequest> average(
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.FindAverageResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAverageMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void squareRoot(com.learning.java_grpc.basics.FindAverageRequest request,
        io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.SquareRootResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSquareRootMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CalculatorServiceBlockingStub extends io.grpc.stub.AbstractStub<CalculatorServiceBlockingStub> {
    private CalculatorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.learning.java_grpc.basics.SquareRootResponse squareRoot(com.learning.java_grpc.basics.FindAverageRequest request) {
      return blockingUnaryCall(
          getChannel(), getSquareRootMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalculatorServiceFutureStub extends io.grpc.stub.AbstractStub<CalculatorServiceFutureStub> {
    private CalculatorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learning.java_grpc.basics.SquareRootResponse> squareRoot(
        com.learning.java_grpc.basics.FindAverageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSquareRootMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SQUARE_ROOT = 0;
  private static final int METHODID_AVERAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculatorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculatorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SQUARE_ROOT:
          serviceImpl.squareRoot((com.learning.java_grpc.basics.FindAverageRequest) request,
              (io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.SquareRootResponse>) responseObserver);
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
        case METHODID_AVERAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.average(
              (io.grpc.stub.StreamObserver<com.learning.java_grpc.basics.FindAverageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculatorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learning.java_grpc.basics.Calculator.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CalculatorService");
    }
  }

  private static final class CalculatorServiceFileDescriptorSupplier
      extends CalculatorServiceBaseDescriptorSupplier {
    CalculatorServiceFileDescriptorSupplier() {}
  }

  private static final class CalculatorServiceMethodDescriptorSupplier
      extends CalculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculatorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CalculatorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculatorServiceFileDescriptorSupplier())
              .addMethod(getAverageMethod())
              .addMethod(getSquareRootMethod())
              .build();
        }
      }
    }
    return result;
  }
}
