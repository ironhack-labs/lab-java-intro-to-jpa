package com.ironhack.repository;

import com.ironhack.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    private Flight flight1;
    private Flight flight2;
    private Flight flight3;

    @BeforeEach
    void setUp() {
        flight1 = new Flight("VY123", "Airbus A330", 300, 1392);
        flightRepository.save(flight1);
        flight2 = new Flight("VY567", "Boeing 747", 264, 402);
        flightRepository.save(flight2);
        flight3 = new Flight("VY901", "Boeing 777", 236, 929);
        flightRepository.save(flight3);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteById(flight1.getFlightId());
        flightRepository.deleteById(flight2.getFlightId());
        flightRepository.deleteById(flight3.getFlightId());
    }

    //Write tests to verify your ability to create new flights.
    @Test
    public void testCreateFlight(){
        Optional<Flight> flightFromDb = flightRepository.findById(flight1.getFlightId());
        assertTrue(flightFromDb.isPresent());
        assertEquals(flight1, flightFromDb.get());
    }

    //Write tests to verify your ability to find flights by flight number.
    @Test
    public void testFindFlightByFlightNumber() {
        Optional<Flight> flightFromDb = flightRepository.findFlightByFlightNumber(flight1.getFlightNumber());
        assertTrue(flightFromDb.isPresent());
        assertEquals(flight1, flightFromDb.get());
    }

    //Write tests to verify your ability to find aircraft with names containing "Boeing".
    @Test
    public void testFindFlightByAircraftLike() {
        List<Flight> flightsFromDb = flightRepository.findAllByAircraftLike("%Boeing%");
        assertEquals(2, flightsFromDb.size());
    }

    //Write tests to verify your ability to find flights with a distance greater than 500 miles.
    @Test
    public void testFindAllFlightsByDistanceGreaterThan(){
        List<Flight> flightsFromDb = flightRepository.findAllByFlightMileageGreaterThan(500);
        assertEquals(2, flightsFromDb.size());
    }
}