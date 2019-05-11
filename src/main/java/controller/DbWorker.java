package controller;

import java.sql.*;

public class DbWorker{

//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://s3.thehost.com.ua/itea2";
//
//    static final String USER = "helen";
//    static final String PASS = "123456";

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://amazonpostgressql.c1mepymbmqks.us-east-2.rds.amazonaws.com:5432/testdb";

    private static final String USER = "master";
    private static final String PASS = "Revolution";

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