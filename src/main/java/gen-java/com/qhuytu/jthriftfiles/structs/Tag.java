/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.qhuytu.jthriftfiles.structs;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-07-02")
public enum Tag implements org.apache.thrift.TEnum {
  DEFAULT(0),
  WORK(1),
  FRIEND(2),
  FAMILY(3);

  private final int value;

  private Tag(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static Tag findByValue(int value) { 
    switch (value) {
      case 0:
        return DEFAULT;
      case 1:
        return WORK;
      case 2:
        return FRIEND;
      case 3:
        return FAMILY;
      default:
        return null;
    }
  }
}
