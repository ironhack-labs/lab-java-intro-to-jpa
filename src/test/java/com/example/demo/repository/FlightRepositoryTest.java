package com.example.demo.repository;

import com.example.demo.model.Flight;
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

    @Autowired
    private FlightRepository flightRepository;

    private Flight flight;

    @BeforeEach
    void setUp() {
        flight = new Flight(1, "Boeing13", 120, 1000);
        flightRepository.save(flight);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteById(1);
    }

    @Test
    public void testCreateNewFlight(){
        Optional<Flight> flightFromDb = flightRepository.findById(1);
        assertTrue(flightFromDb.isPresent());
        assertEquals(flight, flightFromDb.get());
    }

    @Test
    public void testFindByFlightNumber(){
        List<Flight> flightFromDb = flightRepository.findByFlightNumber(1);
        assertEquals(1, flightFromDb.size());
        assertEquals(flight, flightFromDb.get(0));
    }

    @Test
    public void testFindByAircraft(){
        List<Flight> flightFromDb = flightRepository.findByAircraftContains("Boeing");
        assertEquals(1, flightFromDb.size());
        assertEquals(flight, flightFromDb.get(0));
    }

    @Test
    public void testFindByDistanceGreaterThan(){
        List<Flight> flightFromDb = flightRepository.findByFlightMileageGreaterThan(500);
        assertEquals(1, flightFromDb.size());
        assertEquals(flight, flightFromDb.get(0));
    }
}
