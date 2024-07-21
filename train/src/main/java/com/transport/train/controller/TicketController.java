package com.transport.train.controller;


import com.transport.train.domain.Ticket;
import com.transport.train.domain.TrainSection;
import com.transport.train.domain.User;
import com.transport.train.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestParam String from, @RequestParam String to, @RequestBody User user) {
        return ticketService.purchaseTicket(from, to, user);
    }

    @GetMapping("/{userId}")
    public Ticket getTicket(@PathVariable int userId) {
        return ticketService.getTicketByUserId(userId);
    }

    @GetMapping("/users/{section}")
    public List<User> getUsersBySection(@PathVariable TrainSection section) {
        return ticketService.getUsersBySection(section);
    }

    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable int userId) {
        ticketService.removeUser(userId);
    }

    @PutMapping("/{userId}/seat")
    public Ticket modifyUserSeat(@PathVariable int userId, @RequestParam TrainSection section, @RequestParam int newSeat) {
        return ticketService.modifyUserSeat(userId, section, newSeat);
    }

}
