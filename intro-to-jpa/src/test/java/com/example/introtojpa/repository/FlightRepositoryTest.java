package com.example.introtojpa.repository;

import com.example.introtojpa.CustomerStatus;
import com.example.introtojpa.model.Customer;
import com.example.introtojpa.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;
    private Flight flight;
    private Flight flight1;
    private Flight flight2;
    private Flight flight3;

    @BeforeEach
    void setUp() {
        flight = new Flight("C05","Boeing 747",105, 100);
        flight1 = new Flight("C06","Boeing 777",205, 100);
        flight2 = new Flight("C07","Airbus 3000",205, 5700);
        flight3 = new Flight("C08","Airbus 2000",50, 200);
        flightRepository.save(flight);
        flightRepository.save(flight1);
        flightRepository.save(flight2);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
    }

    @Test
    public void CreateNewFlight(){
        flightRepository.save(flight3);
        Optional<Flight> flightRepo = flightRepository.findById(flight3.getFlightId());
        assertTrue(flightRepo.isPresent());
        assertEquals(flight3.getFlightId(),flightRepo.get().getFlightId());
    }

    @Test
    public void FindFlightByFlightNumber(){
        Optional<Flight> findFlight = flightRepository.findByFlightNumber("C05");
        assertEquals(flight.getFlightId(),findFlight.get().getFlightId());

    }

    @Test
    public void FindAllFlightsByNameContaining(){
        List<Flight> findFlight = flightRepository.findAllByAircraftContains("Boeing");
        assertEquals(flight.getFlightId(),findFlight.get(0).getFlightId());
        assertEquals(flight1.getFlightId(),findFlight.get(1).getFlightId());
    }

    @Test
    public void FindAllFlightsGreatherThan(){
        List<Flight> findFlight = flightRepository.findAllByFlightMileageGreaterThan(500);
        assertEquals(flight2.getFlightId(),findFlight.get(0).getFlightId());
    }

}