package com.ironhack.labjavaintrotojpa.service;

import com.ironhack.labjavaintrotojpa.model.Customer;
import com.ironhack.labjavaintrotojpa.model.FlightBooking;
import com.ironhack.labjavaintrotojpa.repository.CustomerRepository;
import com.ironhack.labjavaintrotojpa.repository.FlightBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightBookingService {

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    public List<FlightBooking> getAllFlightBookings() {
        return flightBookingRepository.findAll();
    }

    public FlightBooking addNewFlightBooking(FlightBooking flightBooking) {
        return flightBookingRepository.save(flightBooking);
    }

}
