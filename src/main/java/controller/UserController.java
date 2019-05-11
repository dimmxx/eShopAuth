package controller;

import model.User;

import java.sql.*;

public class UserController {

    User user;
    DbWorker db;

    private static final String CREATE_TABLE_POSTGESQL = "CREATE TABLE users_store (id serial PRIMARY KEY, username VARCHAR (50) UNIQUE NOT NULL, password VARCHAR (50) NOT NULL, email VARCHAR (50) UNIQUE, age INTEGER, gender VARCHAR (1), address VARCHAR(50), comment VARCHAR (100), agree INTEGER, role VARCHAR (10), created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, last_login TIMESTAMP)";
    private final static String ADD_USER = "INSERT INTO users_store (username, password, email, age, gender, address, comment, agree, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String GET_USER = "SELECT username, password, email, age, gender, address, comment, agree, role FROM users_store WHERE username= ? AND password= ?";

    public UserController(User user, DbWorker db) {
        this.user = user;
        this.db = db;
    }

    public User getUser() {
        return user;
    }

    public User authUser(User user) {
        Statement st = db.getStatement();
        Connection conn = db.getConnection();
        User userTemp = new User();
        try {
            PreparedStatement prs = conn.prepareStatement(GET_USER);
            prs.setString(1, user.getUsername());
            prs.setString(2, user.getPassword());
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                userTemp.setUsername(rs.getString(1));
                userTemp.setPassword(rs.getString(2));
                userTemp.setEmail(rs.getString(3));
                userTemp.setAge(rs.getInt(4));
                userTemp.setGender(rs.getString(5));
                userTemp.setAddress(rs.getString(6));
                userTemp.setComment(rs.getString(7));
                userTemp.setAgree(rs.getInt(8));
                userTemp.setRole(rs.getString(9));
            }
            prs.close();
            db.closeConnection();
            return userTemp;
        } catch (SQLException e) {
            e.printStackTrace();
            return userTemp;
        }
    }

    public User addUser(User user) {
        Statement st = db.getStatement();
        Connection conn = db.getConnection();
        try {
            PreparedStatement prs = conn.prepareStatement(ADD_USER);
            prs.setString(1, user.getUsername());
            prs.setString(2, user.getPassword());
            prs.setString(3, user.getEmail());
            prs.setInt(4, user.getAge());
            prs.setString(5, user.getGender());
            prs.setString(6, user.getAddress());
            prs.setString(7, user.getComment());
            prs.setInt(8, user.getAgree());
            prs.setString(9, user.getRole());
            prs.execute();
            prs.close();
            db.closeConnection();
            user.setMessageSb("Registration succeded. Login with your username and password\n");
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            user.setMessageSb("Registration failed:\n");
            user.setMessageSb("<li>" + e.toString() + "</li>");
            return user;
        }
    }









}
