package com.ironhack.jpa.Service;

import com.ironhack.jpa.Model.Flight;
import com.ironhack.jpa.Model.FlightBooking;
import com.ironhack.jpa.Repository.FlightBookingRepository;
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
