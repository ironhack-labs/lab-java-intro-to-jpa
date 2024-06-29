package com.ironhack.lab_intro_to_jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class FlightRepositoryTests {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateFlight() {
        Flight flight = new Flight("AB123", "Boeing 747", 300, 1000);
        flightRepository.save(flight);
        List<Flight> flights = flightRepository.findByFlightNumber("AB123");
        assertEquals(1, flights.size());
        assertEquals("AB123", flights.get(0).getFlightNumber());
    }

    @Test
    public void testFindAircraftContaining() {
        Flight flight = new Flight("CD456", "Boeing 777", 350, 1200);
        flightRepository.save(flight);
        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
        assertEquals(1, flights.size());
        assertEquals("Boeing 777", flights.get(0).getAircraft());
    }

    @Test
    public void testFindFlightsByMileage() {
        Flight flight = new Flight("EF789", "Airbus A320", 200, 600);
        flightRepository.save(flight);
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
        assertEquals(1, flights.size());
        assertEquals(600, flights.get(0).getFlightMileage());
    }
}

