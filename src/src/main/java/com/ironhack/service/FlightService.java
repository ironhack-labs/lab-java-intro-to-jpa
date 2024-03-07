package com.ironhack.service;

import com.ironhack.model.Flight;
import com.ironhack.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight addNewFlight(Flight flight) {
        return flightRepository.save(flight);
    }
}

