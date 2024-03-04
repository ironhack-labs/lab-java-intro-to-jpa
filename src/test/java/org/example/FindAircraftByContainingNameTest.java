package org.example;

import org.example.Model.Flight;
import org.example.Repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FindAircraftByContainingNameTest {

    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    public void setup() {
        // Cleanup the repository to avoid conflicts and ensure a consistent starting state
      //  flightRepository.deleteAll();

        // Setup data - adding a few sample flight entities, with at least one Boeing aircraft
        flightRepository.save(new Flight("FL123", "Boeing 737", 180, 1200));
        flightRepository.save(new Flight("FL456", "Airbus A320", 160, 1000));
        flightRepository.save(new Flight("FL789", "Boeing 747", 366, 1500));
    }

    @Test
    public void testFindAircraftByContainingName() {
        // When
        List<Flight> boeingFlights = flightRepository.findByAircraftContaining("Boeing");

        // Then
        // Assert that we find Boeing flights
        assertThat(boeingFlights).isNotEmpty();
        assertThat(boeingFlights).allMatch(flight -> flight.getAircraft().contains("Boeing"));
    }
}

