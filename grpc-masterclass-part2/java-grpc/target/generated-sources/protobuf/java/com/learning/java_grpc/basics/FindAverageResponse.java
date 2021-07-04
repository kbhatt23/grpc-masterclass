// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: utils/calculator.proto

package com.learning.java_grpc.basics;

/**
 * Protobuf type {@code utils.FindAverageResponse}
 */
public  final class FindAverageResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:utils.FindAverageResponse)
    FindAverageResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FindAverageResponse.newBuilder() to construct.
  private FindAverageResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FindAverageResponse() {
    average_ = 0D;
    numbers_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FindAverageResponse(
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
          case 9: {

            average_ = input.readDouble();
            break;
          }
          case 16: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              numbers_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000002;
            }
            numbers_.add(input.readInt32());
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
              numbers_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000002;
            }
            while (input.getBytesUntilLimit() > 0) {
              numbers_.add(input.readInt32());
            }
            input.popLimit(limit);
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
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        numbers_ = java.util.Collections.unmodifiableList(numbers_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.learning.java_grpc.basics.Calculator.internal_static_utils_FindAverageResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.learning.java_grpc.basics.Calculator.internal_static_utils_FindAverageResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.learning.java_grpc.basics.FindAverageResponse.class, com.learning.java_grpc.basics.FindAverageResponse.Builder.class);
  }

  private int bitField0_;
  public static final int AVERAGE_FIELD_NUMBER = 1;
  private double average_;
  /**
   * <code>double average = 1;</code>
   */
  public double getAverage() {
    return average_;
  }

  public static final int NUMBERS_FIELD_NUMBER = 2;
  private java.util.List<java.lang.Integer> numbers_;
  /**
   * <code>repeated int32 numbers = 2;</code>
   */
  public java.util.List<java.lang.Integer>
      getNumbersList() {
    return numbers_;
  }
  /**
   * <code>repeated int32 numbers = 2;</code>
   */
  public int getNumbersCount() {
    return numbers_.size();
  }
  /**
   * <code>repeated int32 numbers = 2;</code>
   */
  public int getNumbers(int index) {
    return numbers_.get(index);
  }
  private int numbersMemoizedSerializedSize = -1;

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
    getSerializedSize();
    if (average_ != 0D) {
      output.writeDouble(1, average_);
    }
    if (getNumbersList().size() > 0) {
      output.writeUInt32NoTag(18);
      output.writeUInt32NoTag(numbersMemoizedSerializedSize);
    }
    for (int i = 0; i < numbers_.size(); i++) {
      output.writeInt32NoTag(numbers_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (average_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, average_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < numbers_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(numbers_.get(i));
      }
      size += dataSize;
      if (!getNumbersList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      numbersMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof com.learning.java_grpc.basics.FindAverageResponse)) {
      return super.equals(obj);
    }
    com.learning.java_grpc.basics.FindAverageResponse other = (com.learning.java_grpc.basics.FindAverageResponse) obj;

    boolean result = true;
    result = result && (
        java.lang.Double.doubleToLongBits(getAverage())
        == java.lang.Double.doubleToLongBits(
            other.getAverage()));
    result = result && getNumbersList()
        .equals(other.getNumbersList());
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
    hash = (37 * hash) + AVERAGE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getAverage()));
    if (getNumbersCount() > 0) {
      hash = (37 * hash) + NUMBERS_FIELD_NUMBER;
      hash = (53 * hash) + getNumbersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.learning.java_grpc.basics.FindAverageResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.learning.java_grpc.basics.FindAverageResponse parseFrom(
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
  public static Builder newBuilder(com.learning.java_grpc.basics.FindAverageResponse prototype) {
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
   * Protobuf type {@code utils.FindAverageResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:utils.FindAverageResponse)
      com.learning.java_grpc.basics.FindAverageResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.learning.java_grpc.basics.Calculator.internal_static_utils_FindAverageResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.learning.java_grpc.basics.Calculator.internal_static_utils_FindAverageResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.learning.java_grpc.basics.FindAverageResponse.class, com.learning.java_grpc.basics.FindAverageResponse.Builder.class);
    }

    // Construct using com.learning.java_grpc.basics.FindAverageResponse.newBuilder()
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
      average_ = 0D;

      numbers_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.learning.java_grpc.basics.Calculator.internal_static_utils_FindAverageResponse_descriptor;
    }

    @java.lang.Override
    public com.learning.java_grpc.basics.FindAverageResponse getDefaultInstanceForType() {
      return com.learning.java_grpc.basics.FindAverageResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.learning.java_grpc.basics.FindAverageResponse build() {
      com.learning.java_grpc.basics.FindAverageResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.learning.java_grpc.basics.FindAverageResponse buildPartial() {
      com.learning.java_grpc.basics.FindAverageResponse result = new com.learning.java_grpc.basics.FindAverageResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.average_ = average_;
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        numbers_ = java.util.Collections.unmodifiableList(numbers_);
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.numbers_ = numbers_;
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof com.learning.java_grpc.basics.FindAverageResponse) {
        return mergeFrom((com.learning.java_grpc.basics.FindAverageResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.learning.java_grpc.basics.FindAverageResponse other) {
      if (other == com.learning.java_grpc.basics.FindAverageResponse.getDefaultInstance()) return this;
      if (other.getAverage() != 0D) {
        setAverage(other.getAverage());
      }
      if (!other.numbers_.isEmpty()) {
        if (numbers_.isEmpty()) {
          numbers_ = other.numbers_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureNumbersIsMutable();
          numbers_.addAll(other.numbers_);
        }
        onChanged();
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
      com.learning.java_grpc.basics.FindAverageResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.learning.java_grpc.basics.FindAverageResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private double average_ ;
    /**
     * <code>double average = 1;</code>
     */
    public double getAverage() {
      return average_;
    }
    /**
     * <code>double average = 1;</code>
     */
    public Builder setAverage(double value) {
      
      average_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double average = 1;</code>
     */
    public Builder clearAverage() {
      
      average_ = 0D;
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Integer> numbers_ = java.util.Collections.emptyList();
    private void ensureNumbersIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        numbers_ = new java.util.ArrayList<java.lang.Integer>(numbers_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated int32 numbers = 2;</code>
     */
    public java.util.List<java.lang.Integer>
        getNumbersList() {
      return java.util.Collections.unmodifiableList(numbers_);
    }
    /**
     * <code>repeated int32 numbers = 2;</code>
     */
    public int getNumbersCount() {
      return numbers_.size();
    }
    /**
     * <code>repeated int32 numbers = 2;</code>
     */
    public int getNumbers(int index) {
      return numbers_.get(index);
    }
    /**
     * <code>repeated int32 numbers = 2;</code>
     */
    public Builder setNumbers(
        int index, int value) {
      ensureNumbersIsMutable();
      numbers_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 numbers = 2;</code>
     */
    public Builder addNumbers(int value) {
      ensureNumbersIsMutable();
      numbers_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 numbers = 2;</code>
     */
    public Builder addAllNumbers(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureNumbersIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, numbers_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 numbers = 2;</code>
     */
    public Builder clearNumbers() {
      numbers_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:utils.FindAverageResponse)
  }

  // @@protoc_insertion_point(class_scope:utils.FindAverageResponse)
  private static final com.learning.java_grpc.basics.FindAverageResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.learning.java_grpc.basics.FindAverageResponse();
  }

  public static com.learning.java_grpc.basics.FindAverageResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FindAverageResponse>
      PARSER = new com.google.protobuf.AbstractParser<FindAverageResponse>() {
    @java.lang.Override
    public FindAverageResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FindAverageResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FindAverageResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FindAverageResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.learning.java_grpc.basics.FindAverageResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

