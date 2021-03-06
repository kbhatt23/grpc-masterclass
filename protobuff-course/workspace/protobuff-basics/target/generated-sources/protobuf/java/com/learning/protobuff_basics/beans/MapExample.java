// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: mapExample.proto

package com.learning.protobuff_basics.beans;

/**
 * Protobuf type {@code MapExample}
 */
public  final class MapExample extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:MapExample)
    MapExampleOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MapExample.newBuilder() to construct.
  private MapExample(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MapExample() {
    id_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MapExample(
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
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              addressMap_ = com.google.protobuf.MapField.newMapField(
                  AddressMapDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000002;
            }
            com.google.protobuf.MapEntry<java.lang.Integer, com.learning.protobuff_basics.beans.Address>
            addressMap__ = input.readMessage(
                AddressMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            addressMap_.getMutableMap().put(
                addressMap__.getKey(), addressMap__.getValue());
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
    return com.learning.protobuff_basics.beans.MapExampleOuterClass.internal_static_MapExample_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 2:
        return internalGetAddressMap();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.learning.protobuff_basics.beans.MapExampleOuterClass.internal_static_MapExample_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.learning.protobuff_basics.beans.MapExample.class, com.learning.protobuff_basics.beans.MapExample.Builder.class);
  }

  private int bitField0_;
  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <pre>
   *never change tag of currently running property 
   * </pre>
   *
   * <code>int32 id = 1;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int ADDRESSMAP_FIELD_NUMBER = 2;
  private static final class AddressMapDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Integer, com.learning.protobuff_basics.beans.Address> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, com.learning.protobuff_basics.beans.Address>newDefaultInstance(
                com.learning.protobuff_basics.beans.MapExampleOuterClass.internal_static_MapExample_AddressMapEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT32,
                0,
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                com.learning.protobuff_basics.beans.Address.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      java.lang.Integer, com.learning.protobuff_basics.beans.Address> addressMap_;
  private com.google.protobuf.MapField<java.lang.Integer, com.learning.protobuff_basics.beans.Address>
  internalGetAddressMap() {
    if (addressMap_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          AddressMapDefaultEntryHolder.defaultEntry);
    }
    return addressMap_;
  }

  public int getAddressMapCount() {
    return internalGetAddressMap().getMap().size();
  }
  /**
   * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
   */

  public boolean containsAddressMap(
      int key) {
    
    return internalGetAddressMap().getMap().containsKey(key);
  }
  /**
   * Use {@link #getAddressMapMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.Integer, com.learning.protobuff_basics.beans.Address> getAddressMap() {
    return getAddressMapMap();
  }
  /**
   * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
   */

  public java.util.Map<java.lang.Integer, com.learning.protobuff_basics.beans.Address> getAddressMapMap() {
    return internalGetAddressMap().getMap();
  }
  /**
   * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
   */

  public com.learning.protobuff_basics.beans.Address getAddressMapOrDefault(
      int key,
      com.learning.protobuff_basics.beans.Address defaultValue) {
    
    java.util.Map<java.lang.Integer, com.learning.protobuff_basics.beans.Address> map =
        internalGetAddressMap().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
   */

  public com.learning.protobuff_basics.beans.Address getAddressMapOrThrow(
      int key) {
    
    java.util.Map<java.lang.Integer, com.learning.protobuff_basics.beans.Address> map =
        internalGetAddressMap().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeIntegerMapTo(
        output,
        internalGetAddressMap(),
        AddressMapDefaultEntryHolder.defaultEntry,
        2);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    for (java.util.Map.Entry<java.lang.Integer, com.learning.protobuff_basics.beans.Address> entry
         : internalGetAddressMap().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, com.learning.protobuff_basics.beans.Address>
      addressMap__ = AddressMapDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, addressMap__);
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
    if (!(obj instanceof com.learning.protobuff_basics.beans.MapExample)) {
      return super.equals(obj);
    }
    com.learning.protobuff_basics.beans.MapExample other = (com.learning.protobuff_basics.beans.MapExample) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && internalGetAddressMap().equals(
        other.internalGetAddressMap());
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
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    if (!internalGetAddressMap().getMap().isEmpty()) {
      hash = (37 * hash) + ADDRESSMAP_FIELD_NUMBER;
      hash = (53 * hash) + internalGetAddressMap().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.learning.protobuff_basics.beans.MapExample parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.learning.protobuff_basics.beans.MapExample parseFrom(
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
  public static Builder newBuilder(com.learning.protobuff_basics.beans.MapExample prototype) {
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
   * Protobuf type {@code MapExample}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:MapExample)
      com.learning.protobuff_basics.beans.MapExampleOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.learning.protobuff_basics.beans.MapExampleOuterClass.internal_static_MapExample_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetAddressMap();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetMutableAddressMap();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.learning.protobuff_basics.beans.MapExampleOuterClass.internal_static_MapExample_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.learning.protobuff_basics.beans.MapExample.class, com.learning.protobuff_basics.beans.MapExample.Builder.class);
    }

    // Construct using com.learning.protobuff_basics.beans.MapExample.newBuilder()
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
      id_ = 0;

      internalGetMutableAddressMap().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.learning.protobuff_basics.beans.MapExampleOuterClass.internal_static_MapExample_descriptor;
    }

    @java.lang.Override
    public com.learning.protobuff_basics.beans.MapExample getDefaultInstanceForType() {
      return com.learning.protobuff_basics.beans.MapExample.getDefaultInstance();
    }

    @java.lang.Override
    public com.learning.protobuff_basics.beans.MapExample build() {
      com.learning.protobuff_basics.beans.MapExample result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.learning.protobuff_basics.beans.MapExample buildPartial() {
      com.learning.protobuff_basics.beans.MapExample result = new com.learning.protobuff_basics.beans.MapExample(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.id_ = id_;
      result.addressMap_ = internalGetAddressMap();
      result.addressMap_.makeImmutable();
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
      if (other instanceof com.learning.protobuff_basics.beans.MapExample) {
        return mergeFrom((com.learning.protobuff_basics.beans.MapExample)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.learning.protobuff_basics.beans.MapExample other) {
      if (other == com.learning.protobuff_basics.beans.MapExample.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      internalGetMutableAddressMap().mergeFrom(
          other.internalGetAddressMap());
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
      com.learning.protobuff_basics.beans.MapExample parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.learning.protobuff_basics.beans.MapExample) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int id_ ;
    /**
     * <pre>
     *never change tag of currently running property 
     * </pre>
     *
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <pre>
     *never change tag of currently running property 
     * </pre>
     *
     * <code>int32 id = 1;</code>
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *never change tag of currently running property 
     * </pre>
     *
     * <code>int32 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.Integer, com.learning.protobuff_basics.beans.Address> addressMap_;
    private com.google.protobuf.MapField<java.lang.Integer, com.learning.protobuff_basics.beans.Address>
    internalGetAddressMap() {
      if (addressMap_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            AddressMapDefaultEntryHolder.defaultEntry);
      }
      return addressMap_;
    }
    private com.google.protobuf.MapField<java.lang.Integer, com.learning.protobuff_basics.beans.Address>
    internalGetMutableAddressMap() {
      onChanged();;
      if (addressMap_ == null) {
        addressMap_ = com.google.protobuf.MapField.newMapField(
            AddressMapDefaultEntryHolder.defaultEntry);
      }
      if (!addressMap_.isMutable()) {
        addressMap_ = addressMap_.copy();
      }
      return addressMap_;
    }

    public int getAddressMapCount() {
      return internalGetAddressMap().getMap().size();
    }
    /**
     * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
     */

    public boolean containsAddressMap(
        int key) {
      
      return internalGetAddressMap().getMap().containsKey(key);
    }
    /**
     * Use {@link #getAddressMapMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, com.learning.protobuff_basics.beans.Address> getAddressMap() {
      return getAddressMapMap();
    }
    /**
     * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
     */

    public java.util.Map<java.lang.Integer, com.learning.protobuff_basics.beans.Address> getAddressMapMap() {
      return internalGetAddressMap().getMap();
    }
    /**
     * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
     */

    public com.learning.protobuff_basics.beans.Address getAddressMapOrDefault(
        int key,
        com.learning.protobuff_basics.beans.Address defaultValue) {
      
      java.util.Map<java.lang.Integer, com.learning.protobuff_basics.beans.Address> map =
          internalGetAddressMap().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
     */

    public com.learning.protobuff_basics.beans.Address getAddressMapOrThrow(
        int key) {
      
      java.util.Map<java.lang.Integer, com.learning.protobuff_basics.beans.Address> map =
          internalGetAddressMap().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearAddressMap() {
      internalGetMutableAddressMap().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
     */

    public Builder removeAddressMap(
        int key) {
      
      internalGetMutableAddressMap().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, com.learning.protobuff_basics.beans.Address>
    getMutableAddressMap() {
      return internalGetMutableAddressMap().getMutableMap();
    }
    /**
     * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
     */
    public Builder putAddressMap(
        int key,
        com.learning.protobuff_basics.beans.Address value) {
      
      if (value == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableAddressMap().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;int32, .utils.Address&gt; addressMap = 2;</code>
     */

    public Builder putAllAddressMap(
        java.util.Map<java.lang.Integer, com.learning.protobuff_basics.beans.Address> values) {
      internalGetMutableAddressMap().getMutableMap()
          .putAll(values);
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


    // @@protoc_insertion_point(builder_scope:MapExample)
  }

  // @@protoc_insertion_point(class_scope:MapExample)
  private static final com.learning.protobuff_basics.beans.MapExample DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.learning.protobuff_basics.beans.MapExample();
  }

  public static com.learning.protobuff_basics.beans.MapExample getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MapExample>
      PARSER = new com.google.protobuf.AbstractParser<MapExample>() {
    @java.lang.Override
    public MapExample parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MapExample(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MapExample> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MapExample> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.learning.protobuff_basics.beans.MapExample getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

