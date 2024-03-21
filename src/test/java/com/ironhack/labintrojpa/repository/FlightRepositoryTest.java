package com.ironhack.labintrojpa.repository;

import com.ironhack.labintrojpa.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    void setUp() {
        List<Flight> flights = List.of(
                new Flight("DL143", "Boeing 747", 400, 135),
                new Flight("DL122", "Airbus A330", 236, 4370),
                new Flight("DL53", "Boeing 777", 264, 2078)
        );
        flightRepository.saveAll(flights);
    }

    @AfterEach
    void afterEach() {
        flightRepository.deleteAll();
    }

    @Test
    public void testCreateFlights() {
        List<Flight> flights = flightRepository.findAll();
        assertNotNull(flights);
        assertEquals(3, flights.size());
    }

    @Test
    public void testFindByFlightNumber() {
        List<Flight> flights = flightRepository.findByFlightNumberContaining("DL122");
        assertNotNull(flights);
        assertEquals("DL122", flights.get(0).getFlightNumber());
        assertTrue(flights.stream().allMatch(f -> f.getAircraft().toLowerCase().contains("airbus")));
    }

    @Test
    public void testFindFlightsByDistanceGreaterThan500Miles() {
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
        assertNotNull(flights);
        assertEquals(2, flights.size());
    }

}