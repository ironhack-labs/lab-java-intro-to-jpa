package com.ironhack.lab304.repository;

import com.ironhack.lab304.model.Customer;
import com.ironhack.lab304.model.CustomerStatus;
import com.ironhack.lab304.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {
    @Autowired
    FlightRepository flightRepository;

    // Create New Flight
    @Test
    public void save_flight_newFlight() {
        Flight flight = new Flight("D700", "Airbus A330", 236, 378);

        // Save in DB
        flightRepository.save(flight);

        // Verify if the Flight was created
        assertTrue(flightRepository.findById(flight.getFlightId()).isPresent());
    }

    @Test
    public void save_sameNumberFlight_throwDataIntegrityException() {
        // Same Flight Number (is UNIQUE)
        Flight flight1 = new Flight("D800", "Boeing 747", 400, 330);
        Flight flight2 = new Flight("D800", "Airbus A330", 236, 378);

        // Save First Flight (success)
        flightRepository.save(flight1);

        // Try Save Second Flight (DataIntegrityViolationException -> Throws the restriction violation error)
        assertThrows(DataIntegrityViolationException.class, () -> {
            flightRepository.save(flight2);
        });
    }

    @Test
    public void save_nullNumberFlight_throwDataIntegrityException() {
        // Flight Number (is NOT NULL)
        Flight flight = new Flight(null, "Boeing 747", 400, 230);

        assertThrows(DataIntegrityViolationException.class, () -> {
            flightRepository.save(flight);
        });
    }

    // Find By Flight Number
    @Test
    void findByFlightNumber_validFlightNumber_correctFlight() {

        Optional<Flight> flightOptional = flightRepository.findByFlightNumber("DL143");

        assertTrue(flightOptional.isPresent());

    }

    @Test
    void findByFlightNumber_invalidFlightNumber_notFoundFlight() {

        Optional<Flight> flightOptional = flightRepository.findByFlightNumber("Fl 143");

        assertFalse(flightOptional.isPresent());
    }

    // Find Flights By Aircraft Containing "Boeing"
    @Test
    void findAllByAircraftContaining_boeingName_flightList() {

        List<Flight> flightList = flightRepository.findAllByAircraftContaining("Boeing");

        assertEquals(4, flightList.size());

    }

    // Find Flights Where Flight Mileage > 500 miles
    @Test
    void findAllByFlightMileageGreaterThan_500miles_flightList() {

        List<Flight> flightList = flightRepository.findAllByFlightMileageGreaterThan(500);

        // Verify that Flights exist with that condition
        assertFalse(flightList.isEmpty());
        System.out.println(flightList);
        assertEquals(4, flightList.size());

    }
}