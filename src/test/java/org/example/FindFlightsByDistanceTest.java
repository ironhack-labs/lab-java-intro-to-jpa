package org.example;

import org.example.Model.Flight;
import org.example.Repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FindFlightsByDistanceTest {

    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    public void setup() {
        // Clean up the repository to avoid interference from previous tests
        flightRepository.deleteAll();

        // Given - setup some test flights
        Flight shortFlight = new Flight("FL100", "Boeing 737", 150, 300); // Less than 500 miles
        Flight longFlight1 = new Flight("FL101", "Boeing 747", 350, 1200); // Greater than 500 miles
        Flight longFlight2 = new Flight("FL102", "Airbus A320", 180, 600); // Greater than 500 miles

        // Save flights
        flightRepository.save(shortFlight);
        flightRepository.save(longFlight1);
        flightRepository.save(longFlight2);
    }

    @Test
    public void testFindFlightsByDistanceGreaterThan500Miles() {
        // When
        List<Flight> results = flightRepository.findByFlightMileageGreaterThan(500);

        // Then
        assertEquals(2, results.size(), "Should find 2 flights over 500 miles");
        // Assert all found flights have mileage greater than 500
        assertTrue(results.stream().allMatch(flight -> flight.getFlightMileage() > 500),
                "All found flights should have mileage greater than 500");
    }
}