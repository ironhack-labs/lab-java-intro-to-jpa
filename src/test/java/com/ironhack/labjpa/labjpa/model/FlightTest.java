package com.ironhack.labjpa.labjpa.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FlightTest {
    private Flight flight;

    @BeforeEach
    void setUp() {
        flight = new Flight("ABC1", "Boeing", 123, 444);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void createFlightTest(){
        assertEquals("ABC1", flight.getFlightNumber());
        assertEquals("Boeing", flight.getAircraft());
        assertEquals(123, flight.getTotalAircraftSeats());
        assertEquals(444, flight.getFlightMileage());
    }
}