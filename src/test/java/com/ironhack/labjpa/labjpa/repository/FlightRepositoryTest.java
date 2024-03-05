package com.ironhack.labjpa.labjpa.repository;

import com.ironhack.labjpa.labjpa.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;
    Flight flight;
    Flight flight1;
    Flight flight2;

    @BeforeEach
    void setUp() {
        flight = new Flight("AB1", "Boeing777", 300, 700);
        flight1 = new Flight("AB2", "TU154", 200, 300);
        flight2 = new Flight("AB3", "IL86", 600, 900);
        flightRepository.save(flight);
        flightRepository.save(flight1);
        flightRepository.save(flight2);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
    }

    @Test
    void findFByFlightNumber() {
        Optional<Flight> flightNum = flightRepository.findFByFlightNumber("AB1");
        assertTrue(flightNum.isPresent());
        assertEquals(flight, flightNum.get());
    }

    @Test
    void findByFlightMileageGreaterThan() {
        List<Flight> flightList = flightRepository.findByFlightMileageGreaterThan(500);
        assertEquals(flight2, flightList.get(1));

    }

    @Test
    void findAllByAircraftContaining() {
        List<Flight> flightList = flightRepository.findAllByAircraftContaining("Boeing");
        assertEquals("AB1", flightList.get(0).getFlightNumber());
    }
}