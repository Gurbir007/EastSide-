package utils;


import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    static {
        try (InputStream input = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("config.properties")) {
            prop.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
