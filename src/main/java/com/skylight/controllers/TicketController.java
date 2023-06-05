package com.skylight.controllers;

import com.skylight.models.Ticket;
import com.skylight.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

   @Autowired
   private TicketService ticketService;

   // Functionality: Returns ticket details (Public/Private)
   // Path: /api/tickets/{ticketId}
   @GetMapping(path = "/{ticketId}")
   public Optional<Ticket> getTicketById(@PathVariable Long ticketId) {
      return ticketService.getTicketById(ticketId);
   }

   // Functionality: Admin deletes ticket (Private)
   // Path: /api/tickets/{ticketId}
   @DeleteMapping(path = "/{ticketId}")
   public Optional<Ticket> deleteTicketAdmin(@PathVariable Long ticketId) {
      return ticketService.deleteTicketAdmin(ticketId);
   }

   // Functionality: User books ticket (Public)
   // Path: /api/tickets/{ticketId}/bookFlight
   @PutMapping(path = "/{ticketId}/bookFlight")
   public Optional<Ticket> bookFlight(@PathVariable Long ticketId) {
      return ticketService.bookFlight(ticketId);
   }
}
