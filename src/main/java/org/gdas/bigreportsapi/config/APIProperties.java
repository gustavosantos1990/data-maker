package org.gdas.bigreportsapi.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIProperties {

    private static final Properties properties;

    static {
        properties = loadProperties();
    }

    private static Properties loadProperties() {
        try {
            Properties properties = new Properties();
            File file = new File("./src/main/resources/application.properties");
            properties.load(new FileInputStream(file));
            return properties;
        } catch (IOException ex) {
            throw new IllegalStateException("fail to load properties", ex);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (!value.startsWith("${")) return value;
        String envVarKey = extractEnvironmentVariableKey(value);
        return System.getenv(envVarKey);
    }

    private static String extractEnvironmentVariableKey(String value) {
        Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) return matcher.group(1);
        return "";
    }
}
