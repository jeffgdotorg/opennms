/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2020 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2024 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.netmgt.rrd.tcp;

public final class PerformanceDataProtos {
  private PerformanceDataProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PerformanceDataReadingOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PerformanceDataReading)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string path = 1;</code>
     * @return Whether the path field is set.
     */
    boolean hasPath();
    /**
     * <code>required string path = 1;</code>
     * @return The path.
     */
    java.lang.String getPath();
    /**
     * <code>required string path = 1;</code>
     * @return The bytes for path.
     */
    com.google.protobuf.ByteString
        getPathBytes();

    /**
     * <code>required string owner = 2;</code>
     * @return Whether the owner field is set.
     */
    boolean hasOwner();
    /**
     * <code>required string owner = 2;</code>
     * @return The owner.
     */
    java.lang.String getOwner();
    /**
     * <code>required string owner = 2;</code>
     * @return The bytes for owner.
     */
    com.google.protobuf.ByteString
        getOwnerBytes();

    /**
     * <code>required uint64 timestamp = 3;</code>
     * @return Whether the timestamp field is set.
     */
    boolean hasTimestamp();
    /**
     * <code>required uint64 timestamp = 3;</code>
     * @return The timestamp.
     */
    long getTimestamp();

    /**
     * <code>repeated double dblValue = 4;</code>
     * @return A list containing the dblValue.
     */
    java.util.List<java.lang.Double> getDblValueList();
    /**
     * <code>repeated double dblValue = 4;</code>
     * @return The count of dblValue.
     */
    int getDblValueCount();
    /**
     * <code>repeated double dblValue = 4;</code>
     * @param index The index of the element to return.
     * @return The dblValue at the given index.
     */
    double getDblValue(int index);

    /**
     * <code>repeated string strValue = 5;</code>
     * @return A list containing the strValue.
     */
    java.util.List<java.lang.String>
        getStrValueList();
    /**
     * <code>repeated string strValue = 5;</code>
     * @return The count of strValue.
     */
    int getStrValueCount();
    /**
     * <code>repeated string strValue = 5;</code>
     * @param index The index of the element to return.
     * @return The strValue at the given index.
     */
    java.lang.String getStrValue(int index);
    /**
     * <code>repeated string strValue = 5;</code>
     * @param index The index of the value to return.
     * @return The bytes of the strValue at the given index.
     */
    com.google.protobuf.ByteString
        getStrValueBytes(int index);
  }
  /**
   * Protobuf type {@code PerformanceDataReading}
   */
  public static final class PerformanceDataReading extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PerformanceDataReading)
      PerformanceDataReadingOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use PerformanceDataReading.newBuilder() to construct.
    private PerformanceDataReading(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PerformanceDataReading() {
      path_ = "";
      owner_ = "";
      dblValue_ = emptyDoubleList();
      strValue_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new PerformanceDataReading();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.internal_static_PerformanceDataReading_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.internal_static_PerformanceDataReading_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.class, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder.class);
    }

    private int bitField0_;
    public static final int PATH_FIELD_NUMBER = 1;
    private volatile java.lang.Object path_;
    /**
     * <code>required string path = 1;</code>
     * @return Whether the path field is set.
     */
    @java.lang.Override
    public boolean hasPath() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required string path = 1;</code>
     * @return The path.
     */
    @java.lang.Override
    public java.lang.String getPath() {
      java.lang.Object ref = path_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          path_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string path = 1;</code>
     * @return The bytes for path.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getPathBytes() {
      java.lang.Object ref = path_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        path_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int OWNER_FIELD_NUMBER = 2;
    private volatile java.lang.Object owner_;
    /**
     * <code>required string owner = 2;</code>
     * @return Whether the owner field is set.
     */
    @java.lang.Override
    public boolean hasOwner() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required string owner = 2;</code>
     * @return The owner.
     */
    @java.lang.Override
    public java.lang.String getOwner() {
      java.lang.Object ref = owner_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          owner_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string owner = 2;</code>
     * @return The bytes for owner.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getOwnerBytes() {
      java.lang.Object ref = owner_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        owner_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    private long timestamp_;
    /**
     * <code>required uint64 timestamp = 3;</code>
     * @return Whether the timestamp field is set.
     */
    @java.lang.Override
    public boolean hasTimestamp() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>required uint64 timestamp = 3;</code>
     * @return The timestamp.
     */
    @java.lang.Override
    public long getTimestamp() {
      return timestamp_;
    }

    public static final int DBLVALUE_FIELD_NUMBER = 4;
    private com.google.protobuf.Internal.DoubleList dblValue_;
    /**
     * <code>repeated double dblValue = 4;</code>
     * @return A list containing the dblValue.
     */
    @java.lang.Override
    public java.util.List<java.lang.Double>
        getDblValueList() {
      return dblValue_;
    }
    /**
     * <code>repeated double dblValue = 4;</code>
     * @return The count of dblValue.
     */
    public int getDblValueCount() {
      return dblValue_.size();
    }
    /**
     * <code>repeated double dblValue = 4;</code>
     * @param index The index of the element to return.
     * @return The dblValue at the given index.
     */
    public double getDblValue(int index) {
      return dblValue_.getDouble(index);
    }

    public static final int STRVALUE_FIELD_NUMBER = 5;
    private com.google.protobuf.LazyStringList strValue_;
    /**
     * <code>repeated string strValue = 5;</code>
     * @return A list containing the strValue.
     */
    public com.google.protobuf.ProtocolStringList
        getStrValueList() {
      return strValue_;
    }
    /**
     * <code>repeated string strValue = 5;</code>
     * @return The count of strValue.
     */
    public int getStrValueCount() {
      return strValue_.size();
    }
    /**
     * <code>repeated string strValue = 5;</code>
     * @param index The index of the element to return.
     * @return The strValue at the given index.
     */
    public java.lang.String getStrValue(int index) {
      return strValue_.get(index);
    }
    /**
     * <code>repeated string strValue = 5;</code>
     * @param index The index of the value to return.
     * @return The bytes of the strValue at the given index.
     */
    public com.google.protobuf.ByteString
        getStrValueBytes(int index) {
      return strValue_.getByteString(index);
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasPath()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasOwner()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasTimestamp()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, path_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, owner_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        output.writeUInt64(3, timestamp_);
      }
      for (int i = 0; i < dblValue_.size(); i++) {
        output.writeDouble(4, dblValue_.getDouble(i));
      }
      for (int i = 0; i < strValue_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, strValue_.getRaw(i));
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, path_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, owner_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(3, timestamp_);
      }
      {
        int dataSize = 0;
        dataSize = 8 * getDblValueList().size();
        size += dataSize;
        size += 1 * getDblValueList().size();
      }
      {
        int dataSize = 0;
        for (int i = 0; i < strValue_.size(); i++) {
          dataSize += computeStringSizeNoTag(strValue_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getStrValueList().size();
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading)) {
        return super.equals(obj);
      }
      org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading other = (org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading) obj;

      if (hasPath() != other.hasPath()) return false;
      if (hasPath()) {
        if (!getPath()
            .equals(other.getPath())) return false;
      }
      if (hasOwner() != other.hasOwner()) return false;
      if (hasOwner()) {
        if (!getOwner()
            .equals(other.getOwner())) return false;
      }
      if (hasTimestamp() != other.hasTimestamp()) return false;
      if (hasTimestamp()) {
        if (getTimestamp()
            != other.getTimestamp()) return false;
      }
      if (!getDblValueList()
          .equals(other.getDblValueList())) return false;
      if (!getStrValueList()
          .equals(other.getStrValueList())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasPath()) {
        hash = (37 * hash) + PATH_FIELD_NUMBER;
        hash = (53 * hash) + getPath().hashCode();
      }
      if (hasOwner()) {
        hash = (37 * hash) + OWNER_FIELD_NUMBER;
        hash = (53 * hash) + getOwner().hashCode();
      }
      if (hasTimestamp()) {
        hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getTimestamp());
      }
      if (getDblValueCount() > 0) {
        hash = (37 * hash) + DBLVALUE_FIELD_NUMBER;
        hash = (53 * hash) + getDblValueList().hashCode();
      }
      if (getStrValueCount() > 0) {
        hash = (37 * hash) + STRVALUE_FIELD_NUMBER;
        hash = (53 * hash) + getStrValueList().hashCode();
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading parseFrom(
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
    public static Builder newBuilder(org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading prototype) {
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
     * Protobuf type {@code PerformanceDataReading}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PerformanceDataReading)
        org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.internal_static_PerformanceDataReading_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.internal_static_PerformanceDataReading_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.class, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder.class);
      }

      // Construct using org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        path_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        owner_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        timestamp_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000004);
        dblValue_ = emptyDoubleList();
        bitField0_ = (bitField0_ & ~0x00000008);
        strValue_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.internal_static_PerformanceDataReading_descriptor;
      }

      @java.lang.Override
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading getDefaultInstanceForType() {
        return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.getDefaultInstance();
      }

      @java.lang.Override
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading build() {
        org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading buildPartial() {
        org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading result = new org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          to_bitField0_ |= 0x00000001;
        }
        result.path_ = path_;
        if (((from_bitField0_ & 0x00000002) != 0)) {
          to_bitField0_ |= 0x00000002;
        }
        result.owner_ = owner_;
        if (((from_bitField0_ & 0x00000004) != 0)) {
          result.timestamp_ = timestamp_;
          to_bitField0_ |= 0x00000004;
        }
        if (((bitField0_ & 0x00000008) != 0)) {
          dblValue_.makeImmutable();
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.dblValue_ = dblValue_;
        if (((bitField0_ & 0x00000010) != 0)) {
          strValue_ = strValue_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.strValue_ = strValue_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading) {
          return mergeFrom((org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading other) {
        if (other == org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.getDefaultInstance()) return this;
        if (other.hasPath()) {
          bitField0_ |= 0x00000001;
          path_ = other.path_;
          onChanged();
        }
        if (other.hasOwner()) {
          bitField0_ |= 0x00000002;
          owner_ = other.owner_;
          onChanged();
        }
        if (other.hasTimestamp()) {
          setTimestamp(other.getTimestamp());
        }
        if (!other.dblValue_.isEmpty()) {
          if (dblValue_.isEmpty()) {
            dblValue_ = other.dblValue_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureDblValueIsMutable();
            dblValue_.addAll(other.dblValue_);
          }
          onChanged();
        }
        if (!other.strValue_.isEmpty()) {
          if (strValue_.isEmpty()) {
            strValue_ = other.strValue_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensureStrValueIsMutable();
            strValue_.addAll(other.strValue_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasPath()) {
          return false;
        }
        if (!hasOwner()) {
          return false;
        }
        if (!hasTimestamp()) {
          return false;
        }
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 10: {
                path_ = input.readBytes();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              case 18: {
                owner_ = input.readBytes();
                bitField0_ |= 0x00000002;
                break;
              } // case 18
              case 24: {
                timestamp_ = input.readUInt64();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
              case 33: {
                double v = input.readDouble();
                ensureDblValueIsMutable();
                dblValue_.addDouble(v);
                break;
              } // case 33
              case 34: {
                int length = input.readRawVarint32();
                int limit = input.pushLimit(length);
                ensureDblValueIsMutable();
                while (input.getBytesUntilLimit() > 0) {
                  dblValue_.addDouble(input.readDouble());
                }
                input.popLimit(limit);
                break;
              } // case 34
              case 42: {
                com.google.protobuf.ByteString bs = input.readBytes();
                ensureStrValueIsMutable();
                strValue_.add(bs);
                break;
              } // case 42
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private java.lang.Object path_ = "";
      /**
       * <code>required string path = 1;</code>
       * @return Whether the path field is set.
       */
      public boolean hasPath() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required string path = 1;</code>
       * @return The path.
       */
      public java.lang.String getPath() {
        java.lang.Object ref = path_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            path_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string path = 1;</code>
       * @return The bytes for path.
       */
      public com.google.protobuf.ByteString
          getPathBytes() {
        java.lang.Object ref = path_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          path_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string path = 1;</code>
       * @param value The path to set.
       * @return This builder for chaining.
       */
      public Builder setPath(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        path_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string path = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearPath() {
        bitField0_ = (bitField0_ & ~0x00000001);
        path_ = getDefaultInstance().getPath();
        onChanged();
        return this;
      }
      /**
       * <code>required string path = 1;</code>
       * @param value The bytes for path to set.
       * @return This builder for chaining.
       */
      public Builder setPathBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        path_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object owner_ = "";
      /**
       * <code>required string owner = 2;</code>
       * @return Whether the owner field is set.
       */
      public boolean hasOwner() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>required string owner = 2;</code>
       * @return The owner.
       */
      public java.lang.String getOwner() {
        java.lang.Object ref = owner_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            owner_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string owner = 2;</code>
       * @return The bytes for owner.
       */
      public com.google.protobuf.ByteString
          getOwnerBytes() {
        java.lang.Object ref = owner_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          owner_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string owner = 2;</code>
       * @param value The owner to set.
       * @return This builder for chaining.
       */
      public Builder setOwner(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        owner_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string owner = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearOwner() {
        bitField0_ = (bitField0_ & ~0x00000002);
        owner_ = getDefaultInstance().getOwner();
        onChanged();
        return this;
      }
      /**
       * <code>required string owner = 2;</code>
       * @param value The bytes for owner to set.
       * @return This builder for chaining.
       */
      public Builder setOwnerBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        owner_ = value;
        onChanged();
        return this;
      }

      private long timestamp_ ;
      /**
       * <code>required uint64 timestamp = 3;</code>
       * @return Whether the timestamp field is set.
       */
      @java.lang.Override
      public boolean hasTimestamp() {
        return ((bitField0_ & 0x00000004) != 0);
      }
      /**
       * <code>required uint64 timestamp = 3;</code>
       * @return The timestamp.
       */
      @java.lang.Override
      public long getTimestamp() {
        return timestamp_;
      }
      /**
       * <code>required uint64 timestamp = 3;</code>
       * @param value The timestamp to set.
       * @return This builder for chaining.
       */
      public Builder setTimestamp(long value) {
        bitField0_ |= 0x00000004;
        timestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint64 timestamp = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearTimestamp() {
        bitField0_ = (bitField0_ & ~0x00000004);
        timestamp_ = 0L;
        onChanged();
        return this;
      }

      private com.google.protobuf.Internal.DoubleList dblValue_ = emptyDoubleList();
      private void ensureDblValueIsMutable() {
        if (!((bitField0_ & 0x00000008) != 0)) {
          dblValue_ = mutableCopy(dblValue_);
          bitField0_ |= 0x00000008;
         }
      }
      /**
       * <code>repeated double dblValue = 4;</code>
       * @return A list containing the dblValue.
       */
      public java.util.List<java.lang.Double>
          getDblValueList() {
        return ((bitField0_ & 0x00000008) != 0) ?
                 java.util.Collections.unmodifiableList(dblValue_) : dblValue_;
      }
      /**
       * <code>repeated double dblValue = 4;</code>
       * @return The count of dblValue.
       */
      public int getDblValueCount() {
        return dblValue_.size();
      }
      /**
       * <code>repeated double dblValue = 4;</code>
       * @param index The index of the element to return.
       * @return The dblValue at the given index.
       */
      public double getDblValue(int index) {
        return dblValue_.getDouble(index);
      }
      /**
       * <code>repeated double dblValue = 4;</code>
       * @param index The index to set the value at.
       * @param value The dblValue to set.
       * @return This builder for chaining.
       */
      public Builder setDblValue(
          int index, double value) {
        ensureDblValueIsMutable();
        dblValue_.setDouble(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double dblValue = 4;</code>
       * @param value The dblValue to add.
       * @return This builder for chaining.
       */
      public Builder addDblValue(double value) {
        ensureDblValueIsMutable();
        dblValue_.addDouble(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double dblValue = 4;</code>
       * @param values The dblValue to add.
       * @return This builder for chaining.
       */
      public Builder addAllDblValue(
          java.lang.Iterable<? extends java.lang.Double> values) {
        ensureDblValueIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dblValue_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double dblValue = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearDblValue() {
        dblValue_ = emptyDoubleList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
        return this;
      }

      private com.google.protobuf.LazyStringList strValue_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureStrValueIsMutable() {
        if (!((bitField0_ & 0x00000010) != 0)) {
          strValue_ = new com.google.protobuf.LazyStringArrayList(strValue_);
          bitField0_ |= 0x00000010;
         }
      }
      /**
       * <code>repeated string strValue = 5;</code>
       * @return A list containing the strValue.
       */
      public com.google.protobuf.ProtocolStringList
          getStrValueList() {
        return strValue_.getUnmodifiableView();
      }
      /**
       * <code>repeated string strValue = 5;</code>
       * @return The count of strValue.
       */
      public int getStrValueCount() {
        return strValue_.size();
      }
      /**
       * <code>repeated string strValue = 5;</code>
       * @param index The index of the element to return.
       * @return The strValue at the given index.
       */
      public java.lang.String getStrValue(int index) {
        return strValue_.get(index);
      }
      /**
       * <code>repeated string strValue = 5;</code>
       * @param index The index of the value to return.
       * @return The bytes of the strValue at the given index.
       */
      public com.google.protobuf.ByteString
          getStrValueBytes(int index) {
        return strValue_.getByteString(index);
      }
      /**
       * <code>repeated string strValue = 5;</code>
       * @param index The index to set the value at.
       * @param value The strValue to set.
       * @return This builder for chaining.
       */
      public Builder setStrValue(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureStrValueIsMutable();
        strValue_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string strValue = 5;</code>
       * @param value The strValue to add.
       * @return This builder for chaining.
       */
      public Builder addStrValue(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureStrValueIsMutable();
        strValue_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string strValue = 5;</code>
       * @param values The strValue to add.
       * @return This builder for chaining.
       */
      public Builder addAllStrValue(
          java.lang.Iterable<java.lang.String> values) {
        ensureStrValueIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, strValue_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string strValue = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearStrValue() {
        strValue_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string strValue = 5;</code>
       * @param value The bytes of the strValue to add.
       * @return This builder for chaining.
       */
      public Builder addStrValueBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureStrValueIsMutable();
        strValue_.add(value);
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:PerformanceDataReading)
    }

    // @@protoc_insertion_point(class_scope:PerformanceDataReading)
    private static final org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading();
    }

    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<PerformanceDataReading>
        PARSER = new com.google.protobuf.AbstractParser<PerformanceDataReading>() {
      @java.lang.Override
      public PerformanceDataReading parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<PerformanceDataReading> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PerformanceDataReading> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface PerformanceDataReadingsOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PerformanceDataReadings)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .PerformanceDataReading message = 1;</code>
     */
    java.util.List<org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading> 
        getMessageList();
    /**
     * <code>repeated .PerformanceDataReading message = 1;</code>
     */
    org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading getMessage(int index);
    /**
     * <code>repeated .PerformanceDataReading message = 1;</code>
     */
    int getMessageCount();
    /**
     * <code>repeated .PerformanceDataReading message = 1;</code>
     */
    java.util.List<? extends org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingOrBuilder> 
        getMessageOrBuilderList();
    /**
     * <code>repeated .PerformanceDataReading message = 1;</code>
     */
    org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingOrBuilder getMessageOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code PerformanceDataReadings}
   */
  public static final class PerformanceDataReadings extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PerformanceDataReadings)
      PerformanceDataReadingsOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use PerformanceDataReadings.newBuilder() to construct.
    private PerformanceDataReadings(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PerformanceDataReadings() {
      message_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new PerformanceDataReadings();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.internal_static_PerformanceDataReadings_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.internal_static_PerformanceDataReadings_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings.class, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings.Builder.class);
    }

    public static final int MESSAGE_FIELD_NUMBER = 1;
    private java.util.List<org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading> message_;
    /**
     * <code>repeated .PerformanceDataReading message = 1;</code>
     */
    @java.lang.Override
    public java.util.List<org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading> getMessageList() {
      return message_;
    }
    /**
     * <code>repeated .PerformanceDataReading message = 1;</code>
     */
    @java.lang.Override
    public java.util.List<? extends org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingOrBuilder> 
        getMessageOrBuilderList() {
      return message_;
    }
    /**
     * <code>repeated .PerformanceDataReading message = 1;</code>
     */
    @java.lang.Override
    public int getMessageCount() {
      return message_.size();
    }
    /**
     * <code>repeated .PerformanceDataReading message = 1;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading getMessage(int index) {
      return message_.get(index);
    }
    /**
     * <code>repeated .PerformanceDataReading message = 1;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingOrBuilder getMessageOrBuilder(
        int index) {
      return message_.get(index);
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      for (int i = 0; i < getMessageCount(); i++) {
        if (!getMessage(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      for (int i = 0; i < message_.size(); i++) {
        output.writeMessage(1, message_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < message_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, message_.get(i));
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings)) {
        return super.equals(obj);
      }
      org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings other = (org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings) obj;

      if (!getMessageList()
          .equals(other.getMessageList())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (getMessageCount() > 0) {
        hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
        hash = (53 * hash) + getMessageList().hashCode();
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings parseFrom(
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
    public static Builder newBuilder(org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings prototype) {
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
     * Protobuf type {@code PerformanceDataReadings}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PerformanceDataReadings)
        org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.internal_static_PerformanceDataReadings_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.internal_static_PerformanceDataReadings_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings.class, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings.Builder.class);
      }

      // Construct using org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (messageBuilder_ == null) {
          message_ = java.util.Collections.emptyList();
        } else {
          message_ = null;
          messageBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.internal_static_PerformanceDataReadings_descriptor;
      }

      @java.lang.Override
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings getDefaultInstanceForType() {
        return org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings.getDefaultInstance();
      }

      @java.lang.Override
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings build() {
        org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings buildPartial() {
        org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings result = new org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings(this);
        int from_bitField0_ = bitField0_;
        if (messageBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            message_ = java.util.Collections.unmodifiableList(message_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.message_ = message_;
        } else {
          result.message_ = messageBuilder_.build();
        }
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings) {
          return mergeFrom((org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings other) {
        if (other == org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings.getDefaultInstance()) return this;
        if (messageBuilder_ == null) {
          if (!other.message_.isEmpty()) {
            if (message_.isEmpty()) {
              message_ = other.message_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureMessageIsMutable();
              message_.addAll(other.message_);
            }
            onChanged();
          }
        } else {
          if (!other.message_.isEmpty()) {
            if (messageBuilder_.isEmpty()) {
              messageBuilder_.dispose();
              messageBuilder_ = null;
              message_ = other.message_;
              bitField0_ = (bitField0_ & ~0x00000001);
              messageBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getMessageFieldBuilder() : null;
            } else {
              messageBuilder_.addAllMessages(other.message_);
            }
          }
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        for (int i = 0; i < getMessageCount(); i++) {
          if (!getMessage(i).isInitialized()) {
            return false;
          }
        }
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 10: {
                org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading m =
                    input.readMessage(
                        org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.PARSER,
                        extensionRegistry);
                if (messageBuilder_ == null) {
                  ensureMessageIsMutable();
                  message_.add(m);
                } else {
                  messageBuilder_.addMessage(m);
                }
                break;
              } // case 10
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private java.util.List<org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading> message_ =
        java.util.Collections.emptyList();
      private void ensureMessageIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          message_ = new java.util.ArrayList<org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading>(message_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingOrBuilder> messageBuilder_;

      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public java.util.List<org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading> getMessageList() {
        if (messageBuilder_ == null) {
          return java.util.Collections.unmodifiableList(message_);
        } else {
          return messageBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public int getMessageCount() {
        if (messageBuilder_ == null) {
          return message_.size();
        } else {
          return messageBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading getMessage(int index) {
        if (messageBuilder_ == null) {
          return message_.get(index);
        } else {
          return messageBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public Builder setMessage(
          int index, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading value) {
        if (messageBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMessageIsMutable();
          message_.set(index, value);
          onChanged();
        } else {
          messageBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public Builder setMessage(
          int index, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder builderForValue) {
        if (messageBuilder_ == null) {
          ensureMessageIsMutable();
          message_.set(index, builderForValue.build());
          onChanged();
        } else {
          messageBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public Builder addMessage(org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading value) {
        if (messageBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMessageIsMutable();
          message_.add(value);
          onChanged();
        } else {
          messageBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public Builder addMessage(
          int index, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading value) {
        if (messageBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMessageIsMutable();
          message_.add(index, value);
          onChanged();
        } else {
          messageBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public Builder addMessage(
          org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder builderForValue) {
        if (messageBuilder_ == null) {
          ensureMessageIsMutable();
          message_.add(builderForValue.build());
          onChanged();
        } else {
          messageBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public Builder addMessage(
          int index, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder builderForValue) {
        if (messageBuilder_ == null) {
          ensureMessageIsMutable();
          message_.add(index, builderForValue.build());
          onChanged();
        } else {
          messageBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public Builder addAllMessage(
          java.lang.Iterable<? extends org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading> values) {
        if (messageBuilder_ == null) {
          ensureMessageIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, message_);
          onChanged();
        } else {
          messageBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public Builder clearMessage() {
        if (messageBuilder_ == null) {
          message_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          messageBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public Builder removeMessage(int index) {
        if (messageBuilder_ == null) {
          ensureMessageIsMutable();
          message_.remove(index);
          onChanged();
        } else {
          messageBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder getMessageBuilder(
          int index) {
        return getMessageFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingOrBuilder getMessageOrBuilder(
          int index) {
        if (messageBuilder_ == null) {
          return message_.get(index);  } else {
          return messageBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public java.util.List<? extends org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingOrBuilder> 
           getMessageOrBuilderList() {
        if (messageBuilder_ != null) {
          return messageBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(message_);
        }
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder addMessageBuilder() {
        return getMessageFieldBuilder().addBuilder(
            org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.getDefaultInstance());
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder addMessageBuilder(
          int index) {
        return getMessageFieldBuilder().addBuilder(
            index, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.getDefaultInstance());
      }
      /**
       * <code>repeated .PerformanceDataReading message = 1;</code>
       */
      public java.util.List<org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder> 
           getMessageBuilderList() {
        return getMessageFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingOrBuilder> 
          getMessageFieldBuilder() {
        if (messageBuilder_ == null) {
          messageBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReading.Builder, org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadingOrBuilder>(
                  message_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          message_ = null;
        }
        return messageBuilder_;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:PerformanceDataReadings)
    }

    // @@protoc_insertion_point(class_scope:PerformanceDataReadings)
    private static final org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings();
    }

    public static org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<PerformanceDataReadings>
        PARSER = new com.google.protobuf.AbstractParser<PerformanceDataReadings>() {
      @java.lang.Override
      public PerformanceDataReadings parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<PerformanceDataReadings> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PerformanceDataReadings> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.opennms.netmgt.rrd.tcp.PerformanceDataProtos.PerformanceDataReadings getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PerformanceDataReading_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PerformanceDataReading_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PerformanceDataReadings_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PerformanceDataReadings_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025PerformanceData.proto\"l\n\026PerformanceDa" +
      "taReading\022\014\n\004path\030\001 \002(\t\022\r\n\005owner\030\002 \002(\t\022\021" +
      "\n\ttimestamp\030\003 \002(\004\022\020\n\010dblValue\030\004 \003(\001\022\020\n\010s" +
      "trValue\030\005 \003(\t\"C\n\027PerformanceDataReadings" +
      "\022(\n\007message\030\001 \003(\0132\027.PerformanceDataReadi" +
      "ngB3\n\032org.opennms.netmgt.rrd.tcpB\025Perfor" +
      "manceDataProtos"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_PerformanceDataReading_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PerformanceDataReading_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PerformanceDataReading_descriptor,
        new java.lang.String[] { "Path", "Owner", "Timestamp", "DblValue", "StrValue", });
    internal_static_PerformanceDataReadings_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_PerformanceDataReadings_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PerformanceDataReadings_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
