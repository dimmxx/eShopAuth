package model;

import java.util.Objects;

public class Product {

    private int id;
    private String productName;
    private String description;
    private int price;
    private int category;
    private String image;

    public Product() {
    }

    public Product(String productName, String description, int price, int category, String image) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                category == product.category &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(description, product.description) &&
                Objects.equals(image, product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, description, price, category, image);
    }
}
