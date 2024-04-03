package com.ironhack.repository;

import com.ironhack.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    FlightRepository flightRepository;

    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
    }

    @Test
    @DisplayName("Should create a flight")
    void TestCreateFlight(){
        flightRepository.save(new Flight("123AA", "AC111", 80, 20200));

        assertEquals(1, flightRepository.findAll().size());
    }

    @Test
    @DisplayName("Should create two flights")
    void TestCreateFlights(){
        flightRepository.save(new Flight("123AA", "AC111", 80, 20200));
        flightRepository.save(new Flight("123BB", "AC111", 80, 10200));

        assertEquals(2, flightRepository.findAll().size());
    }

    @Test
    @DisplayName("Should find flights by number")
    void TestFindFlightByNumber(){
        flightRepository.save(new Flight("123AA", "AC111", 80, 20200));
        flightRepository.save(new Flight("123BB", "AC111", 80, 10200));

        assertEquals(1, flightRepository.findAllByFlightNumber("123BB").size());
    }

    @Test
    @DisplayName("Should find flights by flight mileage greater than a specific value")
    void TestFindFlightByFlightMileage(){
        flightRepository.save(new Flight("123AA", "AC111", 80, 20200));
        flightRepository.save(new Flight("123BB", "AC111", 80, 10200));

        assertEquals(2, flightRepository.findByFlightMileageGreaterThan(500).size());
    }

    @Test
    @DisplayName("Should find flights with aircraft name like a specific value")
    void TestFindByAircraftLike(){
        flightRepository.save(new Flight("123AA", "Boeing1", 80, 20200));
        flightRepository.save(new Flight("123BB", "Boeing2", 80, 10200));

        assertEquals(2, flightRepository.findByAircraftContaining("Boeing").size());
    }

    @Test
    void findByCustomerId() {
    }

    @Test
    void findByFlightId() {
    }
}