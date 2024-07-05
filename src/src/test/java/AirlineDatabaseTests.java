import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.ironhack.jpa.Model.Customer;
import com.ironhack.jpa.Model.CustomerStatus;
import com.ironhack.jpa.Model.Flight;
import com.ironhack.jpa.Repository.CustomerRepository;
import com.ironhack.jpa.Repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AirlineDatabaseTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateNewCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.GOLD, 12000);
        Customer savedCustomer = customerRepository.save(customer);
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerId()).isNotNull();
    }

    @Test
    public void testCreateNewFlight() {
        Flight flight = new Flight("AA123", "Boeing 747", 300, 600);
        Flight savedFlight = flightRepository.save(flight);
        assertThat(savedFlight).isNotNull();
        assertThat(savedFlight.getFlightId()).isNotNull();
    }

    @Test
    public void testFindCustomerByName() {
        Customer customer = new Customer("Jane Smith", CustomerStatus.SILVER, 5000);
        customerRepository.save(customer);

        List<Customer> foundCustomers = customerRepository.findByCustomerName("Jane Smith");
        assertThat(foundCustomers).isNotEmpty();
        assertThat(foundCustomers.get(0).getCustomerName()).isEqualTo("Jane Smith");
    }

    @Test
    public void testFindCustomerByStatus() {
        Customer customer = new Customer("Mark Brown", CustomerStatus.NONE, 1000);
        customerRepository.save(customer);

        List<Customer> foundCustomers = customerRepository.findByCustomerStatus(CustomerStatus.NONE);
        assertThat(foundCustomers).isNotEmpty();
        assertThat(foundCustomers.get(0).getCustomerStatus()).isEqualTo(CustomerStatus.NONE);
    }

    @Test
    public void testFindFlightByFlightNumber() {
        Flight flight = new Flight("BA456", "Airbus A320", 180, 700);
        flightRepository.save(flight);

        List<Flight> foundFlights = flightRepository.findByFlightNumber("BA456");
        assertThat(foundFlights).isNotEmpty();
        assertThat(foundFlights.get(0).getFlightNumber()).isEqualTo("BA456");
    }

    @Test
    public void testFindAircraftWithNameContainingBoeing() {
        Flight flight1 = new Flight("UA789", "Boeing 737", 200, 800);
        Flight flight2 = new Flight("UA790", "Airbus A380", 400, 900);
        flightRepository.save(flight1);
        flightRepository.save(flight2);

        List<Flight> foundFlights = flightRepository.findByAircraftContaining("Boeing");
        assertThat(foundFlights).isNotEmpty();
        assertThat(foundFlights.get(0).getAircraft()).contains("Boeing");
    }

    @Test
    public void testFindFlightsWithDistanceGreaterThan500Miles() {
        Flight flight1 = new Flight("DL123", "Boeing 777", 300, 400);
        Flight flight2 = new Flight("DL124", "Airbus A330", 300, 600);
        flightRepository.save(flight1);
        flightRepository.save(flight2);

        List<Flight> foundFlights = flightRepository.findByFlightMileageGreaterThan(500);
        assertThat(foundFlights).isNotEmpty();
        assertThat(foundFlights.get(0).getFlightMileage()).isGreaterThan(500);
    }
}
