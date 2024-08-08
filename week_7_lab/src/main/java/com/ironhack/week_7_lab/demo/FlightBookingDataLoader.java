package com.ironhack.week_7_lab.demo;

import com.ironhack.week_7_lab.model.Customer;
import com.ironhack.week_7_lab.model.Flight;
import com.ironhack.week_7_lab.model.FlightBooking;
import com.ironhack.week_7_lab.repository.CustomerRepository;
import com.ironhack.week_7_lab.repository.FlightBookingRepository;
import com.ironhack.week_7_lab.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlightBookingDataLoader implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @Override
    public void run(String... args) throws Exception {
        // Fetch existing customers and flights
        Customer customer1 = customerRepository.findById(1).orElseThrow();
        Customer customer2 = customerRepository.findById(2).orElseThrow();
        Customer customer3 = customerRepository.findById(3).orElseThrow();
        Customer customer4 = customerRepository.findById(4).orElseThrow();
        Customer customer5 = customerRepository.findById(5).orElseThrow();

        Flight flight1 = flightRepository.findById(1L).orElseThrow();
        Flight flight2 = flightRepository.findById(2L).orElseThrow();
        Flight flight3 = flightRepository.findById(3L).orElseThrow();
        Flight flight4 = flightRepository.findById(4L).orElseThrow();
        Flight flight5 = flightRepository.findById(5L).orElseThrow();

        // Create and save flight bookings
        FlightBooking booking1 = new FlightBooking(customer1, flight1);
        FlightBooking booking2 = new FlightBooking(customer1, flight2);
        FlightBooking booking3 = new FlightBooking(customer3, flight2);
        FlightBooking booking4 = new FlightBooking(customer3, flight3);
        FlightBooking booking5 = new FlightBooking(customer3, flight4);
        FlightBooking booking6 = new FlightBooking(customer4, flight1);
        FlightBooking booking7 = new FlightBooking(customer4, flight5);
        FlightBooking booking8 = new FlightBooking(customer5, flight1);
        FlightBooking booking9 = new FlightBooking(customer5, flight2);

        flightBookingRepository.save(booking1);
        flightBookingRepository.save(booking2);
        flightBookingRepository.save(booking3);
        flightBookingRepository.save(booking4);
        flightBookingRepository.save(booking5);
        flightBookingRepository.save(booking6);
        flightBookingRepository.save(booking7);
        flightBookingRepository.save(booking8);
        flightBookingRepository.save(booking9);
    }
}

