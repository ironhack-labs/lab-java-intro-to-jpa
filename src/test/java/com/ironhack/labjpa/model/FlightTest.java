package com.ironhack.labjpa.model;

import com.ironhack.labjpa.Repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class FlightTest {
    @Autowired
    private FlightRepository flightRepository;
    @Test
    public void whenCreatingFlight_thenFlightIsSaved_thenFlightIsPresent(){
        //Given
        Flight flight = new Flight();
        flight.setFlightNumber("123");
        //When
        Flight savedFlight = flightRepository.save(flight);
        //Then
        assertEquals(1, flightRepository.count());

    }

}