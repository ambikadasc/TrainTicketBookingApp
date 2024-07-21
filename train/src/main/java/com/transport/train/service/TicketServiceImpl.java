package com.transport.train.service;

import com.transport.train.domain.Ticket;
import com.transport.train.domain.TrainSection;
import com.transport.train.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketServiceImpl implements TicketService {
    private Map<Integer, Ticket> ticketDatabase = new HashMap<>();
    private int nextUserId = 1;

    @Override
    public Ticket purchaseTicket(String from, String to, User user) {
        Ticket ticket = new Ticket();
        ticket.setFrom(from);
        ticket.setTo(to);
        ticket.setUser(user);
        ticket.setPrice(20.0);
        ticket.setSection(TrainSection.A);
        ticket.setSeat(assignSeat(TrainSection.A));
        ticketDatabase.put(nextUserId, ticket);
        nextUserId++;
        return ticket;
    }

    @Override
    public Ticket getTicketByUserId(int userId) {
        return ticketDatabase.get(userId);
    }

    @Override
    public List<User> getUsersBySection(TrainSection section) {
        List<User> usersInSection = new ArrayList<>();
        for (Ticket ticket : ticketDatabase.values()) {
            if (ticket.getSection() == section) {
                usersInSection.add(ticket.getUser());
            }
        }
        return usersInSection;
    }

    @Override
    public void removeUser(int userId) {
        ticketDatabase.remove(userId);
    }

    @Override
    public Ticket modifyUserSeat(int userId, TrainSection section, int newSeat) {
        Ticket ticket = ticketDatabase.get(userId);
        if (ticket != null && ticket.getSection() == section) {
            ticket.setSeat(newSeat);
        }
        return ticket;
    }

    private int assignSeat(TrainSection section) {
        // Simulate assigning seats
        return 1; // Assign seat 1 for simplicity
    }
}
