package com.ironhack.lab_intro_to_jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.GOLD, 1000);
        customerRepository.save(customer);
        List<Customer> customers = customerRepository.findByCustomerName("John Doe");
        assertEquals(1, customers.size());
        assertEquals("John Doe", customers.get(0).getCustomerName());
    }

    @Test
    public void testFindCustomerByStatus() {
        Customer customer = new Customer("Jane Doe", CustomerStatus.SILVER, 2000);
        customerRepository.save(customer);
        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.SILVER);
        assertEquals(1, customers.size());
        assertEquals(CustomerStatus.SILVER, customers.get(0).getCustomerStatus());
    }
}

