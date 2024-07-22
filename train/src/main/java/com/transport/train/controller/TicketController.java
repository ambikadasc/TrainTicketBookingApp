package com.transport.train.controller;


import com.transport.train.domain.Ticket;
import com.transport.train.domain.User;
import com.transport.train.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody User user) {
        return ticketService.purchaseTicket(user);
    }

    @GetMapping("/receipt/{email}")
    public Ticket getTicket(@PathVariable String email) {
        return ticketService.getTicket(email);
    }

    @GetMapping("/users/{section}")
    public Map<String, User> getUsersBySection(@PathVariable String section) {
        return ticketService.getUsersBySection(section);
    }

    @DeleteMapping("/user/{email}")
    public void removeUser(@PathVariable String email) {
        ticketService.removeUser(email);
    }

    @PutMapping("/user/seat")
    public void modifyUserSeat(@RequestParam String email, @RequestParam String newSeat) {
        ticketService.modifyUserSeat(email, newSeat);
    }



}
