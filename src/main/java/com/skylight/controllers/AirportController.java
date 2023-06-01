package com.skylight.controllers;

import com.skylight.models.Airport;
import com.skylight.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

   @Autowired
   private AirportService airportService;

   // Functionality: Returns a list of airports	(Public)
   // Path: /api/airports
   @GetMapping(path = "")
   public List<Airport> getAirports() {
      return airportService.getAllAirports();
   }

   // Functionality: Returns details of an airport (Public)
   // Path: /api/airports
   @GetMapping(path = "/{airportId}")
   public Optional<Airport> getAirportById(@PathVariable Long airportId) {
      return airportService.getAirportById(airportId);
   }
}
