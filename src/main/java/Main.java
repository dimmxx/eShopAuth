import service.ReadProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");

        Properties properties = ReadProperties.readProperties();

        System.out.println(properties.getProperty("jdbc.driver"));
        System.out.println(properties.getProperty("db.url"));
        System.out.println(properties.getProperty("db.name"));
        System.out.println(properties.getProperty("db.user"));
        System.out.println(properties.getProperty("db.password"));


    }


}
