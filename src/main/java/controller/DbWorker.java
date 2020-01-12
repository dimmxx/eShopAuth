package controller;

import service.ReadProperties;

import java.sql.*;

public class DbWorker{

    private static final String JDBC_DRIVER = ReadProperties.readProperties().getProperty("jdbc.driver");
    private static final String DB_URL = ReadProperties.readProperties().getProperty("db.url")
        + "/"
        + ReadProperties.readProperties().getProperty("db.name");
    private static final String USER = ReadProperties.readProperties().getProperty("db.user");
    private static final String PASS = ReadProperties.readProperties().getProperty("db.password");

//    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    private static final String DB_URL = "jdbc:mysql://3.133.58.254:3306/eshopauth?useSSL=false";
//    private static final String USER = "root";
//    private static final String PASS = "remote";

    private Connection conn;
    private Statement st;

    public DbWorker() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (Exception ex) {
            System.out.println("Connection error...");
        }

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println(JDBC_DRIVER);
            System.out.println(DB_URL);
            System.out.println(USER);
            System.out.println(PASS);



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