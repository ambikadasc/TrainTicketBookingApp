package com.transport.train.service;

import com.transport.train.domain.Ticket;
import com.transport.train.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest {

    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        ticketService = new TicketService();
    }

    @Test
    void purchaseTicket() {
        User user = new User("Ambikadas", "Chirammel", "ambikadas@outlook.com", "");
        Ticket ticket = ticketService.purchaseTicket(user);

        assertNotNull(ticket);
        assertEquals("London", ticket.getFrom());
        assertEquals("France", ticket.getTo());
        assertEquals(20.0, ticket.getPrice());
        assertEquals("Ambikadas", ticket.getUser().getFirstName());
        assertEquals("Chirammel", ticket.getUser().getLastName());
        assertEquals("ambikadas@outlook.com", ticket.getUser().getEmail());
        assertTrue(ticket.getUser().getSeat().startsWith("A") || ticket.getUser().getSeat().startsWith("B"));

    }

    @Test
    void getTicket() {
        User user = new User("Ambikadas", "Chirammel", "ambikadas@outlook.com", "");
        ticketService.purchaseTicket(user);

        Ticket receipt = ticketService.getTicket("ambikadas@outlook.com");
        assertNotNull(receipt);
        assertEquals("ambikadas@outlook.com", receipt.getUser().getEmail());
    }

    @Test
    void getUsersBySection() {
        User user1 = new User("Ambikadas", "Chirammel", "ambikadas@outlook.com", "");
        User user2 = new User("Subhra", "Choudhury", "subhra.choudhury@outlook.com", "");

        ticketService.purchaseTicket(user1);
        ticketService.purchaseTicket(user2);

        Map<String, User> usersInSectionA = ticketService.getUsersBySection("A");
        Map<String, User> usersInSectionB = ticketService.getUsersBySection("B");

        assertTrue(usersInSectionA.size() > 0 || usersInSectionB.size() > 0);

    }

    @Test
    void removeUser() {
        User user = new User("Ambikadas", "Chirammel", "ambikadas@outlook.com", "");
        ticketService.purchaseTicket(user);
        ticketService.removeUser("ambikadas@outlook.com");
        assertNull(ticketService.getTicket("ambikadas@outlook.com"));
    }

    @Test
    void modifyUserSeat() {
        User user = new User("Ambikadas", "Chirammel", "ambikadas@outlook.com", "");
        ticketService.purchaseTicket(user);

        ticketService.modifyUserSeat("ambikadas@outlook.com", "B8");
        User updatedUser = ticketService.getTicket("ambikadas@outlook.com").getUser();
        assertEquals("B8", updatedUser.getSeat());
    }
}