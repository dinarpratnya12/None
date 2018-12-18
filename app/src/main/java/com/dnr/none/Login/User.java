package com.dnr.none.Login;

public class User {
    public String id;
    public String fullName;
    public String email;
    public String username;
    public String password;

    public User(String id, String username, String fullName, String email, String password) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
}
