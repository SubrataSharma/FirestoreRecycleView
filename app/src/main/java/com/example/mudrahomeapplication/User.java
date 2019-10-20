package com.example.mudrahomeapplication;

public class User {
    private String Age;
    private String Name;

    public User(String age, String name) {
        this.Age = age;
        this.Name = name;
    }

    public User() {
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        this.Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String username) {
        this.Name = username;
    }
}
