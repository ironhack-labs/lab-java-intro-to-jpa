package com.ironhack.demo;

import com.ironhack.demo.model.Customer;
import com.ironhack.demo.model.Flight;
import com.ironhack.demo.repository.FlightRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FlightRepositoryTest {

    @Autowired
    FlightRepository flightRepository;

    @BeforeEach
    void setUp(){
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("DL143", "Boeing 747", 100, 520));
        flights.add(new Flight("DL142", "Boeing 123", 200, 130));
        flights.add(new Flight("DL141", "Airbus A330", 300, 100));
        flights.add(new Flight("DL140", "Airbus 143", 400, 120));

        flightRepository.saveAll(flights);
    }

    @AfterEach
    void tearDown(){
        flightRepository.deleteAll();
    }

    @Test
    @DisplayName("Test to verify that a new flight is created.")
    public void createNewFlightTest(){
        List<Flight> flight = flightRepository.findAll();
        assertEquals(4, flight.size());
    }

    @Test
    @DisplayName("Test to verify Find flight by flight number.")
    public void findByFlightNumberTest(){
        Optional<Flight> result = flightRepository.findByFlightNumber("DL143");
        assertTrue(result.isPresent());
        assertEquals("DL143", result.get().getFlightNumber());

        Optional<Flight> result1 = flightRepository.findByFlightNumber("DL");
        assertFalse(result1.isPresent());
    }

    @Test
    @DisplayName("Test to verify Find aircraft with name containing Boeing.")
    public void findByAircraftContainingTest(){
        List<Flight> result = flightRepository.findByAircraftContaining("Boeing");
        assertEquals(2, result.size());

    }

    @Test
    @DisplayName("Test to verify Find aircraft with name containing Boeing.")
    public void findByFlightMileageGreaterThanTest(){
        List<Flight> result = flightRepository.findByFlightMileageGreaterThan(500);
        assertEquals(1, result.size());
    }
}
