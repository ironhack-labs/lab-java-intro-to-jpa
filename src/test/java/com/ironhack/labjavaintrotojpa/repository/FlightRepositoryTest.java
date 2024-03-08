package com.ironhack.labjavaintrotojpa.repository;

import com.ironhack.labjavaintrotojpa.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FlightRepositoryTest {
    Flight flight1;
    Flight flight2;

    @Autowired
    FlightRepository flightRepository;

    @BeforeEach
    void setUp() {
        flight1 = new Flight("223344", "Boeing 377", 320, 100);
        flight2 = new Flight("556677", "Airbus A320", 300, 650);
        flightRepository.save(flight1);
        flightRepository.save(flight2);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteById(flight1.getFlightId());
        flightRepository.deleteById(flight2.getFlightId());
        flight1 = null;
        flight2 = null;
    }

    @Test
    public void findAllTest() {
        List<Flight> flights = flightRepository.findAll();
        assertEquals(2, flights.size());
    }

    @Test
    public void findByFlightNumberTest() {
        Optional<Flight> flight = flightRepository.findByFlightNumber("223344");
        assertTrue(flight.isPresent());
        assertEquals("223344", flight.get().getFlightNumber());
    }

    @Test
    public void findByFlightContainingTest() {
        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
        assertEquals(1, flights.size());
        assertEquals("223344", flights.getFirst().getFlightNumber());
    }

    @Test
    public void findByFlightMileageGreaterThanTest() {
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
        assertEquals(1, flights.size());
        assertEquals("556677", flights.getFirst().getFlightNumber());
    }
}
