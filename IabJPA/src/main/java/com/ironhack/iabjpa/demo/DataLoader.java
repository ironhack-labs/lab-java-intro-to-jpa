package com.ironhack.iabjpa.demo;

import com.ironhack.iabjpa.model.CustomerStatus;
import com.ironhack.iabjpa.model.Customer;
import com.ironhack.iabjpa.model.Flight;
import com.ironhack.iabjpa.repository.CustomerRepository;
import com.ironhack.iabjpa.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final FlightRepository flightRepository;

    public DataLoader(CustomerRepository customerRepository, FlightRepository flightRepository) {
        this.customerRepository = customerRepository;
        this.flightRepository = flightRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Customer customer1 = new Customer("Agustine Riviera", String.valueOf(CustomerStatus.SILVER), 115235);
        Customer customer2 = new Customer("Alaina Sepulvida", String.valueOf(CustomerStatus.NONE), 6008);
        Customer customer3 = new Customer("Tom Jones", String.valueOf(CustomerStatus.GOLD), 205767);
        Customer customer4 = new Customer("Sam Rio", String.valueOf(CustomerStatus.NONE), 2653);
        Customer customer5 = new Customer("Jessica James", String.valueOf(CustomerStatus.SILVER), 127656);
        Customer customer6 = new Customer("Ana Janco", String.valueOf(CustomerStatus.SILVER), 136773);
        Customer customer7 = new Customer("Jennifer Cortez", String.valueOf(CustomerStatus.GOLD), 300582);
        Customer customer8 = new Customer("Christian Janco", String.valueOf(CustomerStatus.SILVER), 14642);
        customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8));
        customerRepository.findAll().forEach(System.out::println);


        Flight flight1 = new Flight("AA123", "Boeing 737", 150, 1200);
        Flight flight2 = new Flight("DL456", "Airbus A320", 160, 900);

        flightRepository.saveAll(List.of(flight1, flight2));
        flightRepository.findAll().forEach(System.out::println);
    }
}
