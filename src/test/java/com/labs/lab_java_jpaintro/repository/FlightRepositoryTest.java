package com.labs.lab_java_jpaintro.repository;

import com.labs.lab_java_jpaintro.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FlightRepositoryTest {
    @Autowired
    FlightRepository flightRepository;

    @Test
    void testFindByFlightNumber() {
        Optional<Flight> flightOptional = flightRepository.findByFlightNumber("DL143");
        assertTrue(flightOptional.isPresent());
        assertEquals("Boeing 747", flightOptional.get().getAircraft());
    }

    @Test
    void testSaveFlight() {
        Flight newFlight = new Flight("DEF789", "Boeing 777", 400, 1200);
        Flight savedFlight = flightRepository.save(newFlight);
        assertNotNull(savedFlight.getFlightId());
        assertEquals("Boeing 777", savedFlight.getAircraft());
        flightRepository.delete(savedFlight);
    }

    @Test
    void testFindFlightsByAircraftContaining() {
        List<Flight> boeingFlights = flightRepository.findByAircraftContaining("Boeing");
        assertEquals(4, boeingFlights.size()); // Expecting 3 flights with aircraft names containing "Boeing"

    }

    @Test
    void testFindFlightsByFlightMileageGreaterThan() {
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
        assertEquals(4, flights.size());

    }

}