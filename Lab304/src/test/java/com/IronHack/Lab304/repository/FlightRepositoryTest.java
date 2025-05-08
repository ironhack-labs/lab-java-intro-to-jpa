package com.IronHack.Lab304.repository;

import static org.junit.jupiter.api.Assertions.*;
import com.IronHack.Lab304.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest

class FlightRepositoryTest {
    @Autowired
    FlightRepository flightRepository;
    Flight flight;

    /*@AfterEach
    public void tearDown(){
        flightRepository.delete(flight66);
    }*/

    @Test
    public void createFlight_newFlight(){
    Flight flight1 = new Flight("DL143","Boeing 747", 400, 3333);
    flightRepository.save(flight1);
        System.out.println(flight1);
        assertTrue(flightRepository.existsById(flight1.getFlightId()));
        System.out.println("Created successfully");
        //Cleanup
        flightRepository.delete(flight1);
        System.out.println("Deleted successfully");

    }

    @Test
    //findAllByFlightNumberContaining
    public void findAllByFlightNumberContaining_flightN_flightListSameFlightNumber() {
        List<Flight> flightList = flightRepository.findAllByFlightNumberContaining("DL53");
        System.out.println(flightList);
        assertEquals(1, flightList.size());
    }

    //

    @Test
    //findAllBoeingFlights
    public void findByAircraftContaining_boeing_correctFlights(){
        List<Flight> boeingFlightList = flightRepository.findByAircraftContaining("Boeing");
        System.out.println(boeingFlightList);
        System.out.println("Boeing flights found");
        assertEquals(4, boeingFlightList.size());
    }

    //Finds flights with over 500 miles
    @Test
    public void findByFlightMileageGreaterThan_500_over500List (){
        List<Flight> flightOver500List = flightRepository.findByFlightMileageGreaterThan(500);
        System.out.println(flightOver500List);
        assertEquals(4, flightOver500List.size());
    }

}