// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: genericMessage.proto

package com.learning.protobuff_basics.beans;

/**
 * Protobuf type {@code GenericMessageProto}
 */
public  final class GenericMessageProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GenericMessageProto)
    GenericMessageProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GenericMessageProto.newBuilder() to construct.
  private GenericMessageProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GenericMessageProto() {
    type_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GenericMessageProto(
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
            com.google.protobuf.Any.Builder subBuilder = null;
            if (anyData_ != null) {
              subBuilder = anyData_.toBuilder();
            }
            anyData_ = input.readMessage(com.google.protobuf.Any.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(anyData_);
              anyData_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            type_ = s;
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
    return com.learning.protobuff_basics.beans.GenericMessage.internal_static_GenericMessageProto_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.learning.protobuff_basics.beans.GenericMessage.internal_static_GenericMessageProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.learning.protobuff_basics.beans.GenericMessageProto.class, com.learning.protobuff_basics.beans.GenericMessageProto.Builder.class);
  }

  public static final int ANY_DATA_FIELD_NUMBER = 1;
  private com.google.protobuf.Any anyData_;
  /**
   * <pre>
   *store any data
   * </pre>
   *
   * <code>.google.protobuf.Any any_data = 1;</code>
   */
  public boolean hasAnyData() {
    return anyData_ != null;
  }
  /**
   * <pre>
   *store any data
   * </pre>
   *
   * <code>.google.protobuf.Any any_data = 1;</code>
   */
  public com.google.protobuf.Any getAnyData() {
    return anyData_ == null ? com.google.protobuf.Any.getDefaultInstance() : anyData_;
  }
  /**
   * <pre>
   *store any data
   * </pre>
   *
   * <code>.google.protobuf.Any any_data = 1;</code>
   */
  public com.google.protobuf.AnyOrBuilder getAnyDataOrBuilder() {
    return getAnyData();
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private volatile java.lang.Object type_;
  /**
   * <pre>
   *store class type
   * </pre>
   *
   * <code>string type = 2;</code>
   */
  public java.lang.String getType() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      type_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *store class type
   * </pre>
   *
   * <code>string type = 2;</code>
   */
  public com.google.protobuf.ByteString
      getTypeBytes() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      type_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (anyData_ != null) {
      output.writeMessage(1, getAnyData());
    }
    if (!getTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, type_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (anyData_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAnyData());
    }
    if (!getTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, type_);
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
    if (!(obj instanceof com.learning.protobuff_basics.beans.GenericMessageProto)) {
      return super.equals(obj);
    }
    com.learning.protobuff_basics.beans.GenericMessageProto other = (com.learning.protobuff_basics.beans.GenericMessageProto) obj;

    boolean result = true;
    result = result && (hasAnyData() == other.hasAnyData());
    if (hasAnyData()) {
      result = result && getAnyData()
          .equals(other.getAnyData());
    }
    result = result && getType()
        .equals(other.getType());
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
    if (hasAnyData()) {
      hash = (37 * hash) + ANY_DATA_FIELD_NUMBER;
      hash = (53 * hash) + getAnyData().hashCode();
    }
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.learning.protobuff_basics.beans.GenericMessageProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.learning.protobuff_basics.beans.GenericMessageProto parseFrom(
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
  public static Builder newBuilder(com.learning.protobuff_basics.beans.GenericMessageProto prototype) {
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
   * Protobuf type {@code GenericMessageProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GenericMessageProto)
      com.learning.protobuff_basics.beans.GenericMessageProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.learning.protobuff_basics.beans.GenericMessage.internal_static_GenericMessageProto_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.learning.protobuff_basics.beans.GenericMessage.internal_static_GenericMessageProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.learning.protobuff_basics.beans.GenericMessageProto.class, com.learning.protobuff_basics.beans.GenericMessageProto.Builder.class);
    }

    // Construct using com.learning.protobuff_basics.beans.GenericMessageProto.newBuilder()
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
      if (anyDataBuilder_ == null) {
        anyData_ = null;
      } else {
        anyData_ = null;
        anyDataBuilder_ = null;
      }
      type_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.learning.protobuff_basics.beans.GenericMessage.internal_static_GenericMessageProto_descriptor;
    }

    @java.lang.Override
    public com.learning.protobuff_basics.beans.GenericMessageProto getDefaultInstanceForType() {
      return com.learning.protobuff_basics.beans.GenericMessageProto.getDefaultInstance();
    }

    @java.lang.Override
    public com.learning.protobuff_basics.beans.GenericMessageProto build() {
      com.learning.protobuff_basics.beans.GenericMessageProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.learning.protobuff_basics.beans.GenericMessageProto buildPartial() {
      com.learning.protobuff_basics.beans.GenericMessageProto result = new com.learning.protobuff_basics.beans.GenericMessageProto(this);
      if (anyDataBuilder_ == null) {
        result.anyData_ = anyData_;
      } else {
        result.anyData_ = anyDataBuilder_.build();
      }
      result.type_ = type_;
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
      if (other instanceof com.learning.protobuff_basics.beans.GenericMessageProto) {
        return mergeFrom((com.learning.protobuff_basics.beans.GenericMessageProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.learning.protobuff_basics.beans.GenericMessageProto other) {
      if (other == com.learning.protobuff_basics.beans.GenericMessageProto.getDefaultInstance()) return this;
      if (other.hasAnyData()) {
        mergeAnyData(other.getAnyData());
      }
      if (!other.getType().isEmpty()) {
        type_ = other.type_;
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
      com.learning.protobuff_basics.beans.GenericMessageProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.learning.protobuff_basics.beans.GenericMessageProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.Any anyData_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> anyDataBuilder_;
    /**
     * <pre>
     *store any data
     * </pre>
     *
     * <code>.google.protobuf.Any any_data = 1;</code>
     */
    public boolean hasAnyData() {
      return anyDataBuilder_ != null || anyData_ != null;
    }
    /**
     * <pre>
     *store any data
     * </pre>
     *
     * <code>.google.protobuf.Any any_data = 1;</code>
     */
    public com.google.protobuf.Any getAnyData() {
      if (anyDataBuilder_ == null) {
        return anyData_ == null ? com.google.protobuf.Any.getDefaultInstance() : anyData_;
      } else {
        return anyDataBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *store any data
     * </pre>
     *
     * <code>.google.protobuf.Any any_data = 1;</code>
     */
    public Builder setAnyData(com.google.protobuf.Any value) {
      if (anyDataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        anyData_ = value;
        onChanged();
      } else {
        anyDataBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     *store any data
     * </pre>
     *
     * <code>.google.protobuf.Any any_data = 1;</code>
     */
    public Builder setAnyData(
        com.google.protobuf.Any.Builder builderForValue) {
      if (anyDataBuilder_ == null) {
        anyData_ = builderForValue.build();
        onChanged();
      } else {
        anyDataBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     *store any data
     * </pre>
     *
     * <code>.google.protobuf.Any any_data = 1;</code>
     */
    public Builder mergeAnyData(com.google.protobuf.Any value) {
      if (anyDataBuilder_ == null) {
        if (anyData_ != null) {
          anyData_ =
            com.google.protobuf.Any.newBuilder(anyData_).mergeFrom(value).buildPartial();
        } else {
          anyData_ = value;
        }
        onChanged();
      } else {
        anyDataBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     *store any data
     * </pre>
     *
     * <code>.google.protobuf.Any any_data = 1;</code>
     */
    public Builder clearAnyData() {
      if (anyDataBuilder_ == null) {
        anyData_ = null;
        onChanged();
      } else {
        anyData_ = null;
        anyDataBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     *store any data
     * </pre>
     *
     * <code>.google.protobuf.Any any_data = 1;</code>
     */
    public com.google.protobuf.Any.Builder getAnyDataBuilder() {
      
      onChanged();
      return getAnyDataFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *store any data
     * </pre>
     *
     * <code>.google.protobuf.Any any_data = 1;</code>
     */
    public com.google.protobuf.AnyOrBuilder getAnyDataOrBuilder() {
      if (anyDataBuilder_ != null) {
        return anyDataBuilder_.getMessageOrBuilder();
      } else {
        return anyData_ == null ?
            com.google.protobuf.Any.getDefaultInstance() : anyData_;
      }
    }
    /**
     * <pre>
     *store any data
     * </pre>
     *
     * <code>.google.protobuf.Any any_data = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> 
        getAnyDataFieldBuilder() {
      if (anyDataBuilder_ == null) {
        anyDataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder>(
                getAnyData(),
                getParentForChildren(),
                isClean());
        anyData_ = null;
      }
      return anyDataBuilder_;
    }

    private java.lang.Object type_ = "";
    /**
     * <pre>
     *store class type
     * </pre>
     *
     * <code>string type = 2;</code>
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *store class type
     * </pre>
     *
     * <code>string type = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *store class type
     * </pre>
     *
     * <code>string type = 2;</code>
     */
    public Builder setType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *store class type
     * </pre>
     *
     * <code>string type = 2;</code>
     */
    public Builder clearType() {
      
      type_ = getDefaultInstance().getType();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *store class type
     * </pre>
     *
     * <code>string type = 2;</code>
     */
    public Builder setTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      type_ = value;
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


    // @@protoc_insertion_point(builder_scope:GenericMessageProto)
  }

  // @@protoc_insertion_point(class_scope:GenericMessageProto)
  private static final com.learning.protobuff_basics.beans.GenericMessageProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.learning.protobuff_basics.beans.GenericMessageProto();
  }

  public static com.learning.protobuff_basics.beans.GenericMessageProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GenericMessageProto>
      PARSER = new com.google.protobuf.AbstractParser<GenericMessageProto>() {
    @java.lang.Override
    public GenericMessageProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GenericMessageProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GenericMessageProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GenericMessageProto> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.learning.protobuff_basics.beans.GenericMessageProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

