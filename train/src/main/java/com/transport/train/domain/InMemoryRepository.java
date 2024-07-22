package com.transport.train.domain;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Ticket> tickets = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getEmail(), user);
    }

    public User getUser(String email) {
        return users.get(email);
    }

    public void removeUser(String email) {
        users.remove(email);
        tickets.remove(email);
    }

    public void addTicket(Ticket ticket) {
        tickets.put(ticket.getUser().getEmail(), ticket);
    }

    public Ticket getTicket(String email) {
        return tickets.get(email);
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
