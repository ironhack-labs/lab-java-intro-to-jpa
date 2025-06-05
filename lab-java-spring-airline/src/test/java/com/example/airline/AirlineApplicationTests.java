@SpringBootTest
public class AirlineApplicationTests {

    @Autowired CustomerRepository customerRepository;
    @Autowired FlightRepository flightRepository;

    @Test
    void createCustomer() {
        Customer c = new Customer("Mabel", CustomerStatus.GOLD, 10000);
        customerRepository.save(c);
        Assertions.assertNotNull(c.getCustomerId());
    }

    @Test
    void findByCustomerName() {
        customerRepository.save(new Customer("Nico", CustomerStatus.SILVER, 2000));
        List<Customer> result = customerRepository.findByCustomerName("Nico");
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void findByAircraftContainingBoeing() {
        flightRepository.save(new Flight("BA321", "Boeing 737", 180, 600));
        List<Flight> boeings = flightRepository.findByAircraftContaining("Boeing");
        Assertions.assertFalse(boeings.isEmpty());
    }

    @Test
    void findFlightsOver500Miles() {
        flightRepository.save(new Flight("IB123", "Airbus A320", 200, 800));
        List<Flight> result = flightRepository.findByFlightMileageGreaterThan(500);
        Assertions.assertFalse(result.isEmpty());
    }
}
