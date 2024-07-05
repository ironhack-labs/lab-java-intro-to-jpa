package com.ironhack.jpa.Controller;



import com.ironhack.jpa.Model.Customer;
import com.ironhack.jpa.Model.CustomerStatus;
import com.ironhack.jpa.Model.Flight;
import com.ironhack.jpa.Model.FlightBooking;
import com.ironhack.jpa.Service.CustomerService;
import com.ironhack.jpa.Service.FlightBookingService;
import com.ironhack.jpa.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightBookingService flightBookingService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllStudents();
    }
    @GetMapping("/customerName")
    public List<Customer> getCustomersByName(@RequestParam String name) {
        return customerService.getCustomersByName(name);
    }
    @GetMapping("/customers/by-status")
    public List<Customer> getCustomersByStatus(@RequestParam CustomerStatus status) {
        return customerService.getCustomersByStatus(status);
    }
    @PostMapping("/customer")
    public Customer addNewCustomer(@RequestBody Customer student) {
        return customerService.addNewCustomer(student);
    }
    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/flights/by-flight-number")
    public List<Flight> getFlightsByFlightNumber(@RequestParam String flightNumber) {
        return flightService.getFlightsByFlightNumber(flightNumber);
    }
    @PostMapping("/flight")
    public Flight addNewFlight(@RequestBody Flight flight) {
        return flightService.addNewFlight(flight);
    }
    @GetMapping("/flightBookings")
    public List<FlightBooking> getAllFlightBookings() {
        return flightBookingService.getAllFlightBookings();
    }

    @PostMapping("/flightBooking")
    public FlightBooking addNewFlightBookinng(@RequestBody FlightBooking flight) {
        return flightBookingService.addNewFlightBooking(flight);
    }
    @GetMapping("/flights/by-aircraft")
    public List<Flight> getFlightsByAircraftContaining(@RequestParam String aircraft) {
        return flightService.getFlightsByAircraftContaining(aircraft);
    }
    @GetMapping("/flights/by-mileage")
    public List<Flight> getFlightsByMileageGreaterThan(@RequestParam Integer mileage) {
        return flightService.getFlightsByMileageGreaterThan(mileage);
    }
}
