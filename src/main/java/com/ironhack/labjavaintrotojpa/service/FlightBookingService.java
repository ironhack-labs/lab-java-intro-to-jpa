package com.ironhack.labjavaintrotojpa.service;

import com.ironhack.labjavaintrotojpa.model.FlightBooking;
import com.ironhack.labjavaintrotojpa.repository.FlightBookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightBookingService {

    private final FlightBookingRepository flightBookingRepository;

    public void saveAll(List<FlightBooking> flightBookings) {
        flightBookingRepository.saveAll(flightBookings);
    }

    public FlightBooking findById(int id) {
        return flightBookingRepository.findById(id).orElseThrow();
    }

}
