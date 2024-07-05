package com.jpa.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FlightRepositoryTests {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateFlight() {
        Flight flight = new Flight("DL143", "Boeing 747", 400, 135);
        flightRepository.save(flight);

        Flight foundFlight = flightRepository.findByFlightNumber("DL143");
        assertTrue(foundFlight != null);
    }

    @Test
    public void testFindFlightsByFlightNumber() {
        Flight flight = flightRepository.findByFlightNumber("DL143");
        assertTrue(flight != null);
    }

    @Test
    public void testFindAircraftWithNamesContainingBoeing() {
        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
        assertTrue(flights.size() > 0);
    }

    @Test
    public void testFindFlightsWithDistanceGreaterThan500Miles() {
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
        assertTrue(flights.size() > 0);
    }
}
