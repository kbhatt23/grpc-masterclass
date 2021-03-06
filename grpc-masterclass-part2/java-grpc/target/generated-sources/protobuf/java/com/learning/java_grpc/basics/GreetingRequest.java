// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: basics/greetings.proto

package com.learning.java_grpc.basics;

/**
 * Protobuf type {@code basics.GreetingRequest}
 */
public  final class GreetingRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:basics.GreetingRequest)
    GreetingRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GreetingRequest.newBuilder() to construct.
  private GreetingRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GreetingRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GreetingRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.learning.java_grpc.basics.Human.Builder subBuilder = null;
            if (human_ != null) {
              subBuilder = human_.toBuilder();
            }
            human_ = input.readMessage(com.learning.java_grpc.basics.Human.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(human_);
              human_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.learning.java_grpc.basics.Greetings.internal_static_basics_GreetingRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.learning.java_grpc.basics.Greetings.internal_static_basics_GreetingRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.learning.java_grpc.basics.GreetingRequest.class, com.learning.java_grpc.basics.GreetingRequest.Builder.class);
  }

  public static final int HUMAN_FIELD_NUMBER = 1;
  private com.learning.java_grpc.basics.Human human_;
  /**
   * <code>.basics.Human human = 1;</code>
   */
  public boolean hasHuman() {
    return human_ != null;
  }
  /**
   * <code>.basics.Human human = 1;</code>
   */
  public com.learning.java_grpc.basics.Human getHuman() {
    return human_ == null ? com.learning.java_grpc.basics.Human.getDefaultInstance() : human_;
  }
  /**
   * <code>.basics.Human human = 1;</code>
   */
  public com.learning.java_grpc.basics.HumanOrBuilder getHumanOrBuilder() {
    return getHuman();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (human_ != null) {
      output.writeMessage(1, getHuman());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (human_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getHuman());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.learning.java_grpc.basics.GreetingRequest)) {
      return super.equals(obj);
    }
    com.learning.java_grpc.basics.GreetingRequest other = (com.learning.java_grpc.basics.GreetingRequest) obj;

    boolean result = true;
    result = result && (hasHuman() == other.hasHuman());
    if (hasHuman()) {
      result = result && getHuman()
          .equals(other.getHuman());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasHuman()) {
      hash = (37 * hash) + HUMAN_FIELD_NUMBER;
      hash = (53 * hash) + getHuman().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.learning.java_grpc.basics.GreetingRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.learning.java_grpc.basics.GreetingRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.learning.java_grpc.basics.GreetingRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code basics.GreetingRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:basics.GreetingRequest)
      com.learning.java_grpc.basics.GreetingRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.learning.java_grpc.basics.Greetings.internal_static_basics_GreetingRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.learning.java_grpc.basics.Greetings.internal_static_basics_GreetingRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.learning.java_grpc.basics.GreetingRequest.class, com.learning.java_grpc.basics.GreetingRequest.Builder.class);
    }

    // Construct using com.learning.java_grpc.basics.GreetingRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (humanBuilder_ == null) {
        human_ = null;
      } else {
        human_ = null;
        humanBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.learning.java_grpc.basics.Greetings.internal_static_basics_GreetingRequest_descriptor;
    }

    @java.lang.Override
    public com.learning.java_grpc.basics.GreetingRequest getDefaultInstanceForType() {
      return com.learning.java_grpc.basics.GreetingRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.learning.java_grpc.basics.GreetingRequest build() {
      com.learning.java_grpc.basics.GreetingRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.learning.java_grpc.basics.GreetingRequest buildPartial() {
      com.learning.java_grpc.basics.GreetingRequest result = new com.learning.java_grpc.basics.GreetingRequest(this);
      if (humanBuilder_ == null) {
        result.human_ = human_;
      } else {
        result.human_ = humanBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.learning.java_grpc.basics.GreetingRequest) {
        return mergeFrom((com.learning.java_grpc.basics.GreetingRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.learning.java_grpc.basics.GreetingRequest other) {
      if (other == com.learning.java_grpc.basics.GreetingRequest.getDefaultInstance()) return this;
      if (other.hasHuman()) {
        mergeHuman(other.getHuman());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.learning.java_grpc.basics.GreetingRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.learning.java_grpc.basics.GreetingRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.learning.java_grpc.basics.Human human_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.learning.java_grpc.basics.Human, com.learning.java_grpc.basics.Human.Builder, com.learning.java_grpc.basics.HumanOrBuilder> humanBuilder_;
    /**
     * <code>.basics.Human human = 1;</code>
     */
    public boolean hasHuman() {
      return humanBuilder_ != null || human_ != null;
    }
    /**
     * <code>.basics.Human human = 1;</code>
     */
    public com.learning.java_grpc.basics.Human getHuman() {
      if (humanBuilder_ == null) {
        return human_ == null ? com.learning.java_grpc.basics.Human.getDefaultInstance() : human_;
      } else {
        return humanBuilder_.getMessage();
      }
    }
    /**
     * <code>.basics.Human human = 1;</code>
     */
    public Builder setHuman(com.learning.java_grpc.basics.Human value) {
      if (humanBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        human_ = value;
        onChanged();
      } else {
        humanBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.basics.Human human = 1;</code>
     */
    public Builder setHuman(
        com.learning.java_grpc.basics.Human.Builder builderForValue) {
      if (humanBuilder_ == null) {
        human_ = builderForValue.build();
        onChanged();
      } else {
        humanBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.basics.Human human = 1;</code>
     */
    public Builder mergeHuman(com.learning.java_grpc.basics.Human value) {
      if (humanBuilder_ == null) {
        if (human_ != null) {
          human_ =
            com.learning.java_grpc.basics.Human.newBuilder(human_).mergeFrom(value).buildPartial();
        } else {
          human_ = value;
        }
        onChanged();
      } else {
        humanBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.basics.Human human = 1;</code>
     */
    public Builder clearHuman() {
      if (humanBuilder_ == null) {
        human_ = null;
        onChanged();
      } else {
        human_ = null;
        humanBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.basics.Human human = 1;</code>
     */
    public com.learning.java_grpc.basics.Human.Builder getHumanBuilder() {
      
      onChanged();
      return getHumanFieldBuilder().getBuilder();
    }
    /**
     * <code>.basics.Human human = 1;</code>
     */
    public com.learning.java_grpc.basics.HumanOrBuilder getHumanOrBuilder() {
      if (humanBuilder_ != null) {
        return humanBuilder_.getMessageOrBuilder();
      } else {
        return human_ == null ?
            com.learning.java_grpc.basics.Human.getDefaultInstance() : human_;
      }
    }
    /**
     * <code>.basics.Human human = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.learning.java_grpc.basics.Human, com.learning.java_grpc.basics.Human.Builder, com.learning.java_grpc.basics.HumanOrBuilder> 
        getHumanFieldBuilder() {
      if (humanBuilder_ == null) {
        humanBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.learning.java_grpc.basics.Human, com.learning.java_grpc.basics.Human.Builder, com.learning.java_grpc.basics.HumanOrBuilder>(
                getHuman(),
                getParentForChildren(),
                isClean());
        human_ = null;
      }
      return humanBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:basics.GreetingRequest)
  }

  // @@protoc_insertion_point(class_scope:basics.GreetingRequest)
  private static final com.learning.java_grpc.basics.GreetingRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.learning.java_grpc.basics.GreetingRequest();
  }

  public static com.learning.java_grpc.basics.GreetingRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GreetingRequest>
      PARSER = new com.google.protobuf.AbstractParser<GreetingRequest>() {
    @java.lang.Override
    public GreetingRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GreetingRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GreetingRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GreetingRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.learning.java_grpc.basics.GreetingRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

