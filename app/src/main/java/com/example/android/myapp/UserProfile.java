package com.example.android.myapp;

public class UserProfile {
    public String name;
    public String email;
    public String phone;

    public UserProfile( String email, String phone,String name) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
