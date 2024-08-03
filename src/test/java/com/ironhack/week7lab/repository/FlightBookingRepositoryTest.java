package com.ironhack.week7lab.repository;

import com.ironhack.week7lab.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FlightBookingRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateFlight() {
        Flight flight = new Flight("FL123", "Boeing 737", 200, 600);
        Flight savedFlight = flightRepository.save(flight);
        assertNotNull(savedFlight.getFlightId());
        assertEquals("FL123", savedFlight.getFlightNumber());
    }

    @Test
    public void testFindFlightByNumber() {
        Flight flight = new Flight("FL456", "Airbus A320", 150, 400);
        flightRepository.save(flight);
        Flight foundFlight = flightRepository.findByFlightNumber("FL456");
        assertNotNull(foundFlight);
        assertEquals("Airbus A320", foundFlight.getAircraft());
    }

    @Test
    public void testFindAircraftContainingName() {
        Flight flight = new Flight("FL789", "Boeing 747", 300, 800);
        flightRepository.save(flight);
        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
        assertNotNull(flights);
        assertEquals(1, flights.size());
        assertEquals("Boeing 747", flights.get(0).getAircraft());
    }

    @Test
    public void testFindFlightsByMileageGreaterThan() {
        Flight flight = new Flight("FL101", "Boeing 787", 250, 1000);
        flightRepository.save(flight);
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
        assertNotNull(flights);
        assertEquals(1, flights.size());
        assertEquals("Boeing 787", flights.get(0).getAircraft());
    }
}