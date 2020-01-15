package service;

import controller.DbWorker;

import java.io.*;
import java.util.Properties;

public class ReadProperties {

    public static Properties readProperties() {

        try {
            System.out.println("enter readProperties");

            InputStream input = new FileInputStream("src/main/resources/db.properties");
            Properties properties = new Properties();
            properties.load(input);

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!22");
            System.out.println(properties.getProperty("jdbc.driver"));
            System.out.println(properties.getProperty("db.url"));
            System.out.println(properties.getProperty("db.name"));
            System.out.println(properties.getProperty("db.user"));
            System.out.println(properties.getProperty("db.password"));

            return properties;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


//        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
//            Properties properties = new Properties();
//            properties.load(input);
//
//
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!22");
//            System.out.println(properties.getProperty("jdbc.driver"));
//        System.out.println(properties.getProperty("db.url"));
//        System.out.println(properties.getProperty("db.name"));
//        System.out.println(properties.getProperty("db.user"));
//        System.out.println(properties.getProperty("db.password"));
//
//
//
//
//
//            return properties;
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }

