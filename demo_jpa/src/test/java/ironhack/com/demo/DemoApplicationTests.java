package ironhack.com.demo;

import ironhack.com.demo.model.Customer;
import ironhack.com.demo.model.CustomerStatus;
import ironhack.com.demo.model.Flight;
import ironhack.com.demo.repository.CustomerRepository;
import ironhack.com.demo.repository.FlightRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CustomerTest {
	@Autowired
	private CustomerRepository customerRepository;
	Customer customer_sample;
	Customer customer_sample2;
	Customer customer_sample3;


	@BeforeEach
	void setUp(){
		customer_sample= new Customer("Jon", CustomerStatus.Gold,1000);
		customerRepository.save(customer_sample);

		customer_sample2= new Customer("Emily", CustomerStatus.None,1500);
		customerRepository.save(customer_sample2);

		customer_sample3= new Customer("Ana", CustomerStatus.Silver,1500);
		customerRepository.save(customer_sample3);

	}
	@Test
	public void test_find_customer_by_name(){

		Optional<Customer> readCustomerDb = customerRepository.findFirstByCustomerName("Jon");
		assertTrue(readCustomerDb.isPresent());
		assertEquals(customer_sample,readCustomerDb.get());
	}
	@Test
	public void test_create_new_customer(){
		List<Customer> readCustomerDb = customerRepository.findAll();

		assertEquals(3,readCustomerDb.size());

	}

	@Test
	public void test_find_customers_by_status(){
		CustomerStatus[] statuses= CustomerStatus.values();
		for(CustomerStatus test_status: statuses) {
			List<Customer> customersByStatus = customerRepository.findByCustomerStatus(test_status);
			for (Customer customer : customersByStatus) {
				assertEquals(customer.getCustomerStatus(), test_status);
			}
		}
	}

	@AfterEach
	void tearDown(){
		customerRepository.deleteAll();
	}

}

@SpringBootTest
class FlightTests{

	Flight flight_sample;
	Flight flight_sample2;
	Flight flight_sample3;

	@Autowired
	private FlightRepository flightRepository;

	@BeforeEach
	void setUp(){
		List<Flight> flights = new ArrayList<>();
		flight_sample= new Flight("LC100","Boeing 222",200,1450);
		flights.add(flight_sample);
		flight_sample2= new Flight("LC200","Boeing 333",3000,2450);
		flights.add(flight_sample2);
		flight_sample3= new Flight("LC300","Boeing 333",4000,3450);
		flights.add(flight_sample3);
		flightRepository.saveAll(flights);
	}
	@Test
	public void test_flight_by_number(){
		Optional<Flight> flight_db = flightRepository.findFirstByFlightNumber(flight_sample.getFlightNumber());
		assertTrue(flight_db.isPresent());
		assertEquals(flight_db.get(),flight_sample);

	}

	@Test
	public void test_find_boeing_aircraft(){

		List<Flight> flight_dv = flightRepository.findByAircraftContaining("Boeing");

		for(int i=0; i<=flight_dv.size()-1;i++){
			String aircraft_name_db= flight_dv.get(i).getAircraft();
			assertTrue(aircraft_name_db.contains("Boeing"));
		}

	}

	@Test
	public void test_find_flight_long_distance(){

		List<Flight> flight_dv = flightRepository.findByFlightMileageGreaterThan(500);

		for(int i=0; i<=flight_dv.size()-1;i++){
			int aircraft_mileage_db= flight_dv.get(i).getFlightMileage();
			assertTrue(aircraft_mileage_db>500);
		}

	}

	@AfterEach
	void tearDown(){
		flightRepository.deleteAll();
	}
}

@SpringBootTest
class Aircraft{
	//	Write tests to verify your ability to find aircraft with names containing "Boeing".

}


