package model;

public class User {

    private String username;
    private String password;
    private String email;
    private int age;
    private String gender;
    private String address;
    private String comment;
    private int agree;
    private String role;
    private StringBuilder messageSb = new StringBuilder();

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email, int age, String gender, String address, String comment, int agree) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.comment = comment;
        this.agree = agree;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    public StringBuilder getMessageSb() {
        return messageSb;
    }

    public void setMessageSb(String message) {
        this.messageSb.append(message);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", comment='" + comment + '\'' +
                ", agree=" + agree +
                ", role='" + role + '\'' +
                ", messageSb=" + messageSb +
                '}';
    }
}
