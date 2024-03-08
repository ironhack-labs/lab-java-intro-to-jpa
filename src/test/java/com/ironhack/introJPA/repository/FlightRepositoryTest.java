package com.ironhack.introJPA.repository;

import com.ironhack.introJPA.model.Customer;
import com.ironhack.introJPA.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    private Flight flight;

    @BeforeEach
    void setUp() {
        flight = new Flight("T33", "Airbus 777", 230, 400);
        Flight flight1 = new Flight("T34", "Boeing 1000", 380, 250);
        Flight flight2 = new Flight("RR89", "Boeing 747", 290, 1020);
        Flight flight3 = new Flight("PSE01B", "Loquesea", 30, 617);
        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
    }

    @Test
    void testCreateNewFlight() {
        flightRepository.save(flight);
        List<Flight> flightList = flightRepository.findByFlightNumber("T33");
        assertEquals(flight, flightList.get(0));
    }

    @Test
    void findByFlightNumber() {
        List<Flight> flightList = flightRepository.findByFlightNumber("T34");
        assertNotNull(flightList);
        assertEquals(1, flightList.size());
    }

    @Test
    void findByAircraftContains() {
        List<Flight> boeingAircraft = flightRepository.findByAircraftContains("Boeing");

        // Verify that the list is not empty
        assertFalse(boeingAircraft.isEmpty());

        // Output names of aircraft
        for (Flight a : boeingAircraft) {
            System.out.println(a.getAircraft());
        }

        assertNotNull(boeingAircraft);
        assertEquals(2, boeingAircraft.size());
    }

    @Test
    void findByFlightMileageGreaterThan() {
        List<Flight> mileageGreaterThan = flightRepository.findByFlightMileageGreaterThan(500);
        assertNotNull(mileageGreaterThan);
        assertEquals(2, mileageGreaterThan.size());
    }

    @Test
    void findByFlightMileageLessThan() {
        List<Flight> mileageGreaterThan = flightRepository.findByFlightMileageLessThan(500);
        assertNotNull(mileageGreaterThan);
        assertEquals(1, mileageGreaterThan.size());
    }
}