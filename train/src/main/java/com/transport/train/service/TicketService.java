package com.transport.train.service;

import com.transport.train.domain.Ticket;
import com.transport.train.domain.TrainSection;
import com.transport.train.domain.User;

import java.util.List;

public interface TicketService {

    Ticket purchaseTicket(String from, String to, User user);
    Ticket getTicketByUserId(int userId);
    List<User> getUsersBySection(TrainSection section);
    void removeUser(int userId);
    Ticket modifyUserSeat(int userId, TrainSection section, int newSeat);
}
