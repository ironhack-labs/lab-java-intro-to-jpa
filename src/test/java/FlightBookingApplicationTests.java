import org.example.model.Customer;
import org.example.model.CustomerStatus;
import org.example.model.Flight;
import org.example.repository.CustomerRepository;
import org.example.repository.FlightBookingRepository;
import org.example.repository.FlightRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightBookingApplicationTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @Test
    public void testCreateNewCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.Gold, 10000);
        customerRepository.save(customer);
        assertNotNull(customer.getCustomerId());
    }

    @Test
    public void testCreateNewFlight() {
        Flight flight = new Flight("ABC123", "Boeing 737", 150, 1000);
        flightRepository.save(flight);
        assertNotNull(flight.getFlightId());
    }

    @Test
    public void testFindCustomerByName() {
        List<Customer> customers = customerRepository.findByCustomerName("John Doe");
        assertTrue(((List<?>) customers).size() > 0);
    }

    @Test
    public void testFindCustomerByStatus() {
        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.Gold);
        assertTrue(customers.size() > 0);
    }

    @Test
    public void testFindFlightByFlightNumber() {
        List<Flight> flights = flightRepository.findByFlightNumber("ABC123");
        assertTrue(flights.size() > 0);
    }

    @Test
    public void testFindAircraftByNameContaining() {
        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
        assertTrue(flights.size() > 0);
    }

    @Test
    public void testFindFlightsByDistanceGreaterThan() {
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);
        assertTrue(flights.size() > 0);
    }
}