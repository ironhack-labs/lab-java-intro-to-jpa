package com.jpa.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.GOLD, 10000);
        customerRepository.save(customer);

        List<Customer> customers = customerRepository.findByCustomerName("John Doe");
        assertTrue(customers.size() > 0);
    }

    @Test
    public void testFindCustomersByName() {
        List<Customer> customers = customerRepository.findByCustomerName("John Doe");
        assertTrue(customers.size() > 0);
    }

    @Test
    public void testFindCustomersByStatus() {
        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
        assertTrue(customers.size() > 0);
    }
}
