package com.transport.train.domain;


public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String seat;

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String firstName, String lastName, String email, String seat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.seat = seat;
    }
}
