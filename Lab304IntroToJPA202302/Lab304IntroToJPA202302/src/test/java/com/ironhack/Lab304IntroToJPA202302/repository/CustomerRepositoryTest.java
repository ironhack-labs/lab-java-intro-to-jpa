package com.ironhack.Lab304IntroToJPA202302.repository;

import com.ironhack.Lab304IntroToJPA202302.model.Customer;
import com.ironhack.Lab304IntroToJPA202302.model.CustomerStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static com.ironhack.Lab304IntroToJPA202302.model.CustomerStatus.GOLD;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @BeforeEach
    void setUp() {
        flightBookingRepository.deleteAll();
        customerRepository.deleteAll();
    }

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer("Veronica", CustomerStatus.GOLD, 300500);
        Customer savedCustomer = customerRepository.save(customer);
        assertTrue(savedCustomer.getCustomerId() > 0);
        System.out.println(savedCustomer);
    }

    @Test
    void testFindByCustomerName() {
        Customer customer = new Customer("Veronica", CustomerStatus.GOLD, 300500);
        customerRepository.save(customer);
        Optional<Customer> customerOptional = customerRepository.findByCustomerName("Veronica");
        assertTrue(customerOptional.isPresent());
        assertEquals("Veronica", customerOptional.get().getCustomerName());
        System.out.println(customerOptional);
    }

    @Test
    void testFindByStatus() {
        customerRepository.save(new Customer("Veronica", CustomerStatus.GOLD, 300500));
        customerRepository.save(new Customer("Ana", CustomerStatus.GOLD, 123456));
        customerRepository.save(new Customer("Pedro", CustomerStatus.SILVER, 654321));

        List<Customer> goldCustomers = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
        assertFalse(goldCustomers.isEmpty());
        for (Customer customer : goldCustomers) {
            assertEquals(CustomerStatus.GOLD, customer.getCustomerStatus());
            System.out.println(customer);
        }
    }

}