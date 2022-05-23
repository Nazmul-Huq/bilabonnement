package com.kea.bilabonnement.model;

/**
 * Author Nazmul
 */

public class Person {

    private int id;
    private String name;
    private int cprNumber;
    private String username;
    private String password;

    // default constructor
    public Person() {
    }

    // constructor without id
    public Person(String name, int cprNumber, String username, String password) {
        this.name = name;
        this.cprNumber = cprNumber;
        this.username = username;
        this.password = password;
    }


    // all args constructor
    public Person(int id, String name, int cprNumber, String username, String password) {
        this.id = id;
        this.name = name;
        this.cprNumber = cprNumber;
        this.username = username;
        this.password = password;
    }


    // getters and setters

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

    public int getCprNumber() {
        return cprNumber;
    }

    public void setCprNumber(int cprNumber) {
        this.cprNumber = cprNumber;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cprNumber=" + cprNumber +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
