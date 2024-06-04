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

package org.opennms.core.ipc.grpc.common;

public interface RpcRequestProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:RpcRequestProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string rpc_id = 1;</code>
   * @return The rpcId.
   */
  java.lang.String getRpcId();
  /**
   * <code>string rpc_id = 1;</code>
   * @return The bytes for rpcId.
   */
  com.google.protobuf.ByteString
      getRpcIdBytes();

  /**
   * <code>bytes rpc_content = 2;</code>
   * @return The rpcContent.
   */
  com.google.protobuf.ByteString getRpcContent();

  /**
   * <code>string system_id = 3;</code>
   * @return The systemId.
   */
  java.lang.String getSystemId();
  /**
   * <code>string system_id = 3;</code>
   * @return The bytes for systemId.
   */
  com.google.protobuf.ByteString
      getSystemIdBytes();

  /**
   * <code>string location = 4;</code>
   * @return The location.
   */
  java.lang.String getLocation();
  /**
   * <code>string location = 4;</code>
   * @return The bytes for location.
   */
  com.google.protobuf.ByteString
      getLocationBytes();

  /**
   * <code>string module_id = 5;</code>
   * @return The moduleId.
   */
  java.lang.String getModuleId();
  /**
   * <code>string module_id = 5;</code>
   * @return The bytes for moduleId.
   */
  com.google.protobuf.ByteString
      getModuleIdBytes();

  /**
   * <pre>
   * absolute time elapsed since the epoch in msec.
   * </pre>
   *
   * <code>uint64 expiration_time = 6;</code>
   * @return The expirationTime.
   */
  long getExpirationTime();

  /**
   * <code>map&lt;string, string&gt; tracing_info = 7;</code>
   */
  int getTracingInfoCount();
  /**
   * <code>map&lt;string, string&gt; tracing_info = 7;</code>
   */
  boolean containsTracingInfo(
      java.lang.String key);
  /**
   * Use {@link #getTracingInfoMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getTracingInfo();
  /**
   * <code>map&lt;string, string&gt; tracing_info = 7;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getTracingInfoMap();
  /**
   * <code>map&lt;string, string&gt; tracing_info = 7;</code>
   */

  java.lang.String getTracingInfoOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <code>map&lt;string, string&gt; tracing_info = 7;</code>
   */

  java.lang.String getTracingInfoOrThrow(
      java.lang.String key);
}
