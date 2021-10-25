/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2021-2021 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2021 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.dao.mock;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import javax.xml.bind.JAXBException;
import org.json.JSONObject;
import org.opennms.features.config.dao.api.ConfigData;
import org.opennms.features.config.dao.api.ConfigSchema;
import org.opennms.features.config.service.api.ConfigUpdateInfo;
import org.opennms.features.config.service.api.ConfigurationManagerService;
import org.opennms.features.config.service.api.JsonAsString;
import org.springframework.stereotype.Component;

/**
 * It is a minimal mock for CM use. If configFile is passed, it will read and return as configEntity.
 * Otherwise, I will return a new instance.
 */
@Component
public class ConfigurationManagerServiceMock implements ConfigurationManagerService {

    private String configFile;
    private Optional<String> configOptional;

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    /** Registers a new schema. The schema name must not have been used before. */
    @Override
    public void registerSchema(String configName, String xsdName, String topLevelElement) throws IOException, JAXBException{}

    /** Upgrades an existing schema to a new version. Existing da is validated against the new schema. */
    @Override
    public void upgradeSchema(String configName, String xsdName, String topLevelElement) throws IOException, JAXBException{}

    @Override
    public Map<String, ConfigSchema<?>> getAllConfigSchema() {
        return null;
    }

    @Override
    public Optional<ConfigSchema<?>> getRegisteredSchema(String configName) throws IOException {
        return Optional.empty();
    }

    @Override
    public void registerReloadConsumer(ConfigUpdateInfo info, Consumer<ConfigUpdateInfo> consumer) {
    }

    @Override
    public void registerConfiguration(String configName, String configId, JsonAsString configObject) throws IOException {
    }

    @Override
    public void unregisterConfiguration(String configName, String configId) throws IOException {

    }

    @Override
    public void updateConfiguration(String configName, String configId, JsonAsString configObject) throws IOException {

    }

    @Override
    public Optional<JSONObject> getJSONConfiguration(String configName, String configId) throws IOException {
        return Optional.empty();
    }

    @Override
    public String getJSONStrConfiguration(String configName, String configId) throws IOException {
        return null;
    }

    @Override
    public Optional<String> getXmlConfiguration(String configName, String configId) throws IOException {
        if (configOptional != null) {
            return configOptional;
        }
        if (configFile == null) {
            this.configOptional = Optional.empty();
        } else {
            InputStream in = ConfigurationManagerServiceMock.class.getClassLoader().getResourceAsStream(configFile);
            String xmlStr = IOUtils.toString(in, StandardCharsets.UTF_8);
            configOptional = Optional.of(xmlStr);
        }
        return configOptional;
    }

    @Override
    public Optional<ConfigData<JSONObject>> getConfigData(String configName) throws IOException {
        return Optional.empty();
    }

    @Override
    public Set<String> getConfigNames() throws IOException {
        return new HashSet<>();
    }

    @Override
    public void unregisterSchema(String configName) throws IOException {

    }

    @Override
    public Set<String> getConfigIds(String configName) throws IOException {
        return new HashSet<>();
    }
}
