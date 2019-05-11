package controller;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    DbWorker db;

    private final static String GET_PRODUCTS_ALL = "SELECT * FROM products";
    private final static String GET_PRODUCT = "SELECT * FROM products WHERE id=";
    private final static String GET_PRODUCTS_CATEGORY = "SELECT * FROM products WHERE category=";
    private final static String CREATE_TABLE_POSTGESQL = "CREATE TABLE products (id serial PRIMARY KEY, name VARCHAR (50) NOT NULL, description VARCHAR (1000), price INTEGER, category INTEGER, image VARCHAR (1000))";
    private final static String ADD_PRODUCT = "INSERT INTO products (name, description, price, category, image) VALUES (?, ?, ?, ?, ?)";

    public ProductController(DbWorker db) {
        this.db = db;
    }

    public List<Product> getProductsFromDb(String category) {
        String query;
        if (category.equals("all")) {
            query = GET_PRODUCTS_ALL;
        } else {
            query = GET_PRODUCTS_CATEGORY + category;
        }
        Statement st = db.getStatement();
        List<Product> products = new ArrayList<>();
        try {
            ResultSet rs = rs = st.executeQuery(query);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setCategory(rs.getInt("category"));
                product.setImage(rs.getString("image"));
                products.add(product);
            }
            db.closeConnection();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean createTable() {
        Statement st = db.getStatement();
        try {
            st.executeUpdate(CREATE_TABLE_POSTGESQL);
            db.closeConnection();
            st.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createTableSQLite() {
        Statement st = db.getStatement();
        String CREATE_TABLE_SQLite = "CREATE TABLE products (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR (50) NOT NULL, description VARCHAR (1000), price INTEGER, category INTEGER, image VARCHAR (1000))";
        try {
            st.executeUpdate(CREATE_TABLE_SQLite);
            db.closeConnection();
            st.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addProductToDb(Product product) {
        Connection conn = db.getConnection();
        Statement st = db.getStatement();
        try {
            PreparedStatement prs = conn.prepareStatement(ADD_PRODUCT);
            prs.setString(1, product.getProductName());
            prs.setString(2, product.getDescription());
            prs.setInt(3, product.getPrice());
            prs.setInt(4, product.getCategory());
            prs.setString(5, product.getImage());
            prs.execute();
            prs.close();
            db.closeConnection();
            st.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Product getProduct(int id) {
        Statement st = db.getStatement();
        Product product = null;
        try {
            ResultSet rs = rs = st.executeQuery(GET_PRODUCT + id);
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setCategory(rs.getInt("category"));
                product.setImage(rs.getString("image"));
            }
            db.closeConnection();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
