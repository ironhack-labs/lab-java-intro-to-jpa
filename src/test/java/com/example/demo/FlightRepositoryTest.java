package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlightRepositoryTest {

        private FlightRepository flightRepository;

        @Test
        public void testCreateNewFlight() {
            // Arrange
            Flight flight = new Flight("DL123", "Boeing 747", 400, 5000);

            // Act
            Flight savedFlight = flightRepository.save(flight);

            // Assert
            assertThat(savedFlight.getFlightId()).isNotNull();
            assertThat(savedFlight.getFlightNumber()).isEqualTo("DL123");
            assertThat(savedFlight.getAircraft()).isEqualTo("Boeing 747");
            assertThat(savedFlight.getTotalAircraftSeats()).isEqualTo(400);
            assertThat(savedFlight.getFlightMileage()).isEqualTo(5000);
        }

        @Test
        public void testFindFlightByFlightNumber() {
            // Arrange
            Flight flight = new Flight("DL123", "Boeing 747", 400, 5000);
            flightRepository.save(flight);

            // Act
            List<Flight> foundFlights = flightRepository.findByFlightNumber("DL123");

            // Assert
            assertThat(foundFlights).isEqualTo(1);
            Flight foundFlight = foundFlights.get(0);
            assertThat(foundFlight.getFlightNumber()).isEqualTo("DL123");
        }

        @Test
        public void testFindAircraftWithNameContainingBoeing() {
            // Arrange
            Flight flight1 = new Flight("DL123", "Boeing 747", 400, 5000);
            Flight flight2 = new Flight("UA789", "Boeing 737", 350, 4000);
            flightRepository.save(flight1);
            flightRepository.save(flight2);

            // Act
            List<Flight> foundFlights = flightRepository.findByAircraftContaining("Boeing");

            // Assert
            assertThat(foundFlights).isEqualTo(2);
            assertThat(foundFlights).extracting("aircraft", "Boeing 747", "Boeing 737");
        }

        @Test
        public void testFindFlightsWithDistanceGreaterThan500Miles() {
            // Arrange
            Flight flight1 = new Flight("DL123", "Boeing 747", 400, 5000);
            Flight flight2 = new Flight("AA456", "Airbus A320", 250, 3000);
            Flight flight3 = new Flight("UA789", "Boeing 737", 350, 400);
            flightRepository.save(flight1);
            flightRepository.save(flight2);
            flightRepository.save(flight3);

            // Act
            List<Flight> foundFlights = flightRepository.findByFlightMileageGreaterThan(500);

            // Assert
            assertThat(foundFlights).isEqualTo(2);

        }
    }

