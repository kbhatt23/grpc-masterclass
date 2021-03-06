// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: person.proto

package com.learning.protobuff_basics.beans;

public interface PersonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Person)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *first name seperate
   * </pre>
   *
   * <code>string first_name = 1;</code>
   */
  java.lang.String getFirstName();
  /**
   * <pre>
   *first name seperate
   * </pre>
   *
   * <code>string first_name = 1;</code>
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <pre>
   *last name seperate
   * </pre>
   *
   * <code>string last_name = 2;</code>
   */
  java.lang.String getLastName();
  /**
   * <pre>
   *last name seperate
   * </pre>
   *
   * <code>string last_name = 2;</code>
   */
  com.google.protobuf.ByteString
      getLastNameBytes();

  /**
   * <code>int32 age = 3;</code>
   */
  int getAge();

  /**
   * <pre>
   *image in jpeg format
   * </pre>
   *
   * <code>bytes image = 4;</code>
   */
  com.google.protobuf.ByteString getImage();

  /**
   * <pre>
   *height in cms
   * </pre>
   *
   * <code>double height = 5;</code>
   */
  double getHeight();

  /**
   * <code>bool is_email_verified = 6;</code>
   */
  boolean getIsEmailVerified();

  /**
   * <code>repeated string emails = 7;</code>
   */
  java.util.List<java.lang.String>
      getEmailsList();
  /**
   * <code>repeated string emails = 7;</code>
   */
  int getEmailsCount();
  /**
   * <code>repeated string emails = 7;</code>
   */
  java.lang.String getEmails(int index);
  /**
   * <code>repeated string emails = 7;</code>
   */
  com.google.protobuf.ByteString
      getEmailsBytes(int index);

  /**
   * <pre>
   *enumerated gender -&gt; default to unkown
   * </pre>
   *
   * <code>.Person.NestedGender gender = 8;</code>
   */
  int getGenderValue();
  /**
   * <pre>
   *enumerated gender -&gt; default to unkown
   * </pre>
   *
   * <code>.Person.NestedGender gender = 8;</code>
   */
  com.learning.protobuff_basics.beans.Person.NestedGender getGender();

  /**
   * <code>.Person.NestedAddress nestedAddress = 9;</code>
   */
  boolean hasNestedAddress();
  /**
   * <code>.Person.NestedAddress nestedAddress = 9;</code>
   */
  com.learning.protobuff_basics.beans.Person.NestedAddress getNestedAddress();
  /**
   * <code>.Person.NestedAddress nestedAddress = 9;</code>
   */
  com.learning.protobuff_basics.beans.Person.NestedAddressOrBuilder getNestedAddressOrBuilder();

  /**
   * <code>.utils.Address address = 10;</code>
   */
  boolean hasAddress();
  /**
   * <code>.utils.Address address = 10;</code>
   */
  com.learning.protobuff_basics.beans.Address getAddress();
  /**
   * <code>.utils.Address address = 10;</code>
   */
  com.learning.protobuff_basics.beans.AddressOrBuilder getAddressOrBuilder();
}
