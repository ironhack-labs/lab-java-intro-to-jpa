package org.example;

import org.example.Model.Flight;
import org.example.Repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FindFlightsByFlightNumberTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test

    public void testFindFlightsByFlightNumber() {
        // Given
        String flightNumberToFind = "ABC123";
        Flight flight = new Flight(flightNumberToFind, "Aircraft1", 150, 1000);
        flightRepository.save(flight);

        // When
        List<Flight> foundFlights = flightRepository.findByFlightNumber(flightNumberToFind);
        // Print the found flights
        foundFlights.forEach(flights -> System.out.println("Found Flight: " + flights));

        // Then
        assertThat(foundFlights).isNotEmpty();
        assertThat(foundFlights.get(0).getFlightNumber()).isEqualTo(flightNumberToFind);
    }
}

