package com.ironhack.controller;

import com.ironhack.model.FlightBooking;
import com.ironhack.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightBookingController {

    @Autowired
    private FlightBookingService flightBookingService;

    @GetMapping("/flightBookings")
    public List<FlightBooking> getAllFlightBookings() {
        return flightBookingService.getAllFlightBookings();
    }

    @PostMapping("/flightBookings")
    public FlightBooking addNewFlightBooking(@RequestBody FlightBooking flightBooking) {
        return flightBookingService.addNewFlightBooking(flightBooking);
    }
}
