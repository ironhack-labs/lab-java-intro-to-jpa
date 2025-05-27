package com.ironhack.LAB.Java.Intro.to.JPA.repository;

import com.ironhack.LAB.Java.Intro.to.JPA.model.Flight;
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
    FlightRepository flightRepository;
    Flight flight1;
    Flight flight2;

    @BeforeEach
    public void SetUp() {
        flightRepository.deleteAll();
        flight1 = new Flight("ARG34", "BOEING707", 210, 4000,1);
        flight2 = new Flight("ESP67", "BOEING404", 250, 12000,2);
        flightRepository.saveAll(List.of(flight1, flight2));
    }

    @Test
    public void findFlightByFlightNumber() {
        Optional<Flight> flightOptional = flightRepository.findFlightByFlightNumber("ARG34");
        assertTrue(flightOptional.isPresent());
        assertEquals("ARG34", flightOptional.get().getFlightNumber());
        System.out.println(flight1);
    }

    @Test
    public void findAircraftWithNameBoeing() {
        List<Flight> boeingFlights = flightRepository.findByAirCraftContainingIgnoreCase("BOEING");
        assertFalse(boeingFlights.isEmpty());
        boeingFlights.forEach(flight -> assertTrue(flight.getAirCraft().contains("BOEING")));
        System.out.println(boeingFlights);
    }

    @Test
    public void findFlightsWithDistanceGreaterThan500 () {
        List<Flight> flightList = flightRepository.findByFlightMileageGreaterThan(500);
        System.out.println(flightList);
        assertFalse(flightList.isEmpty());
        assertEquals(2,flightList.size());
    }


}