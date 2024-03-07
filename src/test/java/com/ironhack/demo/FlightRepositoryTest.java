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
        List<Flight> flightList = new ArrayList<>();
        flightList.add(new Flight("F1", "Boeing1", 500, 100));
        flightList.add(new Flight("F2", "Airbus1", 300, 300));
        flightList.add(new Flight("F3", "Airbus2", 100, 500));

        flightRepository.saveAll(flightList);
    }

    @AfterEach
    void tearDown(){
        flightRepository.deleteAll();
    }

    @Test
    @DisplayName("Test to verify your ability to create new flights.")
    public void createNewFlightsTest(){
        List<Flight> flight = flightRepository.findAll();
        assertEquals(4, flight.size());
    }

    @Test
    @DisplayName("Test to verify your ability to find flights by flight number.")
    public void findByFlightNumberTest(){
        Optional<Flight> result1 = flightRepository.findByFlightNumber("DL143");
        assertTrue(result1.isPresent());
        assertEquals("DL143", result1.get().getFlightNumber());

        Optional<Flight> result2 = flightRepository.findByFlightNumber("DL");
        assertFalse(result2.isPresent());
    }

    @Test
    @DisplayName("Test to verify your ability to find aircraft with names containing \"Boeing\".")
    public void findByAircraftContainingTest(){
        List<Flight> result = flightRepository.findByAircraftContaining("Boeing");
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Test to verify your ability to find flights with a distance greater than 500 miles.")
    public void findByFlightMileageGreaterThanTest(){
        List<Flight> result = flightRepository.findByFlightMileageGreaterThan(400);
        assertEquals(1, result.size());
    }
}
