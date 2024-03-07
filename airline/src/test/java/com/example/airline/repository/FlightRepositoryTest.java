package com.example.airline.repository;

import com.example.airline.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepo;

    private Flight f1;
    private Flight f2;
    private List<Flight> flightList;

    @BeforeEach
    public void setUp() {
        f1 = new Flight("DL1", 2000);
        flightRepo.save(f1);

        f2 = new Flight("DL2", 4000);
        flightRepo.save(f2);
    }

    @AfterEach
    public void tearDown() {
        flightRepo.deleteAll();
    }

    @Test
    public void findAllTest() {
        flightList = flightRepo.findAll();
        assertEquals(2, flightList.size());
    }

    @Test
    public void validateFlightCreation() {
        flightList = flightRepo.findAll();
        assertEquals("DL2", flightList.get(1).getFlightNumber());
    }

    @Test
    public void findAllByFlightNumber(){
        Flight flight = flightRepo.findByFlightNumber("DL2");
        assertEquals(f2, flight);
    }

    @Test
    public void findByFlightMileageGreaterThan() {
        flightList = flightRepo.findByFlightMileageGreaterThan(500);
        assertEquals(2, flightList.size());
    }

}