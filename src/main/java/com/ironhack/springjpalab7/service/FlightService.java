package com.ironhack.springjpalab7.service;


import com.ironhack.springjpalab7.model.Flight;
import com.ironhack.springjpalab7.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {


    private final FlightRepository flightRepository;

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }
     public Optional<Flight> findFlightById(Integer flightId) {
        return flightRepository.findById(flightId);
     }
    public List<Flight> findByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }
    public List<Flight> findByFlightMileage(Integer flightMileage) {
        return flightRepository.findByFlightMileage(flightMileage);
    }
    public List<Flight> findByAircraft(String aircraft) {
        return flightRepository.findByAircraft(aircraft);
    }
    public void deleteFlight(Integer FlightId) {
        flightRepository.deleteById(FlightId);

    }
}
