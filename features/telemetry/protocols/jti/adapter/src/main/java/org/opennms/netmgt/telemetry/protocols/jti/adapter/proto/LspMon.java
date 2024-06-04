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

package org.opennms.netmgt.telemetry.protocols.jti.adapter.proto;

public final class LspMon {
  private LspMon() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * <pre>
   * List of events currently available
   * New events can be added to this list
   * </pre>
   *
   * Protobuf enum {@code lsp_event}
   */
  public enum lsp_event
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>INITIATED = 0;</code>
     */
    INITIATED(0),
    /**
     * <code>CONCLUDED_UP = 1;</code>
     */
    CONCLUDED_UP(1),
    /**
     * <code>CONCLUDED_TORN_DOWN = 2;</code>
     */
    CONCLUDED_TORN_DOWN(2),
    /**
     * <code>PROTECTION_AVAILABLE = 3;</code>
     */
    PROTECTION_AVAILABLE(3),
    /**
     * <code>PROTECTION_UNAVAILABLE = 4;</code>
     */
    PROTECTION_UNAVAILABLE(4),
    /**
     * <code>AUTOBW_SUCCESS = 5;</code>
     */
    AUTOBW_SUCCESS(5),
    /**
     * <code>AUTOBW_FAIL = 6;</code>
     */
    AUTOBW_FAIL(6),
    /**
     * <code>RESV_TEAR_RECEIVED = 7;</code>
     */
    RESV_TEAR_RECEIVED(7),
    /**
     * <code>DESELECT_ACTIVE_PATH = 8;</code>
     */
    DESELECT_ACTIVE_PATH(8),
    /**
     * <code>CHANGE_ACTIVE_PATH = 9;</code>
     */
    CHANGE_ACTIVE_PATH(9),
    /**
     * <code>DETOUR_UP = 10;</code>
     */
    DETOUR_UP(10),
    /**
     * <code>DETOUR_DOWN = 11;</code>
     */
    DETOUR_DOWN(11),
    /**
     * <code>ORIGINATE_MBB = 12;</code>
     */
    ORIGINATE_MBB(12),
    /**
     * <code>SELECT_ACTIVE_PATH = 13;</code>
     */
    SELECT_ACTIVE_PATH(13),
    /**
     * <code>CSPF_NO_ROUTE = 14;</code>
     */
    CSPF_NO_ROUTE(14),
    /**
     * <code>CSPF_SUCCESS = 15;</code>
     */
    CSPF_SUCCESS(15),
    /**
     * <code>RESTART_RECOVERY_FAIL = 16;</code>
     */
    RESTART_RECOVERY_FAIL(16),
    /**
     * <code>PATHERR_RECEIVED = 17;</code>
     */
    PATHERR_RECEIVED(17),
    /**
     * <code>PATH_MTU_CHANGE = 18;</code>
     */
    PATH_MTU_CHANGE(18),
    /**
     * <code>TUNNEL_LOCAL_REPAIRED = 19;</code>
     */
    TUNNEL_LOCAL_REPAIRED(19),
    ;

    /**
     * <code>INITIATED = 0;</code>
     */
    public static final int INITIATED_VALUE = 0;
    /**
     * <code>CONCLUDED_UP = 1;</code>
     */
    public static final int CONCLUDED_UP_VALUE = 1;
    /**
     * <code>CONCLUDED_TORN_DOWN = 2;</code>
     */
    public static final int CONCLUDED_TORN_DOWN_VALUE = 2;
    /**
     * <code>PROTECTION_AVAILABLE = 3;</code>
     */
    public static final int PROTECTION_AVAILABLE_VALUE = 3;
    /**
     * <code>PROTECTION_UNAVAILABLE = 4;</code>
     */
    public static final int PROTECTION_UNAVAILABLE_VALUE = 4;
    /**
     * <code>AUTOBW_SUCCESS = 5;</code>
     */
    public static final int AUTOBW_SUCCESS_VALUE = 5;
    /**
     * <code>AUTOBW_FAIL = 6;</code>
     */
    public static final int AUTOBW_FAIL_VALUE = 6;
    /**
     * <code>RESV_TEAR_RECEIVED = 7;</code>
     */
    public static final int RESV_TEAR_RECEIVED_VALUE = 7;
    /**
     * <code>DESELECT_ACTIVE_PATH = 8;</code>
     */
    public static final int DESELECT_ACTIVE_PATH_VALUE = 8;
    /**
     * <code>CHANGE_ACTIVE_PATH = 9;</code>
     */
    public static final int CHANGE_ACTIVE_PATH_VALUE = 9;
    /**
     * <code>DETOUR_UP = 10;</code>
     */
    public static final int DETOUR_UP_VALUE = 10;
    /**
     * <code>DETOUR_DOWN = 11;</code>
     */
    public static final int DETOUR_DOWN_VALUE = 11;
    /**
     * <code>ORIGINATE_MBB = 12;</code>
     */
    public static final int ORIGINATE_MBB_VALUE = 12;
    /**
     * <code>SELECT_ACTIVE_PATH = 13;</code>
     */
    public static final int SELECT_ACTIVE_PATH_VALUE = 13;
    /**
     * <code>CSPF_NO_ROUTE = 14;</code>
     */
    public static final int CSPF_NO_ROUTE_VALUE = 14;
    /**
     * <code>CSPF_SUCCESS = 15;</code>
     */
    public static final int CSPF_SUCCESS_VALUE = 15;
    /**
     * <code>RESTART_RECOVERY_FAIL = 16;</code>
     */
    public static final int RESTART_RECOVERY_FAIL_VALUE = 16;
    /**
     * <code>PATHERR_RECEIVED = 17;</code>
     */
    public static final int PATHERR_RECEIVED_VALUE = 17;
    /**
     * <code>PATH_MTU_CHANGE = 18;</code>
     */
    public static final int PATH_MTU_CHANGE_VALUE = 18;
    /**
     * <code>TUNNEL_LOCAL_REPAIRED = 19;</code>
     */
    public static final int TUNNEL_LOCAL_REPAIRED_VALUE = 19;


