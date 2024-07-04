package com.ironhack.labjavaintrotojpa.service;

import com.ironhack.labjavaintrotojpa.model.Flight;
import com.ironhack.labjavaintrotojpa.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightService {

    private final FlightRepository flightRepository;

    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    public void saveAll(List<Flight> flights) {
        flightRepository.saveAll(flights);
    }

    public void deleteAll() {
        flightRepository.deleteAll();
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Flight findById(int id) {
        return flightRepository.findById(id).orElseThrow();
    }

    public Flight findByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumberIgnoreCase(flightNumber).orElseThrow();
    }

    public List<Flight> findBoeingFlights() {
        return flightRepository.findByAircraftContainingIgnoreCase("boeing");
    }

    public List<Flight> findFlightsWithOver500Mileage() {
        return flightRepository.findByFlightMileageGreaterThan(500);
    }
}
