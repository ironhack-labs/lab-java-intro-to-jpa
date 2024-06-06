package com.ironhack.labintrotojpa.Repositories;

import com.ironhack.labintrotojpa.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    void setUp() {
        flightRepository.deleteAll();
        Flight flight = new Flight("29","Boeing 777",440,2000);
        Flight flight1 = new Flight("681","Boeing 737",220,999);
        flightRepository.saveAll(List.of(flight, flight1));
    }
//Write tests to verify your ability to find flights by flight number.
    @Test
    void findByFlightNumber() {
        //Given
        List<Flight> flights = flightRepository.findByFlightNumber("29");
        //Then
        assertEquals(1, flights.size());
        //When
        assertEquals("29", flights.get(0).getFlightNumber());
    }
//Write tests to verify your ability to find aircraft with names containing "Boeing".
    @Test
    void findByAircraftContainingIgnoreCase() {
        //Given
        List<Flight> flights = flightRepository.findByAircraftContainingIgnoreCase("Boeing");
        //Then
        assertEquals(2, flights.size());
        //When
        assertEquals("Boeing 777", flights.get(0).getAircraft());
        assertEquals("Boeing 737", flights.get(1).getAircraft());
    }
//Write tests to verify your ability to find flights with a distance greater than 500 miles.
    @Test
    void findByFlightMileageGreaterThanEqual() {
        //Given
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThanEqual(500);
        //When
        assertEquals(2, flights.size());
        //Then
        assertEquals(2, flightRepository.findByFlightMileageGreaterThanEqual(500).size());
    }
}