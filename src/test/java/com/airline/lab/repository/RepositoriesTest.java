package com.airline.lab.repository;

import com.airline.lab.model.Customer;
import com.airline.lab.model.CustomerStatus;
import com.airline.lab.model.Flight;
import com.airline.lab.model.FlightBooking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RepositoriesTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightBookingRepository flightBookingRepository;


    private List<Customer> customers;
    private List<Flight> flights;
    private List<FlightBooking> flightBookings;

    @BeforeEach
    public void setUp() {
        customers = customerRepository.saveAll(List.of(
                new Customer("Agustine Riviera", CustomerStatus.SILVER,115235),
                new Customer("Alaina Sepulvida",CustomerStatus.None,6008),
                new Customer("Tom Jones",CustomerStatus.GOLD,205767),
                new Customer("Sam Rio",CustomerStatus.None,2653),
                new Customer("Jessica James",CustomerStatus.SILVER,127656),
                new Customer("Ana Janco",CustomerStatus.SILVER,136773),
                new Customer("Ana Janco", CustomerStatus.GOLD,2213465),
                new Customer("Jennifer Cortez",CustomerStatus.GOLD,300582),
                new Customer("Christian Janco",CustomerStatus.SILVER,14642)
        ));

        flights = flightRepository.saveAll(List.of(
                new Flight("DL143","Boeing 747",400,135),
                new Flight("DL122","Airbus A33",236,4370),
                new Flight("DL53","Boeing 777",264,2078),
                new Flight("DL222","Boeing 777",264,1765),
                new Flight("DL37","Boeing 747",400,531)
        ));

    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
        flightRepository.deleteAll();
    }

    // 4. Write tests to verify your ability to create new customers.
    @Test
    void createNewCustomersTest() {
        Customer customer1 = new Customer("Agustine Riviera", CustomerStatus.SILVER,115235);
        assertEquals("Agustine Riviera",customer1.getCustomerName());
        assertEquals(CustomerStatus.SILVER,customer1.getCustomerStatus());
        assertEquals(115235,customer1.getTotalCustomerMileage());
    }

    // 5. Write tests to verify your ability to create new flights.
    @Test
    void createNewFlightsTest() {
        Flight flight1 = new Flight("DL143","Boeing 747",400,135);
        assertEquals(0,flight1.getFlightId());
        assertEquals("DL143",flight1.getFlightNumber());
        assertEquals("Boeing 747",flight1.getAircraft());
        assertEquals(400,flight1.getTotalAircraftSeats());
        assertEquals(135,flight1.getFlightMileage());
    }

    // 6. Write tests to verify your ability to find customers by name.
    @Test
    void findCustomersByNameTest() {
        List<Customer> customersResult1 = customerRepository.findAllByCustomerName("Tom Jones");
        assertEquals(1, customersResult1.size());
        assertEquals("Tom Jones", customersResult1.get(0).getCustomerName());
        assertEquals(CustomerStatus.GOLD, customersResult1.get(0).getCustomerStatus());
        assertEquals(205767, customersResult1.get(0).getTotalCustomerMileage());

        List<Customer> customersResult2 = customerRepository.findAllByCustomerName("Ana Janco");
        assertEquals(2, customersResult2.size());
    }

    // 7. Write tests to verify your ability to find customers by status.
    @Test
    void findCustomersByStatusTest() {
        List<Customer> customerResult = customerRepository.findAllByCustomerStatus(CustomerStatus.None);
        assertEquals(2,customerResult.size());
    }

    // 8. Write tests to verify your ability to find flights by flight number.
    @Test
    void findFlightByFlightNumberTest() {
        List<Flight> flightsResult = flightRepository.findAllByFlightNumber("DL143");
        assertEquals(1,flightsResult.size());
        assertEquals("Boeing 747",flightsResult.get(0).getAircraft());
        assertEquals(400,flightsResult.get(0).getTotalAircraftSeats());
        assertEquals(135,flightsResult.get(0).getFlightMileage());
    }

    // 9. Write tests to verify your ability to find aircraft with names containing "Boeing".
    @Test
    void findAircraftByNameLikeTest() {
        List<Flight> flightsResult = flightRepository.findAllByAircraftLike("Boeing");
        assertEquals(4,flightsResult.size());
    }

    // 10. Write tests to verify your ability to find flights with a distance greater than 500 miles.
    @Test
    void findFlightByMileageGreaterThanTest() {
        List<Flight> flightsResult = flightRepository.findAllByFlightMileageGreaterThan(500);
        assertEquals(4,flightsResult.size());
    }
}