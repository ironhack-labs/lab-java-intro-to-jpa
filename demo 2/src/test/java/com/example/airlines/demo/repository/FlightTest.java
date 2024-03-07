package com.example.airlines.demo.repository;

import com.example.airlines.demo.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FlightTest {
    @Autowired
    FlightRepository flightRepository;

    @BeforeEach
    public void setFlight(){
        Flight flight = new Flight("123", "Boeing", 47, 1000);
        flightRepository.save(flight);
    }

    @AfterEach
    public void shutDown(){
        flightRepository.deleteAll();
    }

    @Test
    public void flightCheck(){
        List<Flight> flights = flightRepository.findAll();

        assertEquals(1, flights.size());
    }

    @Test
    public void nameCheck(){
        Flight flight = flightRepository.findByFlightNumber("123");
        assertEquals("123", flight.getFlightNumber());
    }

    @Test
    public void containsBoeing(){
        List<Flight> boeings = flightRepository.findByAircraft("Boeing");
        List<Flight> airbus = flightRepository.findByAircraft("Airbus");

        assertEquals(1, boeings.size());
        assertEquals(0, airbus.size());
    }

    @Test
    public void greaterThan500(){
        List<Flight> miles = flightRepository.findByFlightMileageGreaterThanEqual(500);

        assertEquals(1, miles.size());
    }




}

