package com.transport.train.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transport.train.domain.InMemoryRepository;
import com.transport.train.domain.Ticket;
import com.transport.train.domain.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private InMemoryRepository repository = new InMemoryRepository();
    private static final double TICKET_PRICE = 20.0;
    private static final String FROM = "London";
    private static final String TO = "France";

    public Ticket purchaseTicket(User user) {
        String seat = allocateSeat();
        user.setSeat(seat);
        repository.addUser(user);


        Ticket ticket = new Ticket(FROM, TO, user, TICKET_PRICE);
        repository.addTicket(ticket);

        return ticket;
    }

    public Ticket getTicket(String email) {
        return repository.getTicket(email);
    }

    public Map<String, User> getUsersBySection(String section) {
        return repository.getUsers().values().stream()
                .filter(user -> user.getSeat().startsWith(section))
                .collect(Collectors.toMap(User::getEmail, user -> user));
    }

    public void removeUser(String email) {
        repository.removeUser(email);
    }

    public void modifyUserSeat(String email, String newSeat) {
        User user = repository.getUser(email);
        if (user != null) {
            user.setSeat(newSeat);
            repository.addUser(user); // Re-add the user to update the seat information
        }
    }

    private String allocateSeat() {
        // Simple seat allocation logic, alternating between sections A and B
        long countA = repository.getUsers().values().stream().filter(user -> user.getSeat().startsWith("A")).count();
        long countB = repository.getUsers().values().stream().filter(user -> user.getSeat().startsWith("B")).count();
        return (countA <= countB ? "A" : "B") + (countA + countB + 1);
    }
}
