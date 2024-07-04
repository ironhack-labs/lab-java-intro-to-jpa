/*

package com.ironhack.labjavaintrotojpa.demo;

import com.ironhack.labjavaintrotojpa.Enums.CustomerStatusEnum;
import com.ironhack.labjavaintrotojpa.model.Customer;
import com.ironhack.labjavaintrotojpa.model.Flight;
import com.ironhack.labjavaintrotojpa.model.FlightBooking;
import com.ironhack.labjavaintrotojpa.service.CustomerService;
import com.ironhack.labjavaintrotojpa.service.FlightBookingService;
import com.ironhack.labjavaintrotojpa.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CustomerService customerService;
    private final FlightService flightService;
    private final FlightBookingService flightBookingService;

    @Override
    public void run(String... args) throws Exception {

        customerService.saveAll(List.of(
                new Customer("Agustine Riviera", CustomerStatusEnum.SILVER, 115235),
                new Customer("Alaina Sepulvida", CustomerStatusEnum.NONE, 6008),
                new Customer("Tom Jones", CustomerStatusEnum.GOLD, 205767),
                new Customer("Sam Rio", CustomerStatusEnum.NONE, 2653),
                new Customer("Jessica James", CustomerStatusEnum.SILVER, 127656),
                new Customer("Ana Janco", CustomerStatusEnum.SILVER, 136773),
                new Customer("Jennifer Cortez", CustomerStatusEnum.GOLD, 300582),
                new Customer("Christian Janco", CustomerStatusEnum.SILVER, 14642)
        ));

        flightService.saveAll(List.of(
                new Flight("DL122", "Airbus A330", 236, 4370),
                new Flight("DL143", "Boeing 747", 400, 135),
                new Flight("DL222", "Boeing 777", 264, 1765),
                new Flight("DL37", "Boeing 747", 400, 531),
                new Flight("DL53", "Boeing 777", 264, 2078)
        ));

        flightBookingService.saveAll(List.of(
                new FlightBooking(customerService.findById(1), flightService.findById(2)),
                new FlightBooking(customerService.findById(1), flightService.findById(1)),
                new FlightBooking(customerService.findById(2), flightService.findById(1)),
                new FlightBooking(customerService.findById(3), flightService.findById(1)),
                new FlightBooking(customerService.findById(3), flightService.findById(5)),
                new FlightBooking(customerService.findById(4), flightService.findById(2)),
                new FlightBooking(customerService.findById(3), flightService.findById(3)),
                new FlightBooking(customerService.findById(5), flightService.findById(2)),
                new FlightBooking(customerService.findById(6), flightService.findById(3)),
                new FlightBooking(customerService.findById(7), flightService.findById(3)),
                new FlightBooking(customerService.findById(5), flightService.findById(1)),
                new FlightBooking(customerService.findById(4), flightService.findById(4)),
                new FlightBooking(customerService.findById(8), flightService.findById(3))
        ));

    }
}

*/