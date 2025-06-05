package com.ironhack.iabjpa.controlller;


import com.ironhack.iabjpa.model.FlightBooking;
import com.ironhack.iabjpa.service.SpringJpaLab7Application;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class FlightBookingController {

    private FlightBookingService flightBookingService;

    @PostMapping
    public FlightBooking createBooking(@RequestBody FlightBooking booking) {
        return flightBookingService.createBooking(booking);
    }
    @GetMapping
    public List<FlightBooking> getAllBookings() {
        return flightBookingService.findAllBookings();
    }
    @GetMapping("/{customerId}")
    public List<FlightBooking> getBookingByCustomerId(@PathVariable Long customerId) {
        return flightBookingService.findBookingByCustomerId(Math.toIntExact(customerId));
    }
    @PutMapping("/search/{flightId}")
    public List<FlightBooking> getBookingsByFlightId(@PathVariable Long flightId) {
        return flightBookingService.findBookingByFlightId(Math.toIntExact(flightId));
    }
    @DeleteMapping("/search/{bookings}")
    public void deleteBooking(@PathVariable Integer bookingId) {
        flightBookingService.deleteBookingById(bookingId);
    }
}
