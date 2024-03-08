package com.example.labjavaintrotojpa.service;

import com.example.labjavaintrotojpa.model.Customer;
import com.example.labjavaintrotojpa.model.Flight;
import com.example.labjavaintrotojpa.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight createNewFlight(String flightNumber, String aircraft, Integer totalAircraftSeats, Integer flightMileage){
        Flight flight=new Flight(flightNumber, aircraft, totalAircraftSeats, flightMileage);
        return flightRepository.save(flight);
    }

    public Flight findFlightByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }

    public List <Flight> findFlightByAircraft(String aircraft) {
        return flightRepository.findByAircraftContaining(aircraft);
    }

    public List<Flight> findFlightByMileageGreaterThan(int mileage){
        return flightRepository.findByFlightMileageGreaterThan(mileage);
    }
}
