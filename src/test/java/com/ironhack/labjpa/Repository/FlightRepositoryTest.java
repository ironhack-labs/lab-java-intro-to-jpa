package com.ironhack.labjpa.Repository;

import com.ironhack.labjpa.model.Flight;
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
        Flight flight = new Flight("729","Boeing 777",440,5854);
        Flight flight1 = new Flight("A756","Boeing 737" ,220,1200);
        flightRepository.saveAll(List.of(flight,flight1));

    }
    @Test
    void findByFlightNumber(){
        //Given
        List<Flight> flights = flightRepository.findByFlightNumber("729");
        //Then
        assertEquals(1, flights.size());
        //When
        assertEquals("729",flights.get(0).getFlightNumber());

    }
    @Test
    void findByAircraftContainingIgnoreCase(){
        //Given
        List<Flight>flights=flightRepository.findByAircraftContainingIgnoreCase("Boeing");
        //then
        assertEquals(2,flights.size());
        //Given
        assertEquals("Boeing 777", flights.get(0).getAircraft());
        assertEquals("Boeing 737", flights.get(1).getAircraft());
    }
    @Test
    void findByMileageGreaterThanEqual(){
        //Given
        List<Flight>flights=flightRepository.findByFlightMileageGreaterThanEqual(500);
        //When
        assertEquals(2,flights.size());
        //Then
        assertEquals(2, flightRepository.findByFlightMileageGreaterThanEqual(500).size());
    }

}