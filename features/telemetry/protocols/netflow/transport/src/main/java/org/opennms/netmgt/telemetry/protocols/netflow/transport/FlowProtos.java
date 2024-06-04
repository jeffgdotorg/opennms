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

package org.opennms.netmgt.telemetry.protocols.netflow.transport;

public final class FlowProtos {
  private FlowProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FlowMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FlowMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rnetflow.proto\032\036google/protobuf/wrapper" +
      "s.proto\"\327\013\n\013FlowMessage\022\021\n\ttimestamp\030\001 \001" +
      "(\004\022/\n\tnum_bytes\030\002 \001(\0132\034.google.protobuf." +
      "UInt64Value\022\035\n\tdirection\030\003 \001(\0162\n.Directi" +
      "on\022\023\n\013dst_address\030\004 \001(\t\022\024\n\014dst_hostname\030" +
      "\005 \001(\t\022,\n\006dst_as\030\006 \001(\0132\034.google.protobuf." +
      "UInt64Value\0222\n\014dst_mask_len\030\007 \001(\0132\034.goog" +
      "le.protobuf.UInt32Value\022.\n\010dst_port\030\010 \001(" +
      "\0132\034.google.protobuf.UInt32Value\022/\n\tengin" +
      "e_id\030\t \001(\0132\034.google.protobuf.UInt32Value" +
      "\0221\n\013engine_type\030\n \001(\0132\034.google.protobuf." +
      "UInt32Value\0224\n\016delta_switched\030\013 \001(\0132\034.go" +
      "ogle.protobuf.UInt64Value\0224\n\016first_switc" +
      "hed\030\014 \001(\0132\034.google.protobuf.UInt64Value\022" +
      "3\n\rlast_switched\030\r \001(\0132\034.google.protobuf" +
      ".UInt64Value\0226\n\020num_flow_records\030\016 \001(\0132\034" +
      ".google.protobuf.UInt32Value\0221\n\013num_pack" +
      "ets\030\017 \001(\0132\034.google.protobuf.UInt64Value\022" +
      "2\n\014flow_seq_num\030\020 \001(\0132\034.google.protobuf." +
      "UInt64Value\0228\n\022input_snmp_ifindex\030\021 \001(\0132" +
      "\034.google.protobuf.UInt32Value\0229\n\023output_" +
      "snmp_ifindex\030\022 \001(\0132\034.google.protobuf.UIn" +
      "t32Value\0229\n\023ip_protocol_version\030\023 \001(\0132\034." +
      "google.protobuf.UInt32Value\022\030\n\020next_hop_" +
      "address\030\024 \001(\t\022\031\n\021next_hop_hostname\030\025 \001(\t" +
      "\022.\n\010protocol\030\026 \001(\0132\034.google.protobuf.UIn" +
      "t32Value\022.\n\022sampling_algorithm\030\027 \001(\0162\022.S" +
      "amplingAlgorithm\0227\n\021sampling_interval\030\030 " +
      "\001(\0132\034.google.protobuf.DoubleValue\022\023\n\013src" +
      "_address\030\032 \001(\t\022\024\n\014src_hostname\030\033 \001(\t\022,\n\006" +
      "src_as\030\034 \001(\0132\034.google.protobuf.UInt64Val" +
      "ue\0222\n\014src_mask_len\030\035 \001(\0132\034.google.protob" +
      "uf.UInt32Value\022.\n\010src_port\030\036 \001(\0132\034.googl" +
      "e.protobuf.UInt32Value\022/\n\ttcp_flags\030\037 \001(" +
      "\0132\034.google.protobuf.UInt32Value\022)\n\003tos\030 " +
      " \001(\0132\034.google.protobuf.UInt32Value\022(\n\017ne" +
      "tflow_version\030! \001(\0162\017.NetflowVersion\022*\n\004" +
      "vlan\030\" \001(\0132\034.google.protobuf.UInt32Value" +
      "\022\027\n\017node_identifier\030# \001(\t*2\n\tDirection\022\013" +
      "\n\007INGRESS\020\000\022\n\n\006EGRESS\020\001\022\014\n\007UNKNOWN\020\377\001*\246\002" +
      "\n\021SamplingAlgorithm\022\016\n\nUNASSIGNED\020\000\022#\n\037S" +
      "YSTEMATIC_COUNT_BASED_SAMPLING\020\001\022\"\n\036SYST" +
      "EMATIC_TIME_BASED_SAMPLING\020\002\022\036\n\032RANDOM_N" +
      "_OUT_OF_N_SAMPLING\020\003\022\"\n\036UNIFORM_PROBABIL" +
      "ISTIC_SAMPLING\020\004\022\034\n\030PROPERTY_MATCH_FILTE" +
      "RING\020\005\022\030\n\024HASH_BASED_FILTERING\020\006\022<\n8FLOW" +
      "_STATE_DEPENDENT_INTERMEDIATE_FLOW_SELEC" +
      "TION_PROCESS\020\007*+\n\016NetflowVersion\022\006\n\002V5\020\000" +
      "\022\006\n\002V9\020\001\022\t\n\005IPFIX\020\002BH\n8org.opennms.netmg" +
      "t.telemetry.protocols.netflow.transportB" +
      "\nFlowProtosP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_FlowMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_FlowMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FlowMessage_descriptor,
        new java.lang.String[] { "Timestamp", "NumBytes", "Direction", "DstAddress", "DstHostname", "DstAs", "DstMaskLen", "DstPort", "EngineId", "EngineType", "DeltaSwitched", "FirstSwitched", "LastSwitched", "NumFlowRecords", "NumPackets", "FlowSeqNum", "InputSnmpIfindex", "OutputSnmpIfindex", "IpProtocolVersion", "NextHopAddress", "NextHopHostname", "Protocol", "SamplingAlgorithm", "SamplingInterval", "SrcAddress", "SrcHostname", "SrcAs", "SrcMaskLen", "SrcPort", "TcpFlags", "Tos", "NetflowVersion", "Vlan", "NodeIdentifier", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
