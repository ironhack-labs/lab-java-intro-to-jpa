package com.ironhack.lab_intro_to_jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class FlightBookingRepositoryTests {

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @Test
    public void testCreateFlightBooking() {
        FlightBooking booking = new FlightBooking(1, 1);
        flightBookingRepository.save(booking);
        List<FlightBooking> bookings = flightBookingRepository.findAll();
        assertNotNull(bookings);
        assertEquals(1, bookings.size());
    }
}
