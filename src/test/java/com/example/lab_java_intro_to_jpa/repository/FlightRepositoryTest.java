package com.example.lab_java_intro_to_jpa.repository;

import com.example.lab_java_intro_to_jpa.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {
    @Autowired
    FlightRepository flightRepository;

    @Test
    public void findAll_flights_flightList(){
        List<Flight> flightList = flightRepository.findAll();
        System.out.println(flightList);
        assertEquals(4, flightList.size());
    }

    @Test
    public void findById_validID_correctFlight() {
        Optional<Flight> flightOptional = flightRepository.findById(1);
        assertTrue(flightOptional.isPresent());
        System.out.println(flightOptional.get());
        assertEquals(4, flightOptional.get().getFlightId());
    }
}
