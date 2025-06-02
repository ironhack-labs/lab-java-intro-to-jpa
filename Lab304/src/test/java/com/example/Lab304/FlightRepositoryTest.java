package com.example.Lab304;


import com.example.Lab304.classes.Flight;
import com.example.Lab304.repositories.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    void createFlightTest() {
        Flight flight = new Flight("IB340", "Boeing 747", 500, 50000);
        Flight created = flightRepository.save(flight);

        assertNotNull(created);
        assertEquals("BC589", created.getFlightNumber());
        assertEquals("Boeing 747", created.getAircraft());
        assertEquals(500, created.getTotalAircraftSeats());
        assertEquals(50000, created.getFlightMileage());
    }

    @Test
    void findByFlightNumber() {
        flightRepository.save(new Flight("F2001", "Airbus A320", 180, 4000));
        Flight found = flightRepository.findByFlightNumber("F2001");

        assertNotNull(found);
        assertEquals("F2001", found.getFlightNumber());
        assertEquals("Airbus A320", found.getAircraft());
        assertEquals(180, found.getTotalAircraftSeats());
        assertEquals(4000, found.getFlightMileage());
    }

    @Test
    void findContainingBoingTest() {
        flightRepository.save(new Flight("IB340", "Boeing 747", 500, 50000));
        List<Flight> found = flightRepository.findByAircraftContaining("Boeing");
        assertEquals(1, found.size());
        assertEquals("IB340", found.get(0).getFlightNumber());
    }

    @Test
    void testFindFlightMileageGreaterThan500() {
        flightRepository.save(new Flight("IB340", "Boeing 747", 500, 50000));
        List<Flight> found = flightRepository.findByMileageGreaterThan(500);
        assertEquals(1, found.size());
        assertEquals("IB340", found.get(0).getFlightNumber());
    }
}
