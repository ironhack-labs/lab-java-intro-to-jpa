package com.ironhack.labweek7;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class FlightRepositoryTests {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateNewFlight() {
        Flight flight = new Flight("DL123", "Boeing 747", 400, 1200);
        flightRepository.save(flight);
        assertThat(flight.getFlightId()).isNotNull();
    }

    @Test
    public void testFindFlightByFlightNumber() {
        Flight flight = new Flight("DL456", "Airbus A330", 236, 4500);
        flightRepository.save(flight);
        Flight foundFlight = flightRepository.findByFlightNumber("DL456");
        assertThat(foundFlight).isNotNull();
        assertThat(foundFlight.getFlightNumber()).isEqualTo("DL456");
    }

    @Test
    public void testFindAircraftContainingBoeing() {
        Flight flight = new Flight("DL789", "Boeing 777", 264, 2000);
        flightRepository.save(flight);
        List<Flight> foundFlights = flightRepository.findByAircraftContaining("Boeing");
        assertThat(foundFlights).isNotEmpty();
    }

    @Test
    public void testFindFlightsWithMileageGreaterThan500() {
        Flight flight = new Flight("DL321", "Boeing 737", 200, 600);
        flightRepository.save(flight);
        List<Flight> foundFlights = flightRepository.findByFlightMileageGreaterThan(500);
        assertThat(foundFlights).isNotEmpty();
    }
}

