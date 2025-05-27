package com.ironhack.LAB.Java.Intro.to.JPA.repository;


import com.ironhack.LAB.Java.Intro.to.JPA.model.FlightBooking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class FlightBookingRepositoryTest {
    @Autowired
    FlightBookingRepository flightBookingRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    FlightRepository flightRepository;

    @Test
    public void createBooking() {
        FlightBooking flightBooking = new FlightBooking(23, 45);
        flightBookingRepository.save(flightBooking);
    }

}