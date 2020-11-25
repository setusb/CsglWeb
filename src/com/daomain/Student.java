package com.daomain;

/**
 * @author setusb
 * @version 1.0
 * @date 2020/11/23 14:03
 */
public class Student {
    private int id;
    private String name;
    private String password;
    private String email;
    private String love;

    public Student() {
    }

    public Student(int id, String name, String password, String email, String love) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.love = love;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }
}
