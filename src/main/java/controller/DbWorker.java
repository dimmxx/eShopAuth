package controller;

import service.ReadProperties;

import java.sql.*;
import java.util.Properties;

public class DbWorker{

    private static DbWorker dbWorker;
    private Connection conn;
    private Statement st;
    private Properties properties;

    public static DbWorker getDbworkerInstance(){
        if(dbWorker != null){
            return dbWorker;
        }else{
            return new DbWorker();
        }
    }

    private DbWorker() {
        properties = ReadProperties.readProperties();
        String JDBC_DRIVER = properties.getProperty("jdbc.driver");
        String DB_URL = properties.getProperty("db.url")
                + "/"
                + properties.getProperty("db.name");
        String USER = properties.getProperty("db.user");
        String PASS = properties.getProperty("db.password");



//        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        String DB_URL = "jdbc:mysql://3.133.58.254:3306/eshopauth?useSSL=false";
//        String USER = "root";
//        String PASS = "remote";

        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (Exception ex) {
            System.out.println("Connection error...");
        }
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return conn;
    }

    public Statement getStatement(){
        return st;
    }

    public void closeConnection() {
        try {
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}