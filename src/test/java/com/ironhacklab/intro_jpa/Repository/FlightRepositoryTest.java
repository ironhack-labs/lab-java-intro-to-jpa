package com.ironhacklab.intro_jpa.Repository;

import com.ironhacklab.intro_jpa.Model.Customer;
import com.ironhacklab.intro_jpa.Model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;
    private Flight flight;

    private Flight dummyFlight;

    private UUID flightNumber;
    private UUID dummyFlightUUID;
    @BeforeEach
    void setUp() {
            flightNumber = UUID.randomUUID();
            dummyFlightUUID = UUID.randomUUID();
            flight = new Flight(1, flightNumber, "Boeing", 130, 150 );
            dummyFlight = new Flight(2, dummyFlightUUID, "Boeing", 130, 150 );
            flightRepository.save(flight);
    }

    @AfterEach
    void tearDown() {

    }



    @Test
    void getFlightByFlightNumber(){
        Flight flightFound = flightRepository.findOneByFlightNumber(flightNumber);
        assertEquals(flight, flightFound);
    }
    @Test
    void getFlightByAircraftName() {
        List<Flight> flightFound = flightRepository.findByAircraft("Boeing");
        assertEquals(1, flightFound.size());
    }

    @Test
    void getFlightWithMileageGreatestThan500(){
        List<Flight> flightFound = flightRepository.findByFlightMileageGreaterThan(120);
        assertEquals(1,flightFound.size());
    }

    @Test
    void shouldWeCreateNewCustomer(){
        flightRepository.save(dummyFlight);
        Flight flightCreated = flightRepository.findOneByFlightNumber(dummyFlightUUID);
        assertEquals(dummyFlight, flightCreated);
    }
}