package com.ironhack.labjavaintrotojpa.service;

import com.ironhack.labjavaintrotojpa.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightServiceTest {

    @Autowired
    private FlightService flightService;

    @BeforeEach
    void setUp() {
        flightService.saveAll(List.of(
                new Flight("DL122", "Airbus A330", 236, 4370),
                new Flight("DL143", "Boeing 747", 400, 135),
                new Flight("DL222", "Boeing 777", 264, 1765),
                new Flight("DL37", "Boeing 747", 400, 531),
                new Flight("DL53", "Boeing 777", 264, 2078)
        ));
    }

    @AfterEach
    void tearDown() {
        flightService.deleteAll();
    }

    @Test
    void createFlight() {
        // Arrange
        int initialSize = flightService.findAll().size();
        Flight flight = new Flight("DL999", "Airbus A999", 999, 9999);
        // Act
        flightService.save(flight);
        int finalSize = flightService.findAll().size();
        // Assert
        assertEquals(finalSize, initialSize + 1);
    }

    @Test
    void findByFlightNumber() {
        // Assert
        assertNotNull(flightService.findByFlightNumber("DL143"));
        assertEquals(4370, flightService.findByFlightNumber("DL122").getFlightMileage());
        assertThrows(NoSuchElementException.class, () -> flightService.findByFlightNumber("99999"));
    }

    @Test
    void findBoeingFlights() {
        // Assert
        assertNotNull(flightService.findBoeingFlights());
        assertEquals(4, flightService.findBoeingFlights().size());
    }

    @Test
    void findFlightsWithOver500Mileage() {
        // Assert
        assertNotNull(flightService.findFlightsWithOver500Mileage());
        assertEquals(4, flightService.findFlightsWithOver500Mileage().size());
    }
}