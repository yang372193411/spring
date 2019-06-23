package com.ityang.basic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {
    public static String dbType;

    @Value("${yang.dbType}")
    public void setDbType(String dbType) {
        PropertiesConfig.dbType = dbType;
    }

    public static String getDbType() {
        return dbType;
    }
}
