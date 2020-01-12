package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    public static Properties readProperties() {
        try (InputStream input = new FileInputStream("./config.cfg")) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
