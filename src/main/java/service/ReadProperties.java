package service;

import controller.DbWorker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    public static Properties readProperties() {

        InputStream inputStream =
   DbWorker.class.getResourceAsStream("db.properties");

        try (InputStream input = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            System.out.println(properties.getProperty("jdbc.driver"));
            System.out.println(properties.getProperty("db.url"));
            System.out.println(properties.getProperty("db.name"));
            System.out.println(properties.getProperty("db.user"));
            System.out.println(properties.getProperty("db.password"));

            return properties;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
