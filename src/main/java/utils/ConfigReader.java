package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties props;

    public static Properties getProperties() {
        if (props == null) {
            props = new Properties();
            try {
                FileInputStream input = new FileInputStream("src/test/resources/config.properties");
                props.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return props;
    }

    public static String get(String key) {
        return getProperties().getProperty(key);
    }
}
