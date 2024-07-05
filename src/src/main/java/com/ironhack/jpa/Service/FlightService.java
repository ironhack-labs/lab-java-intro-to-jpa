package com.ironhack.jpa.Service;


import com.ironhack.jpa.Model.Flight;
import com.ironhack.jpa.Repository.FlightRepository;
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
    public List<Flight> getFlightsByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }
    public List<Flight> getFlightsByAircraftContaining(String aircraft) {
        return flightRepository.findByAircraftContaining(aircraft);
    }
    public List<Flight> getFlightsByMileageGreaterThan(Integer mileage) {
        return flightRepository.findByFlightMileageGreaterThan(mileage);
    }
}
