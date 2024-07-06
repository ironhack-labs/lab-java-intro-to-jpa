package com.ironhack.springjpalab7.service;


import com.ironhack.springjpalab7.model.FlightBooking;
import com.ironhack.springjpalab7.repository.FlightBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightBookingService {

    @Autowired
    private final FlightBookingRepository flightBookingRepository;

    public FlightBookingService(FlightBookingRepository flightBookingRepository) {
        this.flightBookingRepository = flightBookingRepository;
    }

    public FlightBooking createBooking(FlightBooking booking) {
        return flightBookingRepository.save(booking);
    }
    public List<FlightBooking> findAllBookings() {
        return flightBookingRepository.findAll();
    }
    public List<FlightBooking> findBookingByCustomerId(Integer customerId) {
        return flightBookingRepository.findByCustomerId(customerId);
    }
    public List<FlightBooking> findBookingByFlightId(Integer flightId) {
        return flightBookingRepository.findByFlightId(flightId);
    }
    public void deleteBookingById(Integer id) {
        flightBookingRepository.deleteById(id);
    }

}
