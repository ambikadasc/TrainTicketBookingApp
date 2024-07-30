package com.transport.train.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serial;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket implements Serializable {

    @Serial
    private static final long serialVersionUID = 3465320505777977514L;
    private String from;
    private String to;
    private User user;
    private double price;



    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket(String from, String to, User user, double price) {
        this.from = from;
        this.to = to;
        this.user = user;
        this.price = price;
    }
}
