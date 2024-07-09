package com.example.tests;

import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FlightRepositoryTests {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void createNewFlight() {
        Flight flight = new Flight();
        flight.setFlightNumber("AA155");
        flight.setAircraftName("Boeing 737");
        flight.setDistance(500.0);
        flight = flightRepository.save(flight);
        assertThat(flight.getId()).isNotNull();
    }

    @Test
    public void findFlightByFlightNumber() {
        List<Flight> flights = flightRepository.findByFlightNumber("AA155");
        assertThat(flights).isNotEmpty();
    }

    @Test
    public void findAircraftWithNameContainingBoeing() {
        List<Flight> flights = flightRepository.findByAircraftNameContaining("Boeing");
        assertThat(flights).isNotEmpty();
    }

    @Test
    public void findFlightsWithDistanceGreaterThan500Miles() {
        List<Flight> flights = flightRepository.findByDistanceGreaterThan(500.0);
        assertThat(flights).isNotEmpty();
    }
}

