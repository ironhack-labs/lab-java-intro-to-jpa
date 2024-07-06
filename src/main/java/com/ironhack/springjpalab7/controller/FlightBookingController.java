package com.ironhack.springjpalab7.controller;


import com.ironhack.springjpalab7.model.FlightBooking;
import com.ironhack.springjpalab7.service.FlightBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class FlightBookingController {

    private FlightBookingService flightBookingService;

    @PostMapping
    public FlightBooking createBooking(@RequestBody FlightBooking booking) {
        return flightBookingService.createBooking(booking);
    }
    @GetMapping
    public List<FlightBooking> getAllBookings() {
        return flightBookingService.findAllBookings();
    }
    @GetMapping("/{customerId}")
    public List<FlightBooking> getBookingByCustomerId(@PathVariable Long customerId) {
        return flightBookingService.findBookingByCustomerId(Math.toIntExact(customerId));
    }
    @PutMapping("/search/{flightId}")
    public List<FlightBooking> getBookingsByFlightId(@PathVariable Long flightId) {
        return flightBookingService.findBookingByFlightId(Math.toIntExact(flightId));
    }
    @DeleteMapping("/search/{bookings}")
    public void deleteBooking(@PathVariable Integer bookingId) {
        flightBookingService.deleteBookingById(bookingId);
    }
}