    public final int getNumber() {
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static lsp_event valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static lsp_event forNumber(int value) {
      switch (value) {
        case 0: return INITIATED;
        case 1: return CONCLUDED_UP;
        case 2: return CONCLUDED_TORN_DOWN;
        case 3: return PROTECTION_AVAILABLE;
        case 4: return PROTECTION_UNAVAILABLE;
        case 5: return AUTOBW_SUCCESS;
        case 6: return AUTOBW_FAIL;
        case 7: return RESV_TEAR_RECEIVED;
        case 8: return DESELECT_ACTIVE_PATH;
        case 9: return CHANGE_ACTIVE_PATH;
        case 10: return DETOUR_UP;
        case 11: return DETOUR_DOWN;
        case 12: return ORIGINATE_MBB;
        case 13: return SELECT_ACTIVE_PATH;
        case 14: return CSPF_NO_ROUTE;
        case 15: return CSPF_SUCCESS;
        case 16: return RESTART_RECOVERY_FAIL;
        case 17: return PATHERR_RECEIVED;
        case 18: return PATH_MTU_CHANGE;
        case 19: return TUNNEL_LOCAL_REPAIRED;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<lsp_event>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        lsp_event> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<lsp_event>() {
            public lsp_event findValueByNumber(int number) {
              return lsp_event.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.getDescriptor().getEnumTypes().get(0);
    }

    private static final lsp_event[] VALUES = values();

    public static lsp_event valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private lsp_event(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:lsp_event)
  }

  /**
   * Protobuf enum {@code event_subcode}
   */
  public enum event_subcode
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>ADMISSION_CONTROL_FAILURE = 1;</code>
     */
    ADMISSION_CONTROL_FAILURE(1),
    /**
     * <code>SESSION_PREEMPTED = 2;</code>
     */
    SESSION_PREEMPTED(2),
    /**
     * <code>BAD_LOOSE_ROUTE = 3;</code>
     */
    BAD_LOOSE_ROUTE(3),
    /**
     * <code>BAD_STRICT_ROUTE = 4;</code>
     */
    BAD_STRICT_ROUTE(4),
    /**
     * <code>LABEL_ALLOCATION_FAILURE = 5;</code>
     */
    LABEL_ALLOCATION_FAILURE(5),
    /**
     * <code>NON_RSVP_CAPABLE_ROUTER = 6;</code>
     */
    NON_RSVP_CAPABLE_ROUTER(6),
    /**
     * <code>TTL_EXPIRED = 7;</code>
     */
    TTL_EXPIRED(7),
    /**
     * <code>ROUTING_LOOP_DETECTED = 8;</code>
     */
    ROUTING_LOOP_DETECTED(8),
    /**
     * <code>REQUESTED_BANDWIDTH_UNAVAILABLE = 9;</code>
     */
    REQUESTED_BANDWIDTH_UNAVAILABLE(9),
    ;

    /**
     * <code>ADMISSION_CONTROL_FAILURE = 1;</code>
     */
    public static final int ADMISSION_CONTROL_FAILURE_VALUE = 1;
    /**
     * <code>SESSION_PREEMPTED = 2;</code>
     */
    public static final int SESSION_PREEMPTED_VALUE = 2;
    /**
     * <code>BAD_LOOSE_ROUTE = 3;</code>
     */
    public static final int BAD_LOOSE_ROUTE_VALUE = 3;
    /**
     * <code>BAD_STRICT_ROUTE = 4;</code>
     */
    public static final int BAD_STRICT_ROUTE_VALUE = 4;
    /**
     * <code>LABEL_ALLOCATION_FAILURE = 5;</code>
     */
    public static final int LABEL_ALLOCATION_FAILURE_VALUE = 5;
    /**
     * <code>NON_RSVP_CAPABLE_ROUTER = 6;</code>
     */
    public static final int NON_RSVP_CAPABLE_ROUTER_VALUE = 6;
    /**
     * <code>TTL_EXPIRED = 7;</code>
     */
    public static final int TTL_EXPIRED_VALUE = 7;
    /**
     * <code>ROUTING_LOOP_DETECTED = 8;</code>
     */
    public static final int ROUTING_LOOP_DETECTED_VALUE = 8;
    /**
     * <code>REQUESTED_BANDWIDTH_UNAVAILABLE = 9;</code>
     */
    public static final int REQUESTED_BANDWIDTH_UNAVAILABLE_VALUE = 9;


    public final int getNumber() {
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static event_subcode valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static event_subcode forNumber(int value) {
      switch (value) {
        case 1: return ADMISSION_CONTROL_FAILURE;
        case 2: return SESSION_PREEMPTED;
        case 3: return BAD_LOOSE_ROUTE;
        case 4: return BAD_STRICT_ROUTE;
        case 5: return LABEL_ALLOCATION_FAILURE;
        case 6: return NON_RSVP_CAPABLE_ROUTER;
        case 7: return TTL_EXPIRED;
        case 8: return ROUTING_LOOP_DETECTED;
        case 9: return REQUESTED_BANDWIDTH_UNAVAILABLE;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<event_subcode>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        event_subcode> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<event_subcode>() {
            public event_subcode findValueByNumber(int number) {
              return event_subcode.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.getDescriptor().getEnumTypes().get(1);
    }

    private static final event_subcode[] VALUES = values();

    public static event_subcode valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private event_subcode(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:event_subcode)
  }

  public interface keyOrBuilder extends
      // @@protoc_insertion_point(interface_extends:key)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string name = 1;</code>
     * @return Whether the name field is set.
     */
    boolean hasName();
    /**
     * <code>required string name = 1;</code>
     * @return The name.
     */
    java.lang.String getName();
    /**
     * <code>required string name = 1;</code>
     * @return The bytes for name.
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>required int32 instance_identifier = 2;</code>
     * @return Whether the instanceIdentifier field is set.
     */
    boolean hasInstanceIdentifier();
    /**
     * <code>required int32 instance_identifier = 2;</code>
     * @return The instanceIdentifier.
     */
    int getInstanceIdentifier();

    /**
     * <code>required uint64 time_stampg = 3;</code>
     * @return Whether the timeStampg field is set.
     */
    boolean hasTimeStampg();
    /**
     * <code>required uint64 time_stampg = 3;</code>
     * @return The timeStampg.
     */
    long getTimeStampg();
  }
  /**
   * <pre>
   * Schema for key for GPB msg receiver
   * </pre>
   *
   * Protobuf type {@code key}
   */
  public static final class key extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:key)
      keyOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use key.newBuilder() to construct.
    private key(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private key() {
      name_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new key();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_key_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_key_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.Builder.class);
    }

    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile java.lang.Object name_;
    /**
     * <code>required string name = 1;</code>
     * @return Whether the name field is set.
     */
    @java.lang.Override
    public boolean hasName() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required string name = 1;</code>
     * @return The name.
     */
    @java.lang.Override
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          name_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string name = 1;</code>
     * @return The bytes for name.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int INSTANCE_IDENTIFIER_FIELD_NUMBER = 2;
    private int instanceIdentifier_;
    /**
     * <code>required int32 instance_identifier = 2;</code>
     * @return Whether the instanceIdentifier field is set.
     */
    @java.lang.Override
    public boolean hasInstanceIdentifier() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required int32 instance_identifier = 2;</code>
     * @return The instanceIdentifier.
     */
    @java.lang.Override
    public int getInstanceIdentifier() {
      return instanceIdentifier_;
    }

    public static final int TIME_STAMPG_FIELD_NUMBER = 3;
    private long timeStampg_;
    /**
     * <code>required uint64 time_stampg = 3;</code>
     * @return Whether the timeStampg field is set.
     */
    @java.lang.Override
    public boolean hasTimeStampg() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>required uint64 time_stampg = 3;</code>
     * @return The timeStampg.
     */
    @java.lang.Override
    public long getTimeStampg() {
      return timeStampg_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasInstanceIdentifier()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasTimeStampg()) {
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
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        output.writeInt32(2, instanceIdentifier_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        output.writeUInt64(3, timeStampg_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, instanceIdentifier_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(3, timeStampg_);
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
      if (!(obj instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key)) {
        return super.equals(obj);
      }
      org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key other = (org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key) obj;

      if (hasName() != other.hasName()) return false;
      if (hasName()) {
        if (!getName()
            .equals(other.getName())) return false;
      }
      if (hasInstanceIdentifier() != other.hasInstanceIdentifier()) return false;
      if (hasInstanceIdentifier()) {
        if (getInstanceIdentifier()
            != other.getInstanceIdentifier()) return false;
      }
      if (hasTimeStampg() != other.hasTimeStampg()) return false;
      if (hasTimeStampg()) {
        if (getTimeStampg()
            != other.getTimeStampg()) return false;
      }
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
      if (hasName()) {
        hash = (37 * hash) + NAME_FIELD_NUMBER;
        hash = (53 * hash) + getName().hashCode();
      }
      if (hasInstanceIdentifier()) {
        hash = (37 * hash) + INSTANCE_IDENTIFIER_FIELD_NUMBER;
        hash = (53 * hash) + getInstanceIdentifier();
      }
      if (hasTimeStampg()) {
        hash = (37 * hash) + TIME_STAMPG_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getTimeStampg());
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key parseFrom(
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
    public static Builder newBuilder(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key prototype) {
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
     * <pre>
     * Schema for key for GPB msg receiver
     * </pre>
     *
     * Protobuf type {@code key}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:key)
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.keyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_key_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_key_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.Builder.class);
      }

      // Construct using org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        name_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        instanceIdentifier_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        timeStampg_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_key_descriptor;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key getDefaultInstanceForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.getDefaultInstance();
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key build() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key buildPartial() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key result = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          to_bitField0_ |= 0x00000001;
        }
        result.name_ = name_;
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.instanceIdentifier_ = instanceIdentifier_;
          to_bitField0_ |= 0x00000002;
        }
        if (((from_bitField0_ & 0x00000004) != 0)) {
          result.timeStampg_ = timeStampg_;
          to_bitField0_ |= 0x00000004;
        }
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
        if (other instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key) {
          return mergeFrom((org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key other) {
        if (other == org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.getDefaultInstance()) return this;
        if (other.hasName()) {
          bitField0_ |= 0x00000001;
          name_ = other.name_;
          onChanged();
        }
        if (other.hasInstanceIdentifier()) {
          setInstanceIdentifier(other.getInstanceIdentifier());
        }
        if (other.hasTimeStampg()) {
          setTimeStampg(other.getTimeStampg());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasName()) {
          return false;
        }
        if (!hasInstanceIdentifier()) {
          return false;
        }
        if (!hasTimeStampg()) {
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
                name_ = input.readBytes();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              case 16: {
                instanceIdentifier_ = input.readInt32();
                bitField0_ |= 0x00000002;
                break;
              } // case 16
              case 24: {
                timeStampg_ = input.readUInt64();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
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

      private java.lang.Object name_ = "";
      /**
       * <code>required string name = 1;</code>
       * @return Whether the name field is set.
       */
      public boolean hasName() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required string name = 1;</code>
       * @return The name.
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            name_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string name = 1;</code>
       * @return The bytes for name.
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string name = 1;</code>
       * @param value The name to set.
       * @return This builder for chaining.
       */
      public Builder setName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string name = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearName() {
        bitField0_ = (bitField0_ & ~0x00000001);
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>required string name = 1;</code>
       * @param value The bytes for name to set.
       * @return This builder for chaining.
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        name_ = value;
        onChanged();
        return this;
      }

      private int instanceIdentifier_ ;
      /**
       * <code>required int32 instance_identifier = 2;</code>
       * @return Whether the instanceIdentifier field is set.
       */
      @java.lang.Override
      public boolean hasInstanceIdentifier() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>required int32 instance_identifier = 2;</code>
       * @return The instanceIdentifier.
       */
      @java.lang.Override
      public int getInstanceIdentifier() {
        return instanceIdentifier_;
      }
      /**
       * <code>required int32 instance_identifier = 2;</code>
       * @param value The instanceIdentifier to set.
       * @return This builder for chaining.
       */
      public Builder setInstanceIdentifier(int value) {
        bitField0_ |= 0x00000002;
        instanceIdentifier_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 instance_identifier = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearInstanceIdentifier() {
        bitField0_ = (bitField0_ & ~0x00000002);
        instanceIdentifier_ = 0;
        onChanged();
        return this;
      }

      private long timeStampg_ ;
      /**
       * <code>required uint64 time_stampg = 3;</code>
       * @return Whether the timeStampg field is set.
       */
      @java.lang.Override
      public boolean hasTimeStampg() {
        return ((bitField0_ & 0x00000004) != 0);
      }
      /**
       * <code>required uint64 time_stampg = 3;</code>
       * @return The timeStampg.
       */
      @java.lang.Override
      public long getTimeStampg() {
        return timeStampg_;
      }
      /**
       * <code>required uint64 time_stampg = 3;</code>
       * @param value The timeStampg to set.
       * @return This builder for chaining.
       */
      public Builder setTimeStampg(long value) {
        bitField0_ |= 0x00000004;
        timeStampg_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint64 time_stampg = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearTimeStampg() {
        bitField0_ = (bitField0_ & ~0x00000004);
        timeStampg_ = 0L;
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


      // @@protoc_insertion_point(builder_scope:key)
    }

    // @@protoc_insertion_point(class_scope:key)
    private static final org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key();
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<key>
        PARSER = new com.google.protobuf.AbstractParser<key>() {
      @java.lang.Override
      public key parsePartialFrom(
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

    public static com.google.protobuf.Parser<key> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<key> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface lsp_monitor_data_eventOrBuilder extends
      // @@protoc_insertion_point(interface_extends:lsp_monitor_data_event)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required .lsp_event event_identifier = 1;</code>
     * @return Whether the eventIdentifier field is set.
     */
    boolean hasEventIdentifier();
    /**
     * <code>required .lsp_event event_identifier = 1;</code>
     * @return The eventIdentifier.
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event getEventIdentifier();

    /**
     * <code>optional .event_subcode subcode = 2;</code>
     * @return Whether the subcode field is set.
     */
    boolean hasSubcode();
    /**
     * <code>optional .event_subcode subcode = 2;</code>
     * @return The subcode.
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode getSubcode();
  }
  /**
   * <pre>
   * Schema for communicating lsp events
   * </pre>
   *
   * Protobuf type {@code lsp_monitor_data_event}
   */
  public static final class lsp_monitor_data_event extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:lsp_monitor_data_event)
      lsp_monitor_data_eventOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use lsp_monitor_data_event.newBuilder() to construct.
    private lsp_monitor_data_event(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private lsp_monitor_data_event() {
      eventIdentifier_ = 0;
      subcode_ = 1;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new lsp_monitor_data_event();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_monitor_data_event_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_monitor_data_event_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.Builder.class);
    }

    private int bitField0_;
    public static final int EVENT_IDENTIFIER_FIELD_NUMBER = 1;
    private int eventIdentifier_;
    /**
     * <code>required .lsp_event event_identifier = 1;</code>
     * @return Whether the eventIdentifier field is set.
     */
    @java.lang.Override public boolean hasEventIdentifier() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required .lsp_event event_identifier = 1;</code>
     * @return The eventIdentifier.
     */
    @java.lang.Override public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event getEventIdentifier() {
      @SuppressWarnings("deprecation")
      org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event result = org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event.valueOf(eventIdentifier_);
      return result == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event.INITIATED : result;
    }

    public static final int SUBCODE_FIELD_NUMBER = 2;
    private int subcode_;
    /**
     * <code>optional .event_subcode subcode = 2;</code>
     * @return Whether the subcode field is set.
     */
    @java.lang.Override public boolean hasSubcode() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional .event_subcode subcode = 2;</code>
     * @return The subcode.
     */
    @java.lang.Override public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode getSubcode() {
      @SuppressWarnings("deprecation")
      org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode result = org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode.valueOf(subcode_);
      return result == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode.ADMISSION_CONTROL_FAILURE : result;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasEventIdentifier()) {
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
        output.writeEnum(1, eventIdentifier_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        output.writeEnum(2, subcode_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, eventIdentifier_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(2, subcode_);
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
      if (!(obj instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event)) {
        return super.equals(obj);
      }
      org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event other = (org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event) obj;

      if (hasEventIdentifier() != other.hasEventIdentifier()) return false;
      if (hasEventIdentifier()) {
        if (eventIdentifier_ != other.eventIdentifier_) return false;
      }
      if (hasSubcode() != other.hasSubcode()) return false;
      if (hasSubcode()) {
        if (subcode_ != other.subcode_) return false;
      }
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
      if (hasEventIdentifier()) {
        hash = (37 * hash) + EVENT_IDENTIFIER_FIELD_NUMBER;
        hash = (53 * hash) + eventIdentifier_;
      }
      if (hasSubcode()) {
        hash = (37 * hash) + SUBCODE_FIELD_NUMBER;
        hash = (53 * hash) + subcode_;
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event parseFrom(
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
    public static Builder newBuilder(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event prototype) {
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
     * <pre>
     * Schema for communicating lsp events
     * </pre>
     *
     * Protobuf type {@code lsp_monitor_data_event}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:lsp_monitor_data_event)
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_eventOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_monitor_data_event_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_monitor_data_event_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.Builder.class);
      }

      // Construct using org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        eventIdentifier_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        subcode_ = 1;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_monitor_data_event_descriptor;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event getDefaultInstanceForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.getDefaultInstance();
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event build() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event buildPartial() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event result = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          to_bitField0_ |= 0x00000001;
        }
        result.eventIdentifier_ = eventIdentifier_;
        if (((from_bitField0_ & 0x00000002) != 0)) {
          to_bitField0_ |= 0x00000002;
        }
        result.subcode_ = subcode_;
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
        if (other instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event) {
          return mergeFrom((org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event other) {
        if (other == org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.getDefaultInstance()) return this;
        if (other.hasEventIdentifier()) {
          setEventIdentifier(other.getEventIdentifier());
        }
        if (other.hasSubcode()) {
          setSubcode(other.getSubcode());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasEventIdentifier()) {
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
              case 8: {
                int tmpRaw = input.readEnum();
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event tmpValue =
                    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event.forNumber(tmpRaw);
                if (tmpValue == null) {
                  mergeUnknownVarintField(1, tmpRaw);
                } else {
                  eventIdentifier_ = tmpRaw;
                  bitField0_ |= 0x00000001;
                }
                break;
              } // case 8
              case 16: {
                int tmpRaw = input.readEnum();
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode tmpValue =
                    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode.forNumber(tmpRaw);
                if (tmpValue == null) {
                  mergeUnknownVarintField(2, tmpRaw);
                } else {
                  subcode_ = tmpRaw;
                  bitField0_ |= 0x00000002;
                }
                break;
              } // case 16
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

      private int eventIdentifier_ = 0;
      /**
       * <code>required .lsp_event event_identifier = 1;</code>
       * @return Whether the eventIdentifier field is set.
       */
      @java.lang.Override public boolean hasEventIdentifier() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required .lsp_event event_identifier = 1;</code>
       * @return The eventIdentifier.
       */
      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event getEventIdentifier() {
        @SuppressWarnings("deprecation")
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event result = org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event.valueOf(eventIdentifier_);
        return result == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event.INITIATED : result;
      }
      /**
       * <code>required .lsp_event event_identifier = 1;</code>
       * @param value The eventIdentifier to set.
       * @return This builder for chaining.
       */
      public Builder setEventIdentifier(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_event value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        eventIdentifier_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>required .lsp_event event_identifier = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearEventIdentifier() {
        bitField0_ = (bitField0_ & ~0x00000001);
        eventIdentifier_ = 0;
        onChanged();
        return this;
      }

      private int subcode_ = 1;
      /**
       * <code>optional .event_subcode subcode = 2;</code>
       * @return Whether the subcode field is set.
       */
      @java.lang.Override public boolean hasSubcode() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>optional .event_subcode subcode = 2;</code>
       * @return The subcode.
       */
      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode getSubcode() {
        @SuppressWarnings("deprecation")
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode result = org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode.valueOf(subcode_);
        return result == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode.ADMISSION_CONTROL_FAILURE : result;
      }
      /**
       * <code>optional .event_subcode subcode = 2;</code>
       * @param value The subcode to set.
       * @return This builder for chaining.
       */
      public Builder setSubcode(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.event_subcode value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000002;
        subcode_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional .event_subcode subcode = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearSubcode() {
        bitField0_ = (bitField0_ & ~0x00000002);
        subcode_ = 1;
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


      // @@protoc_insertion_point(builder_scope:lsp_monitor_data_event)
    }

    // @@protoc_insertion_point(class_scope:lsp_monitor_data_event)
    private static final org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event();
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<lsp_monitor_data_event>
        PARSER = new com.google.protobuf.AbstractParser<lsp_monitor_data_event>() {
      @java.lang.Override
      public lsp_monitor_data_event parsePartialFrom(
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

    public static com.google.protobuf.Parser<lsp_monitor_data_event> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<lsp_monitor_data_event> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface ero_type_entryOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ero_type_entry)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required uint32 ip = 1;</code>
     * @return Whether the ip field is set.
     */
    boolean hasIp();
    /**
     * <code>required uint32 ip = 1;</code>
     * @return The ip.
     */
    int getIp();

    /**
     * <code>optional string flags = 2;</code>
     * @return Whether the flags field is set.
     */
    boolean hasFlags();
    /**
     * <code>optional string flags = 2;</code>
     * @return The flags.
     */
    java.lang.String getFlags();
    /**
     * <code>optional string flags = 2;</code>
     * @return The bytes for flags.
     */
    com.google.protobuf.ByteString
        getFlagsBytes();
  }
  /**
   * Protobuf type {@code ero_type_entry}
   */
  public static final class ero_type_entry extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ero_type_entry)
      ero_type_entryOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ero_type_entry.newBuilder() to construct.
    private ero_type_entry(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ero_type_entry() {
      flags_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ero_type_entry();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_ero_type_entry_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_ero_type_entry_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder.class);
    }

    private int bitField0_;
    public static final int IP_FIELD_NUMBER = 1;
    private int ip_;
    /**
     * <code>required uint32 ip = 1;</code>
     * @return Whether the ip field is set.
     */
    @java.lang.Override
    public boolean hasIp() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required uint32 ip = 1;</code>
     * @return The ip.
     */
    @java.lang.Override
    public int getIp() {
      return ip_;
    }

    public static final int FLAGS_FIELD_NUMBER = 2;
    private volatile java.lang.Object flags_;
    /**
     * <code>optional string flags = 2;</code>
     * @return Whether the flags field is set.
     */
    @java.lang.Override
    public boolean hasFlags() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional string flags = 2;</code>
     * @return The flags.
     */
    @java.lang.Override
    public java.lang.String getFlags() {
      java.lang.Object ref = flags_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          flags_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string flags = 2;</code>
     * @return The bytes for flags.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getFlagsBytes() {
      java.lang.Object ref = flags_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        flags_ = b;
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

      if (!hasIp()) {
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
        output.writeUInt32(1, ip_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, flags_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(1, ip_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, flags_);
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
      if (!(obj instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry)) {
        return super.equals(obj);
      }
      org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry other = (org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry) obj;

      if (hasIp() != other.hasIp()) return false;
      if (hasIp()) {
        if (getIp()
            != other.getIp()) return false;
      }
      if (hasFlags() != other.hasFlags()) return false;
      if (hasFlags()) {
        if (!getFlags()
            .equals(other.getFlags())) return false;
      }
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
      if (hasIp()) {
        hash = (37 * hash) + IP_FIELD_NUMBER;
        hash = (53 * hash) + getIp();
      }
      if (hasFlags()) {
        hash = (37 * hash) + FLAGS_FIELD_NUMBER;
        hash = (53 * hash) + getFlags().hashCode();
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry parseFrom(
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
    public static Builder newBuilder(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry prototype) {
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
     * Protobuf type {@code ero_type_entry}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ero_type_entry)
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entryOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_ero_type_entry_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_ero_type_entry_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder.class);
      }

      // Construct using org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        ip_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        flags_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_ero_type_entry_descriptor;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry getDefaultInstanceForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.getDefaultInstance();
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry build() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry buildPartial() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry result = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.ip_ = ip_;
          to_bitField0_ |= 0x00000001;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          to_bitField0_ |= 0x00000002;
        }
        result.flags_ = flags_;
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
        if (other instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry) {
          return mergeFrom((org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry other) {
        if (other == org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.getDefaultInstance()) return this;
        if (other.hasIp()) {
          setIp(other.getIp());
        }
        if (other.hasFlags()) {
          bitField0_ |= 0x00000002;
          flags_ = other.flags_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasIp()) {
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
              case 8: {
                ip_ = input.readUInt32();
                bitField0_ |= 0x00000001;
                break;
              } // case 8
              case 18: {
                flags_ = input.readBytes();
                bitField0_ |= 0x00000002;
                break;
              } // case 18
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

      private int ip_ ;
      /**
       * <code>required uint32 ip = 1;</code>
       * @return Whether the ip field is set.
       */
      @java.lang.Override
      public boolean hasIp() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required uint32 ip = 1;</code>
       * @return The ip.
       */
      @java.lang.Override
      public int getIp() {
        return ip_;
      }
      /**
       * <code>required uint32 ip = 1;</code>
       * @param value The ip to set.
       * @return This builder for chaining.
       */
      public Builder setIp(int value) {
        bitField0_ |= 0x00000001;
        ip_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint32 ip = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearIp() {
        bitField0_ = (bitField0_ & ~0x00000001);
        ip_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object flags_ = "";
      /**
       * <code>optional string flags = 2;</code>
       * @return Whether the flags field is set.
       */
      public boolean hasFlags() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>optional string flags = 2;</code>
       * @return The flags.
       */
      public java.lang.String getFlags() {
        java.lang.Object ref = flags_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            flags_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string flags = 2;</code>
       * @return The bytes for flags.
       */
      public com.google.protobuf.ByteString
          getFlagsBytes() {
        java.lang.Object ref = flags_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          flags_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string flags = 2;</code>
       * @param value The flags to set.
       * @return This builder for chaining.
       */
      public Builder setFlags(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        flags_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string flags = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearFlags() {
        bitField0_ = (bitField0_ & ~0x00000002);
        flags_ = getDefaultInstance().getFlags();
        onChanged();
        return this;
      }
      /**
       * <code>optional string flags = 2;</code>
       * @param value The bytes for flags to set.
       * @return This builder for chaining.
       */
      public Builder setFlagsBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        flags_ = value;
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


      // @@protoc_insertion_point(builder_scope:ero_type_entry)
    }

    // @@protoc_insertion_point(class_scope:ero_type_entry)
    private static final org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry();
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<ero_type_entry>
        PARSER = new com.google.protobuf.AbstractParser<ero_type_entry>() {
      @java.lang.Override
      public ero_type_entry parsePartialFrom(
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

    public static com.google.protobuf.Parser<ero_type_entry> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ero_type_entry> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface ero_ipv4_typeOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ero_ipv4_type)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .ero_type_entry entry = 1;</code>
     */
    java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry> 
        getEntryList();
    /**
     * <code>repeated .ero_type_entry entry = 1;</code>
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry getEntry(int index);
    /**
     * <code>repeated .ero_type_entry entry = 1;</code>
     */
    int getEntryCount();
    /**
     * <code>repeated .ero_type_entry entry = 1;</code>
     */
    java.util.List<? extends org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entryOrBuilder> 
        getEntryOrBuilderList();
    /**
     * <code>repeated .ero_type_entry entry = 1;</code>
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entryOrBuilder getEntryOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code ero_ipv4_type}
   */
  public static final class ero_ipv4_type extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ero_ipv4_type)
      ero_ipv4_typeOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ero_ipv4_type.newBuilder() to construct.
    private ero_ipv4_type(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ero_ipv4_type() {
      entry_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ero_ipv4_type();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_ero_ipv4_type_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_ero_ipv4_type_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.Builder.class);
    }

    public static final int ENTRY_FIELD_NUMBER = 1;
    private java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry> entry_;
    /**
     * <code>repeated .ero_type_entry entry = 1;</code>
     */
    @java.lang.Override
    public java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry> getEntryList() {
      return entry_;
    }
    /**
     * <code>repeated .ero_type_entry entry = 1;</code>
     */
    @java.lang.Override
    public java.util.List<? extends org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entryOrBuilder> 
        getEntryOrBuilderList() {
      return entry_;
    }
    /**
     * <code>repeated .ero_type_entry entry = 1;</code>
     */
    @java.lang.Override
    public int getEntryCount() {
      return entry_.size();
    }
    /**
     * <code>repeated .ero_type_entry entry = 1;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry getEntry(int index) {
      return entry_.get(index);
    }
    /**
     * <code>repeated .ero_type_entry entry = 1;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entryOrBuilder getEntryOrBuilder(
        int index) {
      return entry_.get(index);
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      for (int i = 0; i < getEntryCount(); i++) {
        if (!getEntry(i).isInitialized()) {
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
      for (int i = 0; i < entry_.size(); i++) {
        output.writeMessage(1, entry_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < entry_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, entry_.get(i));
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
      if (!(obj instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type)) {
        return super.equals(obj);
      }
      org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type other = (org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type) obj;

      if (!getEntryList()
          .equals(other.getEntryList())) return false;
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
      if (getEntryCount() > 0) {
        hash = (37 * hash) + ENTRY_FIELD_NUMBER;
        hash = (53 * hash) + getEntryList().hashCode();
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type parseFrom(
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
    public static Builder newBuilder(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type prototype) {
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
     * Protobuf type {@code ero_ipv4_type}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ero_ipv4_type)
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_typeOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_ero_ipv4_type_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_ero_ipv4_type_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.Builder.class);
      }

      // Construct using org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (entryBuilder_ == null) {
          entry_ = java.util.Collections.emptyList();
        } else {
          entry_ = null;
          entryBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_ero_ipv4_type_descriptor;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type getDefaultInstanceForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.getDefaultInstance();
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type build() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type buildPartial() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type result = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type(this);
        int from_bitField0_ = bitField0_;
        if (entryBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            entry_ = java.util.Collections.unmodifiableList(entry_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.entry_ = entry_;
        } else {
          result.entry_ = entryBuilder_.build();
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
        if (other instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type) {
          return mergeFrom((org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type other) {
        if (other == org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.getDefaultInstance()) return this;
        if (entryBuilder_ == null) {
          if (!other.entry_.isEmpty()) {
            if (entry_.isEmpty()) {
              entry_ = other.entry_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureEntryIsMutable();
              entry_.addAll(other.entry_);
            }
            onChanged();
          }
        } else {
          if (!other.entry_.isEmpty()) {
            if (entryBuilder_.isEmpty()) {
              entryBuilder_.dispose();
              entryBuilder_ = null;
              entry_ = other.entry_;
              bitField0_ = (bitField0_ & ~0x00000001);
              entryBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getEntryFieldBuilder() : null;
            } else {
              entryBuilder_.addAllMessages(other.entry_);
            }
          }
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        for (int i = 0; i < getEntryCount(); i++) {
          if (!getEntry(i).isInitialized()) {
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
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry m =
                    input.readMessage(
                        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.PARSER,
                        extensionRegistry);
                if (entryBuilder_ == null) {
                  ensureEntryIsMutable();
                  entry_.add(m);
                } else {
                  entryBuilder_.addMessage(m);
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

      private java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry> entry_ =
        java.util.Collections.emptyList();
      private void ensureEntryIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          entry_ = new java.util.ArrayList<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry>(entry_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entryOrBuilder> entryBuilder_;

      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry> getEntryList() {
        if (entryBuilder_ == null) {
          return java.util.Collections.unmodifiableList(entry_);
        } else {
          return entryBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public int getEntryCount() {
        if (entryBuilder_ == null) {
          return entry_.size();
        } else {
          return entryBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry getEntry(int index) {
        if (entryBuilder_ == null) {
          return entry_.get(index);
        } else {
          return entryBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public Builder setEntry(
          int index, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry value) {
        if (entryBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureEntryIsMutable();
          entry_.set(index, value);
          onChanged();
        } else {
          entryBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public Builder setEntry(
          int index, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder builderForValue) {
        if (entryBuilder_ == null) {
          ensureEntryIsMutable();
          entry_.set(index, builderForValue.build());
          onChanged();
        } else {
          entryBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public Builder addEntry(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry value) {
        if (entryBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureEntryIsMutable();
          entry_.add(value);
          onChanged();
        } else {
          entryBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public Builder addEntry(
          int index, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry value) {
        if (entryBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureEntryIsMutable();
          entry_.add(index, value);
          onChanged();
        } else {
          entryBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public Builder addEntry(
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder builderForValue) {
        if (entryBuilder_ == null) {
          ensureEntryIsMutable();
          entry_.add(builderForValue.build());
          onChanged();
        } else {
          entryBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public Builder addEntry(
          int index, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder builderForValue) {
        if (entryBuilder_ == null) {
          ensureEntryIsMutable();
          entry_.add(index, builderForValue.build());
          onChanged();
        } else {
          entryBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public Builder addAllEntry(
          java.lang.Iterable<? extends org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry> values) {
        if (entryBuilder_ == null) {
          ensureEntryIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, entry_);
          onChanged();
        } else {
          entryBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public Builder clearEntry() {
        if (entryBuilder_ == null) {
          entry_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          entryBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public Builder removeEntry(int index) {
        if (entryBuilder_ == null) {
          ensureEntryIsMutable();
          entry_.remove(index);
          onChanged();
        } else {
          entryBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder getEntryBuilder(
          int index) {
        return getEntryFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entryOrBuilder getEntryOrBuilder(
          int index) {
        if (entryBuilder_ == null) {
          return entry_.get(index);  } else {
          return entryBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public java.util.List<? extends org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entryOrBuilder> 
           getEntryOrBuilderList() {
        if (entryBuilder_ != null) {
          return entryBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(entry_);
        }
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder addEntryBuilder() {
        return getEntryFieldBuilder().addBuilder(
            org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.getDefaultInstance());
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder addEntryBuilder(
          int index) {
        return getEntryFieldBuilder().addBuilder(
            index, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.getDefaultInstance());
      }
      /**
       * <code>repeated .ero_type_entry entry = 1;</code>
       */
      public java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder> 
           getEntryBuilderList() {
        return getEntryFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entryOrBuilder> 
          getEntryFieldBuilder() {
        if (entryBuilder_ == null) {
          entryBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entry.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_type_entryOrBuilder>(
                  entry_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          entry_ = null;
        }
        return entryBuilder_;
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


      // @@protoc_insertion_point(builder_scope:ero_ipv4_type)
    }

    // @@protoc_insertion_point(class_scope:ero_ipv4_type)
    private static final org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type();
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<ero_ipv4_type>
        PARSER = new com.google.protobuf.AbstractParser<ero_ipv4_type>() {
      @java.lang.Override
      public ero_ipv4_type parsePartialFrom(
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

    public static com.google.protobuf.Parser<ero_ipv4_type> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ero_ipv4_type> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface rro_type_entryOrBuilder extends
      // @@protoc_insertion_point(interface_extends:rro_type_entry)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * node-id or loopback
     * </pre>
     *
     * <code>optional uint32 nodeid = 1;</code>
     * @return Whether the nodeid field is set.
     */
    boolean hasNodeid();
    /**
     * <pre>
     * node-id or loopback
     * </pre>
     *
     * <code>optional uint32 nodeid = 1;</code>
     * @return The nodeid.
     */
    int getNodeid();

    /**
     * <pre>
     * contains flags
     * </pre>
     *
     * <code>optional uint32 flags = 2;</code>
     * @return Whether the flags field is set.
     */
    boolean hasFlags();
    /**
     * <pre>
     * contains flags
     * </pre>
     *
     * <code>optional uint32 flags = 2;</code>
     * @return The flags.
     */
    int getFlags();

    /**
     * <pre>
     * interface-ip
     * </pre>
     *
     * <code>optional uint32 intf_addr = 3;</code>
     * @return Whether the intfAddr field is set.
     */
    boolean hasIntfAddr();
    /**
     * <pre>
     * interface-ip
     * </pre>
     *
     * <code>optional uint32 intf_addr = 3;</code>
     * @return The intfAddr.
     */
    int getIntfAddr();

    /**
     * <pre>
     * may be using PHP
     * </pre>
     *
     * <code>optional uint32 label = 4;</code>
     * @return Whether the label field is set.
     */
    boolean hasLabel();
    /**
     * <pre>
     * may be using PHP
     * </pre>
     *
     * <code>optional uint32 label = 4;</code>
     * @return The label.
     */
    int getLabel();
  }
  /**
   * Protobuf type {@code rro_type_entry}
   */
  public static final class rro_type_entry extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:rro_type_entry)
      rro_type_entryOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use rro_type_entry.newBuilder() to construct.
    private rro_type_entry(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private rro_type_entry() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new rro_type_entry();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_rro_type_entry_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_rro_type_entry_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder.class);
    }

    private int bitField0_;
    public static final int NODEID_FIELD_NUMBER = 1;
    private int nodeid_;
    /**
     * <pre>
     * node-id or loopback
     * </pre>
     *
     * <code>optional uint32 nodeid = 1;</code>
     * @return Whether the nodeid field is set.
     */
    @java.lang.Override
    public boolean hasNodeid() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * node-id or loopback
     * </pre>
     *
     * <code>optional uint32 nodeid = 1;</code>
     * @return The nodeid.
     */
    @java.lang.Override
    public int getNodeid() {
      return nodeid_;
    }

    public static final int FLAGS_FIELD_NUMBER = 2;
    private int flags_;
    /**
     * <pre>
     * contains flags
     * </pre>
     *
     * <code>optional uint32 flags = 2;</code>
     * @return Whether the flags field is set.
     */
    @java.lang.Override
    public boolean hasFlags() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * contains flags
     * </pre>
     *
     * <code>optional uint32 flags = 2;</code>
     * @return The flags.
     */
    @java.lang.Override
    public int getFlags() {
      return flags_;
    }

    public static final int INTF_ADDR_FIELD_NUMBER = 3;
    private int intfAddr_;
    /**
     * <pre>
     * interface-ip
     * </pre>
     *
     * <code>optional uint32 intf_addr = 3;</code>
     * @return Whether the intfAddr field is set.
     */
    @java.lang.Override
    public boolean hasIntfAddr() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <pre>
     * interface-ip
     * </pre>
     *
     * <code>optional uint32 intf_addr = 3;</code>
     * @return The intfAddr.
     */
    @java.lang.Override
    public int getIntfAddr() {
      return intfAddr_;
    }

    public static final int LABEL_FIELD_NUMBER = 4;
    private int label_;
    /**
     * <pre>
     * may be using PHP
     * </pre>
     *
     * <code>optional uint32 label = 4;</code>
     * @return Whether the label field is set.
     */
    @java.lang.Override
    public boolean hasLabel() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <pre>
     * may be using PHP
     * </pre>
     *
     * <code>optional uint32 label = 4;</code>
     * @return The label.
     */
    @java.lang.Override
    public int getLabel() {
      return label_;
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
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeUInt32(1, nodeid_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        output.writeUInt32(2, flags_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        output.writeUInt32(3, intfAddr_);
      }
      if (((bitField0_ & 0x00000008) != 0)) {
        output.writeUInt32(4, label_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(1, nodeid_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(2, flags_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(3, intfAddr_);
      }
      if (((bitField0_ & 0x00000008) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(4, label_);
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
      if (!(obj instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry)) {
        return super.equals(obj);
      }
      org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry other = (org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry) obj;

      if (hasNodeid() != other.hasNodeid()) return false;
      if (hasNodeid()) {
        if (getNodeid()
            != other.getNodeid()) return false;
      }
      if (hasFlags() != other.hasFlags()) return false;
      if (hasFlags()) {
        if (getFlags()
            != other.getFlags()) return false;
      }
      if (hasIntfAddr() != other.hasIntfAddr()) return false;
      if (hasIntfAddr()) {
        if (getIntfAddr()
            != other.getIntfAddr()) return false;
      }
      if (hasLabel() != other.hasLabel()) return false;
      if (hasLabel()) {
        if (getLabel()
            != other.getLabel()) return false;
      }
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
      if (hasNodeid()) {
        hash = (37 * hash) + NODEID_FIELD_NUMBER;
        hash = (53 * hash) + getNodeid();
      }
      if (hasFlags()) {
        hash = (37 * hash) + FLAGS_FIELD_NUMBER;
        hash = (53 * hash) + getFlags();
      }
      if (hasIntfAddr()) {
        hash = (37 * hash) + INTF_ADDR_FIELD_NUMBER;
        hash = (53 * hash) + getIntfAddr();
      }
      if (hasLabel()) {
        hash = (37 * hash) + LABEL_FIELD_NUMBER;
        hash = (53 * hash) + getLabel();
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry parseFrom(
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
    public static Builder newBuilder(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry prototype) {
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
     * Protobuf type {@code rro_type_entry}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:rro_type_entry)
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entryOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_rro_type_entry_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_rro_type_entry_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder.class);
      }

      // Construct using org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        nodeid_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        flags_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        intfAddr_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        label_ = 0;
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_rro_type_entry_descriptor;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry getDefaultInstanceForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.getDefaultInstance();
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry build() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry buildPartial() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry result = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.nodeid_ = nodeid_;
          to_bitField0_ |= 0x00000001;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.flags_ = flags_;
          to_bitField0_ |= 0x00000002;
        }
        if (((from_bitField0_ & 0x00000004) != 0)) {
          result.intfAddr_ = intfAddr_;
          to_bitField0_ |= 0x00000004;
        }
        if (((from_bitField0_ & 0x00000008) != 0)) {
          result.label_ = label_;
          to_bitField0_ |= 0x00000008;
        }
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
        if (other instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry) {
          return mergeFrom((org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry other) {
        if (other == org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.getDefaultInstance()) return this;
        if (other.hasNodeid()) {
          setNodeid(other.getNodeid());
        }
        if (other.hasFlags()) {
          setFlags(other.getFlags());
        }
        if (other.hasIntfAddr()) {
          setIntfAddr(other.getIntfAddr());
        }
        if (other.hasLabel()) {
          setLabel(other.getLabel());
        }
        this.mergeUnknownFields(other.getUnknownFields());
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
              case 8: {
                nodeid_ = input.readUInt32();
                bitField0_ |= 0x00000001;
                break;
              } // case 8
              case 16: {
                flags_ = input.readUInt32();
                bitField0_ |= 0x00000002;
                break;
              } // case 16
              case 24: {
                intfAddr_ = input.readUInt32();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
              case 32: {
                label_ = input.readUInt32();
                bitField0_ |= 0x00000008;
                break;
              } // case 32
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

      private int nodeid_ ;
      /**
       * <pre>
       * node-id or loopback
       * </pre>
       *
       * <code>optional uint32 nodeid = 1;</code>
       * @return Whether the nodeid field is set.
       */
      @java.lang.Override
      public boolean hasNodeid() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <pre>
       * node-id or loopback
       * </pre>
       *
       * <code>optional uint32 nodeid = 1;</code>
       * @return The nodeid.
       */
      @java.lang.Override
      public int getNodeid() {
        return nodeid_;
      }
      /**
       * <pre>
       * node-id or loopback
       * </pre>
       *
       * <code>optional uint32 nodeid = 1;</code>
       * @param value The nodeid to set.
       * @return This builder for chaining.
       */
      public Builder setNodeid(int value) {
        bitField0_ |= 0x00000001;
        nodeid_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * node-id or loopback
       * </pre>
       *
       * <code>optional uint32 nodeid = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearNodeid() {
        bitField0_ = (bitField0_ & ~0x00000001);
        nodeid_ = 0;
        onChanged();
        return this;
      }

      private int flags_ ;
      /**
       * <pre>
       * contains flags
       * </pre>
       *
       * <code>optional uint32 flags = 2;</code>
       * @return Whether the flags field is set.
       */
      @java.lang.Override
      public boolean hasFlags() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <pre>
       * contains flags
       * </pre>
       *
       * <code>optional uint32 flags = 2;</code>
       * @return The flags.
       */
      @java.lang.Override
      public int getFlags() {
        return flags_;
      }
      /**
       * <pre>
       * contains flags
       * </pre>
       *
       * <code>optional uint32 flags = 2;</code>
       * @param value The flags to set.
       * @return This builder for chaining.
       */
      public Builder setFlags(int value) {
        bitField0_ |= 0x00000002;
        flags_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * contains flags
       * </pre>
       *
       * <code>optional uint32 flags = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearFlags() {
        bitField0_ = (bitField0_ & ~0x00000002);
        flags_ = 0;
        onChanged();
        return this;
      }

      private int intfAddr_ ;
      /**
       * <pre>
       * interface-ip
       * </pre>
       *
       * <code>optional uint32 intf_addr = 3;</code>
       * @return Whether the intfAddr field is set.
       */
      @java.lang.Override
      public boolean hasIntfAddr() {
        return ((bitField0_ & 0x00000004) != 0);
      }
      /**
       * <pre>
       * interface-ip
       * </pre>
       *
       * <code>optional uint32 intf_addr = 3;</code>
       * @return The intfAddr.
       */
      @java.lang.Override
      public int getIntfAddr() {
        return intfAddr_;
      }
      /**
       * <pre>
       * interface-ip
       * </pre>
       *
       * <code>optional uint32 intf_addr = 3;</code>
       * @param value The intfAddr to set.
       * @return This builder for chaining.
       */
      public Builder setIntfAddr(int value) {
        bitField0_ |= 0x00000004;
        intfAddr_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * interface-ip
       * </pre>
       *
       * <code>optional uint32 intf_addr = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearIntfAddr() {
        bitField0_ = (bitField0_ & ~0x00000004);
        intfAddr_ = 0;
        onChanged();
        return this;
      }

      private int label_ ;
      /**
       * <pre>
       * may be using PHP
       * </pre>
       *
       * <code>optional uint32 label = 4;</code>
       * @return Whether the label field is set.
       */
      @java.lang.Override
      public boolean hasLabel() {
        return ((bitField0_ & 0x00000008) != 0);
      }
      /**
       * <pre>
       * may be using PHP
       * </pre>
       *
       * <code>optional uint32 label = 4;</code>
       * @return The label.
       */
      @java.lang.Override
      public int getLabel() {
        return label_;
      }
      /**
       * <pre>
       * may be using PHP
       * </pre>
       *
       * <code>optional uint32 label = 4;</code>
       * @param value The label to set.
       * @return This builder for chaining.
       */
      public Builder setLabel(int value) {
        bitField0_ |= 0x00000008;
        label_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * may be using PHP
       * </pre>
       *
       * <code>optional uint32 label = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearLabel() {
        bitField0_ = (bitField0_ & ~0x00000008);
        label_ = 0;
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


      // @@protoc_insertion_point(builder_scope:rro_type_entry)
    }

    // @@protoc_insertion_point(class_scope:rro_type_entry)
    private static final org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry();
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<rro_type_entry>
        PARSER = new com.google.protobuf.AbstractParser<rro_type_entry>() {
      @java.lang.Override
      public rro_type_entry parsePartialFrom(
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

    public static com.google.protobuf.Parser<rro_type_entry> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<rro_type_entry> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface rro_ipv4_typeOrBuilder extends
      // @@protoc_insertion_point(interface_extends:rro_ipv4_type)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .rro_type_entry rro_entry = 1;</code>
     */
    java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry> 
        getRroEntryList();
    /**
     * <code>repeated .rro_type_entry rro_entry = 1;</code>
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry getRroEntry(int index);
    /**
     * <code>repeated .rro_type_entry rro_entry = 1;</code>
     */
    int getRroEntryCount();
    /**
     * <code>repeated .rro_type_entry rro_entry = 1;</code>
     */
    java.util.List<? extends org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entryOrBuilder> 
        getRroEntryOrBuilderList();
    /**
     * <code>repeated .rro_type_entry rro_entry = 1;</code>
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entryOrBuilder getRroEntryOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code rro_ipv4_type}
   */
  public static final class rro_ipv4_type extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:rro_ipv4_type)
      rro_ipv4_typeOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use rro_ipv4_type.newBuilder() to construct.
    private rro_ipv4_type(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private rro_ipv4_type() {
      rroEntry_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new rro_ipv4_type();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_rro_ipv4_type_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_rro_ipv4_type_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.Builder.class);
    }

    public static final int RRO_ENTRY_FIELD_NUMBER = 1;
    private java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry> rroEntry_;
    /**
     * <code>repeated .rro_type_entry rro_entry = 1;</code>
     */
    @java.lang.Override
    public java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry> getRroEntryList() {
      return rroEntry_;
    }
    /**
     * <code>repeated .rro_type_entry rro_entry = 1;</code>
     */
    @java.lang.Override
    public java.util.List<? extends org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entryOrBuilder> 
        getRroEntryOrBuilderList() {
      return rroEntry_;
    }
    /**
     * <code>repeated .rro_type_entry rro_entry = 1;</code>
     */
    @java.lang.Override
    public int getRroEntryCount() {
      return rroEntry_.size();
    }
    /**
     * <code>repeated .rro_type_entry rro_entry = 1;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry getRroEntry(int index) {
      return rroEntry_.get(index);
    }
    /**
     * <code>repeated .rro_type_entry rro_entry = 1;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entryOrBuilder getRroEntryOrBuilder(
        int index) {
      return rroEntry_.get(index);
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
      for (int i = 0; i < rroEntry_.size(); i++) {
        output.writeMessage(1, rroEntry_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < rroEntry_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, rroEntry_.get(i));
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
      if (!(obj instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type)) {
        return super.equals(obj);
      }
      org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type other = (org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type) obj;

      if (!getRroEntryList()
          .equals(other.getRroEntryList())) return false;
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
      if (getRroEntryCount() > 0) {
        hash = (37 * hash) + RRO_ENTRY_FIELD_NUMBER;
        hash = (53 * hash) + getRroEntryList().hashCode();
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type parseFrom(
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
    public static Builder newBuilder(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type prototype) {
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
     * Protobuf type {@code rro_ipv4_type}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:rro_ipv4_type)
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_typeOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_rro_ipv4_type_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_rro_ipv4_type_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.Builder.class);
      }

      // Construct using org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (rroEntryBuilder_ == null) {
          rroEntry_ = java.util.Collections.emptyList();
        } else {
          rroEntry_ = null;
          rroEntryBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_rro_ipv4_type_descriptor;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type getDefaultInstanceForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.getDefaultInstance();
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type build() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type buildPartial() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type result = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type(this);
        int from_bitField0_ = bitField0_;
        if (rroEntryBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            rroEntry_ = java.util.Collections.unmodifiableList(rroEntry_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.rroEntry_ = rroEntry_;
        } else {
          result.rroEntry_ = rroEntryBuilder_.build();
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
        if (other instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type) {
          return mergeFrom((org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type other) {
        if (other == org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.getDefaultInstance()) return this;
        if (rroEntryBuilder_ == null) {
          if (!other.rroEntry_.isEmpty()) {
            if (rroEntry_.isEmpty()) {
              rroEntry_ = other.rroEntry_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureRroEntryIsMutable();
              rroEntry_.addAll(other.rroEntry_);
            }
            onChanged();
          }
        } else {
          if (!other.rroEntry_.isEmpty()) {
            if (rroEntryBuilder_.isEmpty()) {
              rroEntryBuilder_.dispose();
              rroEntryBuilder_ = null;
              rroEntry_ = other.rroEntry_;
              bitField0_ = (bitField0_ & ~0x00000001);
              rroEntryBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getRroEntryFieldBuilder() : null;
            } else {
              rroEntryBuilder_.addAllMessages(other.rroEntry_);
            }
          }
        }
        this.mergeUnknownFields(other.getUnknownFields());
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
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry m =
                    input.readMessage(
                        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.PARSER,
                        extensionRegistry);
                if (rroEntryBuilder_ == null) {
                  ensureRroEntryIsMutable();
                  rroEntry_.add(m);
                } else {
                  rroEntryBuilder_.addMessage(m);
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

      private java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry> rroEntry_ =
        java.util.Collections.emptyList();
      private void ensureRroEntryIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          rroEntry_ = new java.util.ArrayList<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry>(rroEntry_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entryOrBuilder> rroEntryBuilder_;

      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry> getRroEntryList() {
        if (rroEntryBuilder_ == null) {
          return java.util.Collections.unmodifiableList(rroEntry_);
        } else {
          return rroEntryBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public int getRroEntryCount() {
        if (rroEntryBuilder_ == null) {
          return rroEntry_.size();
        } else {
          return rroEntryBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry getRroEntry(int index) {
        if (rroEntryBuilder_ == null) {
          return rroEntry_.get(index);
        } else {
          return rroEntryBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public Builder setRroEntry(
          int index, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry value) {
        if (rroEntryBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRroEntryIsMutable();
          rroEntry_.set(index, value);
          onChanged();
        } else {
          rroEntryBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public Builder setRroEntry(
          int index, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder builderForValue) {
        if (rroEntryBuilder_ == null) {
          ensureRroEntryIsMutable();
          rroEntry_.set(index, builderForValue.build());
          onChanged();
        } else {
          rroEntryBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public Builder addRroEntry(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry value) {
        if (rroEntryBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRroEntryIsMutable();
          rroEntry_.add(value);
          onChanged();
        } else {
          rroEntryBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public Builder addRroEntry(
          int index, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry value) {
        if (rroEntryBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRroEntryIsMutable();
          rroEntry_.add(index, value);
          onChanged();
        } else {
          rroEntryBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public Builder addRroEntry(
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder builderForValue) {
        if (rroEntryBuilder_ == null) {
          ensureRroEntryIsMutable();
          rroEntry_.add(builderForValue.build());
          onChanged();
        } else {
          rroEntryBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public Builder addRroEntry(
          int index, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder builderForValue) {
        if (rroEntryBuilder_ == null) {
          ensureRroEntryIsMutable();
          rroEntry_.add(index, builderForValue.build());
          onChanged();
        } else {
          rroEntryBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public Builder addAllRroEntry(
          java.lang.Iterable<? extends org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry> values) {
        if (rroEntryBuilder_ == null) {
          ensureRroEntryIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, rroEntry_);
          onChanged();
        } else {
          rroEntryBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public Builder clearRroEntry() {
        if (rroEntryBuilder_ == null) {
          rroEntry_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          rroEntryBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public Builder removeRroEntry(int index) {
        if (rroEntryBuilder_ == null) {
          ensureRroEntryIsMutable();
          rroEntry_.remove(index);
          onChanged();
        } else {
          rroEntryBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder getRroEntryBuilder(
          int index) {
        return getRroEntryFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entryOrBuilder getRroEntryOrBuilder(
          int index) {
        if (rroEntryBuilder_ == null) {
          return rroEntry_.get(index);  } else {
          return rroEntryBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public java.util.List<? extends org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entryOrBuilder> 
           getRroEntryOrBuilderList() {
        if (rroEntryBuilder_ != null) {
          return rroEntryBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(rroEntry_);
        }
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder addRroEntryBuilder() {
        return getRroEntryFieldBuilder().addBuilder(
            org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.getDefaultInstance());
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder addRroEntryBuilder(
          int index) {
        return getRroEntryFieldBuilder().addBuilder(
            index, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.getDefaultInstance());
      }
      /**
       * <code>repeated .rro_type_entry rro_entry = 1;</code>
       */
      public java.util.List<org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder> 
           getRroEntryBuilderList() {
        return getRroEntryFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entryOrBuilder> 
          getRroEntryFieldBuilder() {
        if (rroEntryBuilder_ == null) {
          rroEntryBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entry.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_type_entryOrBuilder>(
                  rroEntry_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          rroEntry_ = null;
        }
        return rroEntryBuilder_;
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


      // @@protoc_insertion_point(builder_scope:rro_ipv4_type)
    }

    // @@protoc_insertion_point(class_scope:rro_ipv4_type)
    private static final org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type();
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<rro_ipv4_type>
        PARSER = new com.google.protobuf.AbstractParser<rro_ipv4_type>() {
      @java.lang.Override
      public rro_ipv4_type parsePartialFrom(
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

    public static com.google.protobuf.Parser<rro_ipv4_type> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<rro_ipv4_type> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface lsp_monitor_data_propertyOrBuilder extends
      // @@protoc_insertion_point(interface_extends:lsp_monitor_data_property)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional uint64 bandwidth = 1;</code>
     * @return Whether the bandwidth field is set.
     */
    boolean hasBandwidth();
    /**
     * <code>optional uint64 bandwidth = 1;</code>
     * @return The bandwidth.
     */
    long getBandwidth();

    /**
     * <code>optional string path_name = 2;</code>
     * @return Whether the pathName field is set.
     */
    boolean hasPathName();
    /**
     * <code>optional string path_name = 2;</code>
     * @return The pathName.
     */
    java.lang.String getPathName();
    /**
     * <code>optional string path_name = 2;</code>
     * @return The bytes for pathName.
     */
    com.google.protobuf.ByteString
        getPathNameBytes();

    /**
     * <code>optional int32 metric = 3;</code>
     * @return Whether the metric field is set.
     */
    boolean hasMetric();
    /**
     * <code>optional int32 metric = 3;</code>
     * @return The metric.
     */
    int getMetric();

    /**
     * <code>optional float max_avg_bw = 4;</code>
     * @return Whether the maxAvgBw field is set.
     */
    boolean hasMaxAvgBw();
    /**
     * <code>optional float max_avg_bw = 4;</code>
     * @return The maxAvgBw.
     */
    float getMaxAvgBw();

    /**
     * <code>optional .ero_ipv4_type ero = 5;</code>
     * @return Whether the ero field is set.
     */
    boolean hasEro();
    /**
     * <code>optional .ero_ipv4_type ero = 5;</code>
     * @return The ero.
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type getEro();
    /**
     * <code>optional .ero_ipv4_type ero = 5;</code>
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_typeOrBuilder getEroOrBuilder();

    /**
     * <code>optional .rro_ipv4_type rro = 6;</code>
     * @return Whether the rro field is set.
     */
    boolean hasRro();
    /**
     * <code>optional .rro_ipv4_type rro = 6;</code>
     * @return The rro.
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type getRro();
    /**
     * <code>optional .rro_ipv4_type rro = 6;</code>
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_typeOrBuilder getRroOrBuilder();
  }
  /**
   * <pre>
   * Schema for communicating properties of LSPs
   * </pre>
   *
   * Protobuf type {@code lsp_monitor_data_property}
   */
  public static final class lsp_monitor_data_property extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:lsp_monitor_data_property)
      lsp_monitor_data_propertyOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use lsp_monitor_data_property.newBuilder() to construct.
    private lsp_monitor_data_property(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private lsp_monitor_data_property() {
      pathName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new lsp_monitor_data_property();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_monitor_data_property_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_monitor_data_property_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.Builder.class);
    }

    private int bitField0_;
    public static final int BANDWIDTH_FIELD_NUMBER = 1;
    private long bandwidth_;
    /**
     * <code>optional uint64 bandwidth = 1;</code>
     * @return Whether the bandwidth field is set.
     */
    @java.lang.Override
    public boolean hasBandwidth() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional uint64 bandwidth = 1;</code>
     * @return The bandwidth.
     */
    @java.lang.Override
    public long getBandwidth() {
      return bandwidth_;
    }

    public static final int PATH_NAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object pathName_;
    /**
     * <code>optional string path_name = 2;</code>
     * @return Whether the pathName field is set.
     */
    @java.lang.Override
    public boolean hasPathName() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional string path_name = 2;</code>
     * @return The pathName.
     */
    @java.lang.Override
    public java.lang.String getPathName() {
      java.lang.Object ref = pathName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          pathName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string path_name = 2;</code>
     * @return The bytes for pathName.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getPathNameBytes() {
      java.lang.Object ref = pathName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pathName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int METRIC_FIELD_NUMBER = 3;
    private int metric_;
    /**
     * <code>optional int32 metric = 3;</code>
     * @return Whether the metric field is set.
     */
    @java.lang.Override
    public boolean hasMetric() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional int32 metric = 3;</code>
     * @return The metric.
     */
    @java.lang.Override
    public int getMetric() {
      return metric_;
    }

    public static final int MAX_AVG_BW_FIELD_NUMBER = 4;
    private float maxAvgBw_;
    /**
     * <code>optional float max_avg_bw = 4;</code>
     * @return Whether the maxAvgBw field is set.
     */
    @java.lang.Override
    public boolean hasMaxAvgBw() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>optional float max_avg_bw = 4;</code>
     * @return The maxAvgBw.
     */
    @java.lang.Override
    public float getMaxAvgBw() {
      return maxAvgBw_;
    }

    public static final int ERO_FIELD_NUMBER = 5;
    private org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type ero_;
    /**
     * <code>optional .ero_ipv4_type ero = 5;</code>
     * @return Whether the ero field is set.
     */
    @java.lang.Override
    public boolean hasEro() {
      return ((bitField0_ & 0x00000010) != 0);
    }
    /**
     * <code>optional .ero_ipv4_type ero = 5;</code>
     * @return The ero.
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type getEro() {
      return ero_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.getDefaultInstance() : ero_;
    }
    /**
     * <code>optional .ero_ipv4_type ero = 5;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_typeOrBuilder getEroOrBuilder() {
      return ero_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.getDefaultInstance() : ero_;
    }

    public static final int RRO_FIELD_NUMBER = 6;
    private org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type rro_;
    /**
     * <code>optional .rro_ipv4_type rro = 6;</code>
     * @return Whether the rro field is set.
     */
    @java.lang.Override
    public boolean hasRro() {
      return ((bitField0_ & 0x00000020) != 0);
    }
    /**
     * <code>optional .rro_ipv4_type rro = 6;</code>
     * @return The rro.
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type getRro() {
      return rro_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.getDefaultInstance() : rro_;
    }
    /**
     * <code>optional .rro_ipv4_type rro = 6;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_typeOrBuilder getRroOrBuilder() {
      return rro_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.getDefaultInstance() : rro_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (hasEro()) {
        if (!getEro().isInitialized()) {
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
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeUInt64(1, bandwidth_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, pathName_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        output.writeInt32(3, metric_);
      }
      if (((bitField0_ & 0x00000008) != 0)) {
        output.writeFloat(4, maxAvgBw_);
      }
      if (((bitField0_ & 0x00000010) != 0)) {
        output.writeMessage(5, getEro());
      }
      if (((bitField0_ & 0x00000020) != 0)) {
        output.writeMessage(6, getRro());
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, bandwidth_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, pathName_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, metric_);
      }
      if (((bitField0_ & 0x00000008) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(4, maxAvgBw_);
      }
      if (((bitField0_ & 0x00000010) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(5, getEro());
      }
      if (((bitField0_ & 0x00000020) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(6, getRro());
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
      if (!(obj instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property)) {
        return super.equals(obj);
      }
      org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property other = (org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property) obj;

      if (hasBandwidth() != other.hasBandwidth()) return false;
      if (hasBandwidth()) {
        if (getBandwidth()
            != other.getBandwidth()) return false;
      }
      if (hasPathName() != other.hasPathName()) return false;
      if (hasPathName()) {
        if (!getPathName()
            .equals(other.getPathName())) return false;
      }
      if (hasMetric() != other.hasMetric()) return false;
      if (hasMetric()) {
        if (getMetric()
            != other.getMetric()) return false;
      }
      if (hasMaxAvgBw() != other.hasMaxAvgBw()) return false;
      if (hasMaxAvgBw()) {
        if (java.lang.Float.floatToIntBits(getMaxAvgBw())
            != java.lang.Float.floatToIntBits(
                other.getMaxAvgBw())) return false;
      }
      if (hasEro() != other.hasEro()) return false;
      if (hasEro()) {
        if (!getEro()
            .equals(other.getEro())) return false;
      }
      if (hasRro() != other.hasRro()) return false;
      if (hasRro()) {
        if (!getRro()
            .equals(other.getRro())) return false;
      }
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
      if (hasBandwidth()) {
        hash = (37 * hash) + BANDWIDTH_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getBandwidth());
      }
      if (hasPathName()) {
        hash = (37 * hash) + PATH_NAME_FIELD_NUMBER;
        hash = (53 * hash) + getPathName().hashCode();
      }
      if (hasMetric()) {
        hash = (37 * hash) + METRIC_FIELD_NUMBER;
        hash = (53 * hash) + getMetric();
      }
      if (hasMaxAvgBw()) {
        hash = (37 * hash) + MAX_AVG_BW_FIELD_NUMBER;
        hash = (53 * hash) + java.lang.Float.floatToIntBits(
            getMaxAvgBw());
      }
      if (hasEro()) {
        hash = (37 * hash) + ERO_FIELD_NUMBER;
        hash = (53 * hash) + getEro().hashCode();
      }
      if (hasRro()) {
        hash = (37 * hash) + RRO_FIELD_NUMBER;
        hash = (53 * hash) + getRro().hashCode();
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property parseFrom(
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
    public static Builder newBuilder(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property prototype) {
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
     * <pre>
     * Schema for communicating properties of LSPs
     * </pre>
     *
     * Protobuf type {@code lsp_monitor_data_property}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:lsp_monitor_data_property)
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_propertyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_monitor_data_property_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_monitor_data_property_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.Builder.class);
      }

      // Construct using org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.newBuilder()
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
          getEroFieldBuilder();
          getRroFieldBuilder();
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        bandwidth_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        pathName_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        metric_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        maxAvgBw_ = 0F;
        bitField0_ = (bitField0_ & ~0x00000008);
        if (eroBuilder_ == null) {
          ero_ = null;
        } else {
          eroBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000010);
        if (rroBuilder_ == null) {
          rro_ = null;
        } else {
          rroBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000020);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_monitor_data_property_descriptor;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property getDefaultInstanceForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.getDefaultInstance();
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property build() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property buildPartial() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property result = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.bandwidth_ = bandwidth_;
          to_bitField0_ |= 0x00000001;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          to_bitField0_ |= 0x00000002;
        }
        result.pathName_ = pathName_;
        if (((from_bitField0_ & 0x00000004) != 0)) {
          result.metric_ = metric_;
          to_bitField0_ |= 0x00000004;
        }
        if (((from_bitField0_ & 0x00000008) != 0)) {
          result.maxAvgBw_ = maxAvgBw_;
          to_bitField0_ |= 0x00000008;
        }
        if (((from_bitField0_ & 0x00000010) != 0)) {
          if (eroBuilder_ == null) {
            result.ero_ = ero_;
          } else {
            result.ero_ = eroBuilder_.build();
          }
          to_bitField0_ |= 0x00000010;
        }
        if (((from_bitField0_ & 0x00000020) != 0)) {
          if (rroBuilder_ == null) {
            result.rro_ = rro_;
          } else {
            result.rro_ = rroBuilder_.build();
          }
          to_bitField0_ |= 0x00000020;
        }
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
        if (other instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property) {
          return mergeFrom((org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property other) {
        if (other == org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.getDefaultInstance()) return this;
        if (other.hasBandwidth()) {
          setBandwidth(other.getBandwidth());
        }
        if (other.hasPathName()) {
          bitField0_ |= 0x00000002;
          pathName_ = other.pathName_;
          onChanged();
        }
        if (other.hasMetric()) {
          setMetric(other.getMetric());
        }
        if (other.hasMaxAvgBw()) {
          setMaxAvgBw(other.getMaxAvgBw());
        }
        if (other.hasEro()) {
          mergeEro(other.getEro());
        }
        if (other.hasRro()) {
          mergeRro(other.getRro());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (hasEro()) {
          if (!getEro().isInitialized()) {
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
              case 8: {
                bandwidth_ = input.readUInt64();
                bitField0_ |= 0x00000001;
                break;
              } // case 8
              case 18: {
                pathName_ = input.readBytes();
                bitField0_ |= 0x00000002;
                break;
              } // case 18
              case 24: {
                metric_ = input.readInt32();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
              case 37: {
                maxAvgBw_ = input.readFloat();
                bitField0_ |= 0x00000008;
                break;
              } // case 37
              case 42: {
                input.readMessage(
                    getEroFieldBuilder().getBuilder(),
                    extensionRegistry);
                bitField0_ |= 0x00000010;
                break;
              } // case 42
              case 50: {
                input.readMessage(
                    getRroFieldBuilder().getBuilder(),
                    extensionRegistry);
                bitField0_ |= 0x00000020;
                break;
              } // case 50
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

      private long bandwidth_ ;
      /**
       * <code>optional uint64 bandwidth = 1;</code>
       * @return Whether the bandwidth field is set.
       */
      @java.lang.Override
      public boolean hasBandwidth() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>optional uint64 bandwidth = 1;</code>
       * @return The bandwidth.
       */
      @java.lang.Override
      public long getBandwidth() {
        return bandwidth_;
      }
      /**
       * <code>optional uint64 bandwidth = 1;</code>
       * @param value The bandwidth to set.
       * @return This builder for chaining.
       */
      public Builder setBandwidth(long value) {
        bitField0_ |= 0x00000001;
        bandwidth_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint64 bandwidth = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearBandwidth() {
        bitField0_ = (bitField0_ & ~0x00000001);
        bandwidth_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object pathName_ = "";
      /**
       * <code>optional string path_name = 2;</code>
       * @return Whether the pathName field is set.
       */
      public boolean hasPathName() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>optional string path_name = 2;</code>
       * @return The pathName.
       */
      public java.lang.String getPathName() {
        java.lang.Object ref = pathName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            pathName_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string path_name = 2;</code>
       * @return The bytes for pathName.
       */
      public com.google.protobuf.ByteString
          getPathNameBytes() {
        java.lang.Object ref = pathName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          pathName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string path_name = 2;</code>
       * @param value The pathName to set.
       * @return This builder for chaining.
       */
      public Builder setPathName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        pathName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string path_name = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearPathName() {
        bitField0_ = (bitField0_ & ~0x00000002);
        pathName_ = getDefaultInstance().getPathName();
        onChanged();
        return this;
      }
      /**
       * <code>optional string path_name = 2;</code>
       * @param value The bytes for pathName to set.
       * @return This builder for chaining.
       */
      public Builder setPathNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        pathName_ = value;
        onChanged();
        return this;
      }

      private int metric_ ;
      /**
       * <code>optional int32 metric = 3;</code>
       * @return Whether the metric field is set.
       */
      @java.lang.Override
      public boolean hasMetric() {
        return ((bitField0_ & 0x00000004) != 0);
      }
      /**
       * <code>optional int32 metric = 3;</code>
       * @return The metric.
       */
      @java.lang.Override
      public int getMetric() {
        return metric_;
      }
      /**
       * <code>optional int32 metric = 3;</code>
       * @param value The metric to set.
       * @return This builder for chaining.
       */
      public Builder setMetric(int value) {
        bitField0_ |= 0x00000004;
        metric_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 metric = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearMetric() {
        bitField0_ = (bitField0_ & ~0x00000004);
        metric_ = 0;
        onChanged();
        return this;
      }

      private float maxAvgBw_ ;
      /**
       * <code>optional float max_avg_bw = 4;</code>
       * @return Whether the maxAvgBw field is set.
       */
      @java.lang.Override
      public boolean hasMaxAvgBw() {
        return ((bitField0_ & 0x00000008) != 0);
      }
      /**
       * <code>optional float max_avg_bw = 4;</code>
       * @return The maxAvgBw.
       */
      @java.lang.Override
      public float getMaxAvgBw() {
        return maxAvgBw_;
      }
      /**
       * <code>optional float max_avg_bw = 4;</code>
       * @param value The maxAvgBw to set.
       * @return This builder for chaining.
       */
      public Builder setMaxAvgBw(float value) {
        bitField0_ |= 0x00000008;
        maxAvgBw_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional float max_avg_bw = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearMaxAvgBw() {
        bitField0_ = (bitField0_ & ~0x00000008);
        maxAvgBw_ = 0F;
        onChanged();
        return this;
      }

      private org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type ero_;
      private com.google.protobuf.SingleFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_typeOrBuilder> eroBuilder_;
      /**
       * <code>optional .ero_ipv4_type ero = 5;</code>
       * @return Whether the ero field is set.
       */
      public boolean hasEro() {
        return ((bitField0_ & 0x00000010) != 0);
      }
      /**
       * <code>optional .ero_ipv4_type ero = 5;</code>
       * @return The ero.
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type getEro() {
        if (eroBuilder_ == null) {
          return ero_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.getDefaultInstance() : ero_;
        } else {
          return eroBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .ero_ipv4_type ero = 5;</code>
       */
      public Builder setEro(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type value) {
        if (eroBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ero_ = value;
          onChanged();
        } else {
          eroBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000010;
        return this;
      }
      /**
       * <code>optional .ero_ipv4_type ero = 5;</code>
       */
      public Builder setEro(
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.Builder builderForValue) {
        if (eroBuilder_ == null) {
          ero_ = builderForValue.build();
          onChanged();
        } else {
          eroBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000010;
        return this;
      }
      /**
       * <code>optional .ero_ipv4_type ero = 5;</code>
       */
      public Builder mergeEro(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type value) {
        if (eroBuilder_ == null) {
          if (((bitField0_ & 0x00000010) != 0) &&
              ero_ != null &&
              ero_ != org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.getDefaultInstance()) {
            ero_ =
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.newBuilder(ero_).mergeFrom(value).buildPartial();
          } else {
            ero_ = value;
          }
          onChanged();
        } else {
          eroBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000010;
        return this;
      }
      /**
       * <code>optional .ero_ipv4_type ero = 5;</code>
       */
      public Builder clearEro() {
        if (eroBuilder_ == null) {
          ero_ = null;
          onChanged();
        } else {
          eroBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }
      /**
       * <code>optional .ero_ipv4_type ero = 5;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.Builder getEroBuilder() {
        bitField0_ |= 0x00000010;
        onChanged();
        return getEroFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .ero_ipv4_type ero = 5;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_typeOrBuilder getEroOrBuilder() {
        if (eroBuilder_ != null) {
          return eroBuilder_.getMessageOrBuilder();
        } else {
          return ero_ == null ?
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.getDefaultInstance() : ero_;
        }
      }
      /**
       * <code>optional .ero_ipv4_type ero = 5;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_typeOrBuilder> 
          getEroFieldBuilder() {
        if (eroBuilder_ == null) {
          eroBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_type.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.ero_ipv4_typeOrBuilder>(
                  getEro(),
                  getParentForChildren(),
                  isClean());
          ero_ = null;
        }
        return eroBuilder_;
      }

      private org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type rro_;
      private com.google.protobuf.SingleFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_typeOrBuilder> rroBuilder_;
      /**
       * <code>optional .rro_ipv4_type rro = 6;</code>
       * @return Whether the rro field is set.
       */
      public boolean hasRro() {
        return ((bitField0_ & 0x00000020) != 0);
      }
      /**
       * <code>optional .rro_ipv4_type rro = 6;</code>
       * @return The rro.
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type getRro() {
        if (rroBuilder_ == null) {
          return rro_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.getDefaultInstance() : rro_;
        } else {
          return rroBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .rro_ipv4_type rro = 6;</code>
       */
      public Builder setRro(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type value) {
        if (rroBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          rro_ = value;
          onChanged();
        } else {
          rroBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000020;
        return this;
      }
      /**
       * <code>optional .rro_ipv4_type rro = 6;</code>
       */
      public Builder setRro(
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.Builder builderForValue) {
        if (rroBuilder_ == null) {
          rro_ = builderForValue.build();
          onChanged();
        } else {
          rroBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000020;
        return this;
      }
      /**
       * <code>optional .rro_ipv4_type rro = 6;</code>
       */
      public Builder mergeRro(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type value) {
        if (rroBuilder_ == null) {
          if (((bitField0_ & 0x00000020) != 0) &&
              rro_ != null &&
              rro_ != org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.getDefaultInstance()) {
            rro_ =
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.newBuilder(rro_).mergeFrom(value).buildPartial();
          } else {
            rro_ = value;
          }
          onChanged();
        } else {
          rroBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000020;
        return this;
      }
      /**
       * <code>optional .rro_ipv4_type rro = 6;</code>
       */
      public Builder clearRro() {
        if (rroBuilder_ == null) {
          rro_ = null;
          onChanged();
        } else {
          rroBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000020);
        return this;
      }
      /**
       * <code>optional .rro_ipv4_type rro = 6;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.Builder getRroBuilder() {
        bitField0_ |= 0x00000020;
        onChanged();
        return getRroFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .rro_ipv4_type rro = 6;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_typeOrBuilder getRroOrBuilder() {
        if (rroBuilder_ != null) {
          return rroBuilder_.getMessageOrBuilder();
        } else {
          return rro_ == null ?
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.getDefaultInstance() : rro_;
        }
      }
      /**
       * <code>optional .rro_ipv4_type rro = 6;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_typeOrBuilder> 
          getRroFieldBuilder() {
        if (rroBuilder_ == null) {
          rroBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_type.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.rro_ipv4_typeOrBuilder>(
                  getRro(),
                  getParentForChildren(),
                  isClean());
          rro_ = null;
        }
        return rroBuilder_;
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


      // @@protoc_insertion_point(builder_scope:lsp_monitor_data_property)
    }

    // @@protoc_insertion_point(class_scope:lsp_monitor_data_property)
    private static final org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property();
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<lsp_monitor_data_property>
        PARSER = new com.google.protobuf.AbstractParser<lsp_monitor_data_property>() {
      @java.lang.Override
      public lsp_monitor_data_property parsePartialFrom(
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

    public static com.google.protobuf.Parser<lsp_monitor_data_property> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<lsp_monitor_data_property> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface lsp_monOrBuilder extends
      // @@protoc_insertion_point(interface_extends:lsp_mon)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required .key key_field = 1;</code>
     * @return Whether the keyField field is set.
     */
    boolean hasKeyField();
    /**
     * <code>required .key key_field = 1;</code>
     * @return The keyField.
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key getKeyField();
    /**
     * <code>required .key key_field = 1;</code>
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.keyOrBuilder getKeyFieldOrBuilder();

    /**
     * <code>optional .lsp_monitor_data_event event_field = 2;</code>
     * @return Whether the eventField field is set.
     */
    boolean hasEventField();
    /**
     * <code>optional .lsp_monitor_data_event event_field = 2;</code>
     * @return The eventField.
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event getEventField();
    /**
     * <code>optional .lsp_monitor_data_event event_field = 2;</code>
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_eventOrBuilder getEventFieldOrBuilder();

    /**
     * <code>optional .lsp_monitor_data_property property_field = 3;</code>
     * @return Whether the propertyField field is set.
     */
    boolean hasPropertyField();
    /**
     * <code>optional .lsp_monitor_data_property property_field = 3;</code>
     * @return The propertyField.
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property getPropertyField();
    /**
     * <code>optional .lsp_monitor_data_property property_field = 3;</code>
     */
    org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_propertyOrBuilder getPropertyFieldOrBuilder();
  }
  /**
   * Protobuf type {@code lsp_mon}
   */
  public static final class lsp_mon extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:lsp_mon)
      lsp_monOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use lsp_mon.newBuilder() to construct.
    private lsp_mon(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private lsp_mon() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new lsp_mon();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_mon_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_mon_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon.Builder.class);
    }

    private int bitField0_;
    public static final int KEY_FIELD_FIELD_NUMBER = 1;
    private org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key keyField_;
    /**
     * <code>required .key key_field = 1;</code>
     * @return Whether the keyField field is set.
     */
    @java.lang.Override
    public boolean hasKeyField() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required .key key_field = 1;</code>
     * @return The keyField.
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key getKeyField() {
      return keyField_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.getDefaultInstance() : keyField_;
    }
    /**
     * <code>required .key key_field = 1;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.keyOrBuilder getKeyFieldOrBuilder() {
      return keyField_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.getDefaultInstance() : keyField_;
    }

    public static final int EVENT_FIELD_FIELD_NUMBER = 2;
    private org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event eventField_;
    /**
     * <code>optional .lsp_monitor_data_event event_field = 2;</code>
     * @return Whether the eventField field is set.
     */
    @java.lang.Override
    public boolean hasEventField() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional .lsp_monitor_data_event event_field = 2;</code>
     * @return The eventField.
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event getEventField() {
      return eventField_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.getDefaultInstance() : eventField_;
    }
    /**
     * <code>optional .lsp_monitor_data_event event_field = 2;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_eventOrBuilder getEventFieldOrBuilder() {
      return eventField_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.getDefaultInstance() : eventField_;
    }

    public static final int PROPERTY_FIELD_FIELD_NUMBER = 3;
    private org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property propertyField_;
    /**
     * <code>optional .lsp_monitor_data_property property_field = 3;</code>
     * @return Whether the propertyField field is set.
     */
    @java.lang.Override
    public boolean hasPropertyField() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional .lsp_monitor_data_property property_field = 3;</code>
     * @return The propertyField.
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property getPropertyField() {
      return propertyField_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.getDefaultInstance() : propertyField_;
    }
    /**
     * <code>optional .lsp_monitor_data_property property_field = 3;</code>
     */
    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_propertyOrBuilder getPropertyFieldOrBuilder() {
      return propertyField_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.getDefaultInstance() : propertyField_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasKeyField()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!getKeyField().isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (hasEventField()) {
        if (!getEventField().isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if (hasPropertyField()) {
        if (!getPropertyField().isInitialized()) {
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
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeMessage(1, getKeyField());
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        output.writeMessage(2, getEventField());
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        output.writeMessage(3, getPropertyField());
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getKeyField());
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getEventField());
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, getPropertyField());
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
      if (!(obj instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon)) {
        return super.equals(obj);
      }
      org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon other = (org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon) obj;

      if (hasKeyField() != other.hasKeyField()) return false;
      if (hasKeyField()) {
        if (!getKeyField()
            .equals(other.getKeyField())) return false;
      }
      if (hasEventField() != other.hasEventField()) return false;
      if (hasEventField()) {
        if (!getEventField()
            .equals(other.getEventField())) return false;
      }
      if (hasPropertyField() != other.hasPropertyField()) return false;
      if (hasPropertyField()) {
        if (!getPropertyField()
            .equals(other.getPropertyField())) return false;
      }
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
      if (hasKeyField()) {
        hash = (37 * hash) + KEY_FIELD_FIELD_NUMBER;
        hash = (53 * hash) + getKeyField().hashCode();
      }
      if (hasEventField()) {
        hash = (37 * hash) + EVENT_FIELD_FIELD_NUMBER;
        hash = (53 * hash) + getEventField().hashCode();
      }
      if (hasPropertyField()) {
        hash = (37 * hash) + PROPERTY_FIELD_FIELD_NUMBER;
        hash = (53 * hash) + getPropertyField().hashCode();
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon parseFrom(
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
    public static Builder newBuilder(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon prototype) {
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
     * Protobuf type {@code lsp_mon}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:lsp_mon)
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_mon_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_mon_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon.class, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon.Builder.class);
      }

      // Construct using org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon.newBuilder()
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
          getKeyFieldFieldBuilder();
          getEventFieldFieldBuilder();
          getPropertyFieldFieldBuilder();
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (keyFieldBuilder_ == null) {
          keyField_ = null;
        } else {
          keyFieldBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000001);
        if (eventFieldBuilder_ == null) {
          eventField_ = null;
        } else {
          eventFieldBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000002);
        if (propertyFieldBuilder_ == null) {
          propertyField_ = null;
        } else {
          propertyFieldBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.internal_static_lsp_mon_descriptor;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon getDefaultInstanceForType() {
        return org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon.getDefaultInstance();
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon build() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon buildPartial() {
        org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon result = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          if (keyFieldBuilder_ == null) {
            result.keyField_ = keyField_;
          } else {
            result.keyField_ = keyFieldBuilder_.build();
          }
          to_bitField0_ |= 0x00000001;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          if (eventFieldBuilder_ == null) {
            result.eventField_ = eventField_;
          } else {
            result.eventField_ = eventFieldBuilder_.build();
          }
          to_bitField0_ |= 0x00000002;
        }
        if (((from_bitField0_ & 0x00000004) != 0)) {
          if (propertyFieldBuilder_ == null) {
            result.propertyField_ = propertyField_;
          } else {
            result.propertyField_ = propertyFieldBuilder_.build();
          }
          to_bitField0_ |= 0x00000004;
        }
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
        if (other instanceof org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon) {
          return mergeFrom((org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon other) {
        if (other == org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon.getDefaultInstance()) return this;
        if (other.hasKeyField()) {
          mergeKeyField(other.getKeyField());
        }
        if (other.hasEventField()) {
          mergeEventField(other.getEventField());
        }
        if (other.hasPropertyField()) {
          mergePropertyField(other.getPropertyField());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasKeyField()) {
          return false;
        }
        if (!getKeyField().isInitialized()) {
          return false;
        }
        if (hasEventField()) {
          if (!getEventField().isInitialized()) {
            return false;
          }
        }
        if (hasPropertyField()) {
          if (!getPropertyField().isInitialized()) {
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
                input.readMessage(
                    getKeyFieldFieldBuilder().getBuilder(),
                    extensionRegistry);
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              case 18: {
                input.readMessage(
                    getEventFieldFieldBuilder().getBuilder(),
                    extensionRegistry);
                bitField0_ |= 0x00000002;
                break;
              } // case 18
              case 26: {
                input.readMessage(
                    getPropertyFieldFieldBuilder().getBuilder(),
                    extensionRegistry);
                bitField0_ |= 0x00000004;
                break;
              } // case 26
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

      private org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key keyField_;
      private com.google.protobuf.SingleFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.keyOrBuilder> keyFieldBuilder_;
      /**
       * <code>required .key key_field = 1;</code>
       * @return Whether the keyField field is set.
       */
      public boolean hasKeyField() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required .key key_field = 1;</code>
       * @return The keyField.
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key getKeyField() {
        if (keyFieldBuilder_ == null) {
          return keyField_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.getDefaultInstance() : keyField_;
        } else {
          return keyFieldBuilder_.getMessage();
        }
      }
      /**
       * <code>required .key key_field = 1;</code>
       */
      public Builder setKeyField(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key value) {
        if (keyFieldBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          keyField_ = value;
          onChanged();
        } else {
          keyFieldBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000001;
        return this;
      }
      /**
       * <code>required .key key_field = 1;</code>
       */
      public Builder setKeyField(
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.Builder builderForValue) {
        if (keyFieldBuilder_ == null) {
          keyField_ = builderForValue.build();
          onChanged();
        } else {
          keyFieldBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000001;
        return this;
      }
      /**
       * <code>required .key key_field = 1;</code>
       */
      public Builder mergeKeyField(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key value) {
        if (keyFieldBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0) &&
              keyField_ != null &&
              keyField_ != org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.getDefaultInstance()) {
            keyField_ =
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.newBuilder(keyField_).mergeFrom(value).buildPartial();
          } else {
            keyField_ = value;
          }
          onChanged();
        } else {
          keyFieldBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000001;
        return this;
      }
      /**
       * <code>required .key key_field = 1;</code>
       */
      public Builder clearKeyField() {
        if (keyFieldBuilder_ == null) {
          keyField_ = null;
          onChanged();
        } else {
          keyFieldBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }
      /**
       * <code>required .key key_field = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.Builder getKeyFieldBuilder() {
        bitField0_ |= 0x00000001;
        onChanged();
        return getKeyFieldFieldBuilder().getBuilder();
      }
      /**
       * <code>required .key key_field = 1;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.keyOrBuilder getKeyFieldOrBuilder() {
        if (keyFieldBuilder_ != null) {
          return keyFieldBuilder_.getMessageOrBuilder();
        } else {
          return keyField_ == null ?
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.getDefaultInstance() : keyField_;
        }
      }
      /**
       * <code>required .key key_field = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.keyOrBuilder> 
          getKeyFieldFieldBuilder() {
        if (keyFieldBuilder_ == null) {
          keyFieldBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.key.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.keyOrBuilder>(
                  getKeyField(),
                  getParentForChildren(),
                  isClean());
          keyField_ = null;
        }
        return keyFieldBuilder_;
      }

      private org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event eventField_;
      private com.google.protobuf.SingleFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_eventOrBuilder> eventFieldBuilder_;
      /**
       * <code>optional .lsp_monitor_data_event event_field = 2;</code>
       * @return Whether the eventField field is set.
       */
      public boolean hasEventField() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>optional .lsp_monitor_data_event event_field = 2;</code>
       * @return The eventField.
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event getEventField() {
        if (eventFieldBuilder_ == null) {
          return eventField_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.getDefaultInstance() : eventField_;
        } else {
          return eventFieldBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .lsp_monitor_data_event event_field = 2;</code>
       */
      public Builder setEventField(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event value) {
        if (eventFieldBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          eventField_ = value;
          onChanged();
        } else {
          eventFieldBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>optional .lsp_monitor_data_event event_field = 2;</code>
       */
      public Builder setEventField(
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.Builder builderForValue) {
        if (eventFieldBuilder_ == null) {
          eventField_ = builderForValue.build();
          onChanged();
        } else {
          eventFieldBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>optional .lsp_monitor_data_event event_field = 2;</code>
       */
      public Builder mergeEventField(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event value) {
        if (eventFieldBuilder_ == null) {
          if (((bitField0_ & 0x00000002) != 0) &&
              eventField_ != null &&
              eventField_ != org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.getDefaultInstance()) {
            eventField_ =
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.newBuilder(eventField_).mergeFrom(value).buildPartial();
          } else {
            eventField_ = value;
          }
          onChanged();
        } else {
          eventFieldBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>optional .lsp_monitor_data_event event_field = 2;</code>
       */
      public Builder clearEventField() {
        if (eventFieldBuilder_ == null) {
          eventField_ = null;
          onChanged();
        } else {
          eventFieldBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }
      /**
       * <code>optional .lsp_monitor_data_event event_field = 2;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.Builder getEventFieldBuilder() {
        bitField0_ |= 0x00000002;
        onChanged();
        return getEventFieldFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .lsp_monitor_data_event event_field = 2;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_eventOrBuilder getEventFieldOrBuilder() {
        if (eventFieldBuilder_ != null) {
          return eventFieldBuilder_.getMessageOrBuilder();
        } else {
          return eventField_ == null ?
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.getDefaultInstance() : eventField_;
        }
      }
      /**
       * <code>optional .lsp_monitor_data_event event_field = 2;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_eventOrBuilder> 
          getEventFieldFieldBuilder() {
        if (eventFieldBuilder_ == null) {
          eventFieldBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_event.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_eventOrBuilder>(
                  getEventField(),
                  getParentForChildren(),
                  isClean());
          eventField_ = null;
        }
        return eventFieldBuilder_;
      }

      private org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property propertyField_;
      private com.google.protobuf.SingleFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_propertyOrBuilder> propertyFieldBuilder_;
      /**
       * <code>optional .lsp_monitor_data_property property_field = 3;</code>
       * @return Whether the propertyField field is set.
       */
      public boolean hasPropertyField() {
        return ((bitField0_ & 0x00000004) != 0);
      }
      /**
       * <code>optional .lsp_monitor_data_property property_field = 3;</code>
       * @return The propertyField.
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property getPropertyField() {
        if (propertyFieldBuilder_ == null) {
          return propertyField_ == null ? org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.getDefaultInstance() : propertyField_;
        } else {
          return propertyFieldBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .lsp_monitor_data_property property_field = 3;</code>
       */
      public Builder setPropertyField(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property value) {
        if (propertyFieldBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          propertyField_ = value;
          onChanged();
        } else {
          propertyFieldBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000004;
        return this;
      }
      /**
       * <code>optional .lsp_monitor_data_property property_field = 3;</code>
       */
      public Builder setPropertyField(
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.Builder builderForValue) {
        if (propertyFieldBuilder_ == null) {
          propertyField_ = builderForValue.build();
          onChanged();
        } else {
          propertyFieldBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000004;
        return this;
      }
      /**
       * <code>optional .lsp_monitor_data_property property_field = 3;</code>
       */
      public Builder mergePropertyField(org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property value) {
        if (propertyFieldBuilder_ == null) {
          if (((bitField0_ & 0x00000004) != 0) &&
              propertyField_ != null &&
              propertyField_ != org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.getDefaultInstance()) {
            propertyField_ =
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.newBuilder(propertyField_).mergeFrom(value).buildPartial();
          } else {
            propertyField_ = value;
          }
          onChanged();
        } else {
          propertyFieldBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000004;
        return this;
      }
      /**
       * <code>optional .lsp_monitor_data_property property_field = 3;</code>
       */
      public Builder clearPropertyField() {
        if (propertyFieldBuilder_ == null) {
          propertyField_ = null;
          onChanged();
        } else {
          propertyFieldBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }
      /**
       * <code>optional .lsp_monitor_data_property property_field = 3;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.Builder getPropertyFieldBuilder() {
        bitField0_ |= 0x00000004;
        onChanged();
        return getPropertyFieldFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .lsp_monitor_data_property property_field = 3;</code>
       */
      public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_propertyOrBuilder getPropertyFieldOrBuilder() {
        if (propertyFieldBuilder_ != null) {
          return propertyFieldBuilder_.getMessageOrBuilder();
        } else {
          return propertyField_ == null ?
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.getDefaultInstance() : propertyField_;
        }
      }
      /**
       * <code>optional .lsp_monitor_data_property property_field = 3;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_propertyOrBuilder> 
          getPropertyFieldFieldBuilder() {
        if (propertyFieldBuilder_ == null) {
          propertyFieldBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_property.Builder, org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_monitor_data_propertyOrBuilder>(
                  getPropertyField(),
                  getParentForChildren(),
                  isClean());
          propertyField_ = null;
        }
        return propertyFieldBuilder_;
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


      // @@protoc_insertion_point(builder_scope:lsp_mon)
    }

    // @@protoc_insertion_point(class_scope:lsp_mon)
    private static final org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon();
    }

    public static org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<lsp_mon>
        PARSER = new com.google.protobuf.AbstractParser<lsp_mon>() {
      @java.lang.Override
      public lsp_mon parsePartialFrom(
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

    public static com.google.protobuf.Parser<lsp_mon> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<lsp_mon> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.opennms.netmgt.telemetry.protocols.jti.adapter.proto.LspMon.lsp_mon getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_key_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_key_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lsp_monitor_data_event_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lsp_monitor_data_event_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ero_type_entry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ero_type_entry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ero_ipv4_type_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ero_ipv4_type_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rro_type_entry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rro_type_entry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rro_ipv4_type_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rro_ipv4_type_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lsp_monitor_data_property_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lsp_monitor_data_property_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lsp_mon_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lsp_mon_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rlsp_mon.proto\"E\n\003key\022\014\n\004name\030\001 \002(\t\022\033\n\023" +
      "instance_identifier\030\002 \002(\005\022\023\n\013time_stampg" +
      "\030\003 \002(\004\"_\n\026lsp_monitor_data_event\022$\n\020even" +
      "t_identifier\030\001 \002(\0162\n.lsp_event\022\037\n\007subcod" +
      "e\030\002 \001(\0162\016.event_subcode\"+\n\016ero_type_entr" +
      "y\022\n\n\002ip\030\001 \002(\r\022\r\n\005flags\030\002 \001(\t\"/\n\rero_ipv4" +
      "_type\022\036\n\005entry\030\001 \003(\0132\017.ero_type_entry\"Q\n" +
      "\016rro_type_entry\022\016\n\006nodeid\030\001 \001(\r\022\r\n\005flags" +
      "\030\002 \001(\r\022\021\n\tintf_addr\030\003 \001(\r\022\r\n\005label\030\004 \001(\r" +
      "\"3\n\rrro_ipv4_type\022\"\n\trro_entry\030\001 \003(\0132\017.r" +
      "ro_type_entry\"\237\001\n\031lsp_monitor_data_prope" +
      "rty\022\021\n\tbandwidth\030\001 \001(\004\022\021\n\tpath_name\030\002 \001(" +
      "\t\022\016\n\006metric\030\003 \001(\005\022\022\n\nmax_avg_bw\030\004 \001(\002\022\033\n" +
      "\003ero\030\005 \001(\0132\016.ero_ipv4_type\022\033\n\003rro\030\006 \001(\0132" +
      "\016.rro_ipv4_type\"\204\001\n\007lsp_mon\022\027\n\tkey_field" +
      "\030\001 \002(\0132\004.key\022,\n\013event_field\030\002 \001(\0132\027.lsp_" +
      "monitor_data_event\0222\n\016property_field\030\003 \001" +
      "(\0132\032.lsp_monitor_data_property*\273\003\n\tlsp_e" +
      "vent\022\r\n\tINITIATED\020\000\022\020\n\014CONCLUDED_UP\020\001\022\027\n" +
      "\023CONCLUDED_TORN_DOWN\020\002\022\030\n\024PROTECTION_AVA" +
      "ILABLE\020\003\022\032\n\026PROTECTION_UNAVAILABLE\020\004\022\022\n\016" +
      "AUTOBW_SUCCESS\020\005\022\017\n\013AUTOBW_FAIL\020\006\022\026\n\022RES" +
      "V_TEAR_RECEIVED\020\007\022\030\n\024DESELECT_ACTIVE_PAT" +
      "H\020\010\022\026\n\022CHANGE_ACTIVE_PATH\020\t\022\r\n\tDETOUR_UP" +
      "\020\n\022\017\n\013DETOUR_DOWN\020\013\022\021\n\rORIGINATE_MBB\020\014\022\026" +
      "\n\022SELECT_ACTIVE_PATH\020\r\022\021\n\rCSPF_NO_ROUTE\020" +
      "\016\022\020\n\014CSPF_SUCCESS\020\017\022\031\n\025RESTART_RECOVERY_" +
      "FAIL\020\020\022\024\n\020PATHERR_RECEIVED\020\021\022\023\n\017PATH_MTU" +
      "_CHANGE\020\022\022\031\n\025TUNNEL_LOCAL_REPAIRED\020\023*\374\001\n" +
      "\revent_subcode\022\035\n\031ADMISSION_CONTROL_FAIL" +
      "URE\020\001\022\025\n\021SESSION_PREEMPTED\020\002\022\023\n\017BAD_LOOS" +
      "E_ROUTE\020\003\022\024\n\020BAD_STRICT_ROUTE\020\004\022\034\n\030LABEL" +
      "_ALLOCATION_FAILURE\020\005\022\033\n\027NON_RSVP_CAPABL" +
      "E_ROUTER\020\006\022\017\n\013TTL_EXPIRED\020\007\022\031\n\025ROUTING_L" +
      "OOP_DETECTED\020\010\022#\n\037REQUESTED_BANDWIDTH_UN" +
      "AVAILABLE\020\tB<\n8org.opennms.netmgt.teleme" +
      "try.protocols.jti.adapter.protoH\003"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_key_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_key_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_key_descriptor,
        new java.lang.String[] { "Name", "InstanceIdentifier", "TimeStampg", });
    internal_static_lsp_monitor_data_event_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_lsp_monitor_data_event_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lsp_monitor_data_event_descriptor,
        new java.lang.String[] { "EventIdentifier", "Subcode", });
    internal_static_ero_type_entry_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ero_type_entry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ero_type_entry_descriptor,
        new java.lang.String[] { "Ip", "Flags", });
    internal_static_ero_ipv4_type_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ero_ipv4_type_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ero_ipv4_type_descriptor,
        new java.lang.String[] { "Entry", });
    internal_static_rro_type_entry_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_rro_type_entry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rro_type_entry_descriptor,
        new java.lang.String[] { "Nodeid", "Flags", "IntfAddr", "Label", });
    internal_static_rro_ipv4_type_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_rro_ipv4_type_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rro_ipv4_type_descriptor,
        new java.lang.String[] { "RroEntry", });
    internal_static_lsp_monitor_data_property_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_lsp_monitor_data_property_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lsp_monitor_data_property_descriptor,
        new java.lang.String[] { "Bandwidth", "PathName", "Metric", "MaxAvgBw", "Ero", "Rro", });
    internal_static_lsp_mon_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_lsp_mon_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lsp_mon_descriptor,
        new java.lang.String[] { "KeyField", "EventField", "PropertyField", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
