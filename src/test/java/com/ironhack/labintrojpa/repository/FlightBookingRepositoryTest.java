package com.ironhack.labintrojpa.repository;

import com.ironhack.labintrojpa.model.FlightBooking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightBookingRepositoryTest {

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @BeforeEach
    void setUp() {
        List<FlightBooking> flightBookings = List.of(
                new FlightBooking(1, 1),
                new FlightBooking(1, 2),
                new FlightBooking(2, 3)
        );
        flightBookingRepository.saveAll(flightBookings);

        // Verificar que los elementos se han guardado correctamente
        List<FlightBooking> savedBookings = flightBookingRepository.findAll();
        System.out.println("Elementos guardados: " + savedBookings.size());

    }

    @AfterEach
    void afterEach() {
        flightBookingRepository.deleteAll();
    }

    @Test
    public void testFindFlightBookingsByCustomerId() {
        List<FlightBooking> flightBookings = flightBookingRepository.findByCustomerId(1);
        assertEquals(2, flightBookings.size());
        assertEquals(1, flightBookings.get(0).getCustomerId());
        assertEquals(1, flightBookings.get(1).getCustomerId());
    }

    @Test
    @Transactional
    public void testDeleteFlightBookingsByCustomerId() {
        var ad = flightBookingRepository.findAll();
        flightBookingRepository.deleteByCustomerId(1);

        // Verify that flight bookings for customer 1 are deleted
        Optional<FlightBooking> deletedFlightBookings = flightBookingRepository.findById(1);
        assertTrue(deletedFlightBookings.isEmpty());

        // Verify that flight bookings for customer 2 are not deleted
        Optional<FlightBooking> remainingbookins = flightBookingRepository.findById(2);
        assertTrue(!remainingbookins.isPresent());
    }

}