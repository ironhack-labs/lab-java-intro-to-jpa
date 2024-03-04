package org.example;

import org.example.Model.Flight;
import org.example.Repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateNewFlight() {
        // Given
        Flight flight = new Flight();
        flight.setFlightNumber("FL123");
        flight.setAircraft("Boeing 747");
        flight.setTotalAircraftSeats(366);
        flight.setFlightMileage(525);

        // When
        Flight savedFlight = flightRepository.save(flight);

        // Then
        assertThat(savedFlight).isNotNull();
        assertThat(savedFlight.getFlightNumber()).isEqualTo("FL123");
        assertThat(savedFlight.getAircraft()).isEqualTo("Boeing 747");
        assertThat(savedFlight.getTotalAircraftSeats()).isEqualTo(366);
        assertThat(savedFlight.getFlightMileage()).isEqualTo(525);

        //Cleanup (optional step to clean the test data after test execution)
        flightRepository.delete(savedFlight);
    }
}
