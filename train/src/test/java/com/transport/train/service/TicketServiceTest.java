package com.transport.train.service;

import com.transport.train.domain.Ticket;
import com.transport.train.domain.TrainSection;
import com.transport.train.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest {

    private TicketService ticketService;

    @BeforeEach
    public void setup() {
        ticketService = new TicketServiceImpl();
    }

    @Test
    void purchaseTicket() {
        User user = new User("Ambikadas", "Chirammel", "ambikadas.chirammel@outlook.com");
        Ticket ticket = ticketService.purchaseTicket("London", "France", user);

        assertNotNull(ticket);
        assertEquals("London", ticket.getFrom());
        assertEquals("France", ticket.getTo());
        assertEquals(user, ticket.getUser());
        assertEquals(20.0, ticket.getPrice());
        assertEquals(TrainSection.A, ticket.getSection());
        assertEquals(1, ticket.getSeat()); // Assuming seat assignment logic
    }

    @Test
    void getTicketByUserId() {
        User user = new User("Subhra", "Choudhury", "subhra.choudhury@outlook.com");
        Ticket ticket = ticketService.purchaseTicket("London", "Berlin", user);
        int userId = 1;
        Ticket retrievedTicket = ticketService.getTicketByUserId(userId);
        assertNotNull(retrievedTicket);
        assertEquals("London", retrievedTicket.getFrom());
        assertEquals("Berlin", retrievedTicket.getTo());
        assertEquals(user, retrievedTicket.getUser());
        assertEquals(20.0, retrievedTicket.getPrice());
        assertEquals(TrainSection.A, retrievedTicket.getSection());
        assertEquals(1, retrievedTicket.getSeat());
    }

    @Test
    void getUsersBySection() {
        User user1 = new User("Ambikadas", "Chirammel", "ambikadas.chirammel@outlook.com");
        User user2 = new User("Subhra", "Choudhury", "subhra.choudhury@outlook.com");

        // Purchase tickets for section A and B
        ticketService.purchaseTicket("London", "Paris", user1);
        ticketService.purchaseTicket("Madrid", "Berlin", user2);
        ticketService.modifyUserSeat(2, TrainSection.B, 5);


        List<User> usersInSectionA = ticketService.getUsersBySection(TrainSection.A);
        List<User> usersInSectionB = ticketService.getUsersBySection(TrainSection.B);

        assertEquals(1, usersInSectionA.size());
        assertEquals(user1, usersInSectionA.get(0));

        assertEquals(1, usersInSectionB.size());
        assertEquals(user2, usersInSectionB.get(0));
    }

    @Test
    void removeUser() {
    }

    @Test
    void modifyUserSeat() {
        User user = new User("Ambikadas", "Chirammel", "ambikadas.chirammel@outlook.com");
        Ticket ticket = ticketService.purchaseTicket("Berlin", "Rome", user);
        int userId = 1; // Assuming this is the userId assigned by the service

        Ticket modifiedTicket = ticketService.modifyUserSeat(userId, TrainSection.A, 5);

        assertEquals(5, modifiedTicket.getSeat());
    }

    @Test
    void modifyUserSeatInvalid() {
        User user = new User("Ambikadas", "Chirammel", "ambikadas.chirammel@outlook.com");
        ticketService.purchaseTicket("Berlin", "Rome", user);
        int userId = 1;

        // Attempt to modify seat in a section where user does not have a ticket
        Ticket modifiedTicket = ticketService.modifyUserSeat(userId, TrainSection.B, 8);

        assertNull(modifiedTicket); // Sh
    }
}