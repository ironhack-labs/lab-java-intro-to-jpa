package com.ironhack.labintrotojpa.model;

import com.ironhack.labintrotojpa.Repositories.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//Write tests to verify your ability to create new flights.
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class FlightTest {
    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void whenCreateFlight_thenFlightIsSaved_thenFlightIsPresent(){
        //Given
        Flight flight = new Flight();
        flight.setFlightNumber("123");
        //When
        Flight savedFlight = flightRepository.save(flight);
        //Then
        assertEquals(1, flightRepository.count());


    }

}