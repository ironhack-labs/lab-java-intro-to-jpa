package com.example.labjavaintrotojpa.service;

import com.example.labjavaintrotojpa.model.Customer;
import com.example.labjavaintrotojpa.model.CustomerStatus;
import com.example.labjavaintrotojpa.model.Flight;
import com.example.labjavaintrotojpa.repository.CustomerRepository;
import com.example.labjavaintrotojpa.repository.FlightRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class FlightServiceTest {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    @Mock
    private FlightRepository flightRepositoryMocked;

    @InjectMocks
    private FlightService flightServiceMocked;

    @Test
    @DisplayName("Create new Flight")
    void createNewFlight() {

        when(flightRepositoryMocked.save(any(Flight.class))).thenAnswer(invocation -> {
            Flight flight = invocation.getArgument(0);
            flight.setFlightId(99);
            return flight;
        });

        String flightNumber = "DL143";
        String aircraft = "Boeing 747";
        Integer totalAircraftSeats = 400;
        Integer flightMileage = 135;

        Flight createdFlight = flightServiceMocked.createNewFlight(flightNumber,aircraft,totalAircraftSeats,flightMileage);

        assertEquals(flightNumber, createdFlight.getFlightNumber());
        assertEquals(aircraft, createdFlight.getAircraft());
        assertEquals(totalAircraftSeats, createdFlight.getTotalAircraftSeats());
        assertEquals(flightMileage, createdFlight.getFlightMileage());

        verify(flightRepositoryMocked, times(1)).save(any(Flight.class));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Boeing"})
    @DisplayName("Search aircraft by name")
    void searchAircraftByName(String aircraft) {

        List<Flight> flights = flightService.findFlightByAircraft(aircraft);

        assertEquals(3, flights.size());
    }

    @ParameterizedTest
    @ValueSource(ints  = {500})
    @DisplayName("Search aircraft by name")
    void searchFlightsByMiles(Integer flightMileage) {

        List<Flight> flights = flightService.findFlightByMileageGreaterThan(flightMileage);

        assertEquals(3, flights.size());
    }



}