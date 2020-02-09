package service;

import java.io.*;
import java.util.Properties;

public class ReadProperties {

    public static Properties readProperties() {
        try {
            InputStream input = new FileInputStream(System.getProperty("user.home") +
                    File.separator +
                    ".eshopauth/db.properties");
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}