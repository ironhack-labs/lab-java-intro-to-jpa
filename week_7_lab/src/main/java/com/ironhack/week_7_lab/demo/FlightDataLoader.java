package com.ironhack.week_7_lab.demo;


import com.ironhack.week_7_lab.model.Flight;
import com.ironhack.week_7_lab.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlightDataLoader implements CommandLineRunner {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create and save flights
        Flight flight1 = new Flight("DL143", "Boeing 747", 400, 135);
        Flight flight2 = new Flight("DL122", "Airbus A330", 236, 4370);
        Flight flight3 = new Flight("DL53", "Boeing 777", 264, 2078);
        Flight flight4 = new Flight("DL222", "Boeing 777", 264, 1765);
        Flight flight5 = new Flight("DL37", "Boeing 747", 400, 531);

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        flightRepository.save(flight4);
        flightRepository.save(flight5);
    }
}
