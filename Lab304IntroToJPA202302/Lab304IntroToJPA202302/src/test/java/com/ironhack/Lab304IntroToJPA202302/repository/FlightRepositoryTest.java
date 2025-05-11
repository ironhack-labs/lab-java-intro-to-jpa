package com.ironhack.Lab304IntroToJPA202302.repository;

import com.ironhack.Lab304IntroToJPA202302.model.Flight;
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

    @BeforeEach
    void setUp() {
        flightRepository.deleteAll();

    }

    @Test
    void testNewFlight() {
        Flight flight = new Flight("DL145", "Boeing747", 400, 135);
        flightRepository.save(flight);
        assertTrue(flight.getFlightId() > 0);
        System.out.println(flight);
    }

    @Test
    void testFindFlightByFlightNumber() {
        Flight flight = new Flight("DL145", "Boeing747", 400, 135);
        Flight flight2 = new Flight("DL156", "AirbusA330", 236, 4370);
        Flight flight3 = new Flight("ll897", "Boeing777", 400, 135);
        flightRepository.save(flight);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        Optional<Flight> flightOptional = flightRepository.findByFlightNumber("DL156");
        assertTrue(flightOptional.isPresent());
        assertEquals("DL156", flightOptional.get().getFlightNumber());
    }

    @Test
    void testFindFlightThatContaining() {
        Flight flight = new Flight("DL145", "Boeing 747", 400, 135);
        Flight flight2 = new Flight("DL156", "Airbus A330", 236, 4370);
        Flight flight3 = new Flight("ll897", "Boeing 777", 400, 135);
        flightRepository.save(flight);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        List<Flight> flightList = flightRepository.findByAircraftContaining("Boeing");
        assertEquals(2, flightList.size());
        for (Flight f : flightList) {
            assertTrue(f.getAircraft().contains("Boeing"));
            System.out.println(f);
        }
    }

    @Test
    void testFindByFlightMileageGreaterThan() {
        Flight flight = new Flight("DL145", "Boeing 747", 400, 135);
        Flight flight2 = new Flight("DL156", "Airbus A330", 236, 4370);
        Flight flight3 = new Flight("ll897", "Boeing 777", 400, 135);
        flightRepository.save(flight);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        List<Flight> flightList = flightRepository.findByFlightMileageGreaterThan(500);
        assertEquals(1, flightList.size());
        for (Flight f : flightList) {
            assertTrue(f.getFlightMileage() > 500);
            System.out.println(f);
        }
    }


}

