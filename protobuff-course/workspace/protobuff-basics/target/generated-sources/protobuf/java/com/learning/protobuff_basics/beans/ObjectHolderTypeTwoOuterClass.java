// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: objectHolderTypeTwo.proto

package com.learning.protobuff_basics.beans;

public final class ObjectHolderTypeTwoOuterClass {
  private ObjectHolderTypeTwoOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ObjectHolderTypeTwo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ObjectHolderTypeTwo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031objectHolderTypeTwo.proto\"%\n\023ObjectHol" +
      "derTypeTwo\022\016\n\006field1\030\001 \001(\005B\'\n#com.learni" +
      "ng.protobuff_basics.beansP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ObjectHolderTypeTwo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ObjectHolderTypeTwo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ObjectHolderTypeTwo_descriptor,
        new java.lang.String[] { "Field1", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}