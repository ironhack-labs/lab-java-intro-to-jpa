package com.ironhack.repository;

import com.ironhack.model.Customer;
import com.ironhack.model.CustomerStatus;
import com.ironhack.model.Flight;
import com.ironhack.model.FlightBooking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightBookingRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightBookingRepository flightBookingRepository;

    Customer customer1;
    Customer customer2;
    Flight flight1;
    Flight flight2;

    @BeforeEach
    void setUp() {
        customer1 = new Customer("customer1", CustomerStatus.GOLD, 10500);
        customerRepository.save(customer1);

        customer2 = new Customer("customer2", CustomerStatus.SILVER, 5500);
        customerRepository.save(customer2);

        flight1 = new Flight("123AA", "AC111", 80, 20200);
        flightRepository.save(flight1);

        flight2 = new Flight("123BB", "AC111", 80, 10200);
        flightRepository.save(flight2);
    }

    @AfterEach
    void tearDown() {
        flightBookingRepository.deleteAll();
    }

    @Test
    void findByCustomerId() {
        flightBookingRepository.save(new FlightBooking(customer1, flight1));

        assertEquals(1, flightBookingRepository.findAllByCustomerId(customer1).size());
    }

    @Test
    void findByFlightId() {
        flightBookingRepository.save(new FlightBooking(customer1, flight1));

        assertEquals(1, flightBookingRepository.findAllByFlightId(flight1).size());
    }

}