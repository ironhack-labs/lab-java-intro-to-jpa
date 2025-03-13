package com.ironhack.lab.repository;

import com.ironhack.lab.model.Customer;
import com.ironhack.lab.model.CustomerStatus;
import com.ironhack.lab.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IFlightRepositoryTest {
    @Autowired
    IFlightRepository iFlightRepository;

    Flight flight = new Flight("DL143","Boeing 747",400,135);

    @BeforeEach
    void setUp(){
        iFlightRepository.save(flight);
    }

    @AfterEach
    void tearDown(){
        iFlightRepository.delete(flight);
    }

    @Test
    void thereAreOneMoreFlight_isTrue(){
        System.out.println(iFlightRepository.findAll().size());

        assertEquals(4,iFlightRepository.findAll().size());
    }

    @Test
    void findFlight_valueNumberFlight(){
        List<Flight> flightList = iFlightRepository.findByFlightNumber("DL143");
        assertEquals(3,flightList.size());
        IFlightRepository.equals(flight,flightList.get(0));
    }

    @Test
    void findAircraftContainsBoeing(){
        List<Flight> flightList = iFlightRepository.findByAircraftContaining("Boeing");
        assertEquals(4,flightList.size());
    }

    @Test
    void findFligthsGreaterThan500_valueNumber_isTrue(){
        List<Flight> flightList = iFlightRepository.findByFlightMileageGreaterThan(500);
        assertEquals(1,flightList.size());
    }


}