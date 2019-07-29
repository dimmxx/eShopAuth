package controller;

import model.User;

import java.sql.*;

public class DbWorkerUtils {

    private static final String CREATE_TABLE_USERS_MYSQL = "CREATE TABLE users_store (" +
            "id INT AUTO_INCREMENT PRIMARY KEY," +
            "username VARCHAR (50) NOT NULL, " +
            "password VARCHAR (256) NOT NULL," +
            "email VARCHAR (50) NOT NULL," +
            "age INT," +
            "gender VARCHAR (1)," +
            "address VARCHAR(256)," +
            "comment VARCHAR (1000)," +
            "agree INT," +
            "role VARCHAR (10)," +
            "created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL," +
            "last_login TIMESTAMP, " +
            "UNIQUE(email))";

    private static final String CREATE_TABLE_PRODUCTS_MYSQL = "CREATE TABLE products (" +
            "id INT AUTO_INCREMENT PRIMARY KEY," +
            "name VARCHAR (50) NOT NULL, " +
            "description VARCHAR (1000)," +
            "price INT," +
            "category INT," +
            "image VARCHAR (1000))";


    private final static String ADD_USER = "INSERT INTO users_store (username, password, email) VALUES (?, ?, ?)";




    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://13.58.87.188:3306/eshopauth";

    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection conn;
    private Statement st;

    public DbWorkerUtils() {
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

    public Connection getConnection() {
        return conn;
    }

    public Statement getStatement() {
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

    public boolean createTable() {
        try {
            getStatement().executeUpdate(CREATE_TABLE_PRODUCTS_MYSQL);
            closeConnection();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    User user = new User("dima", "65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5", "hash@hotmail.com");

    public boolean addUser() {
        try {
            PreparedStatement prs = conn.prepareStatement(ADD_USER);
            prs.setString(1, user.getUsername());
            prs.setString(2, user.getPassword());
            prs.setString(3, user.getEmail());
            prs.execute();
            prs.close();
            closeConnection();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
