package com.ironhack.labjavaintrotojpa.service;

import com.ironhack.labjavaintrotojpa.model.Flight;
import com.ironhack.labjavaintrotojpa.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() { return flightRepository.findAll(); }

    public Flight addNewFlight(Flight flight) {return flightRepository.save(flight); }
}
