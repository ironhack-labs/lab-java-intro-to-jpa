package com.ironhack.labjpa.labjpa.repository;

import com.ironhack.labjpa.labjpa.model.Customer;
import com.ironhack.labjpa.labjpa.model.CustomerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Juan", CustomerStatus.SILVER, 345);
        customerRepository.save(customer);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    public void findByCustomerNameTest() {
        Optional<Customer> customer1 = customerRepository.findByCustomerName("Juan");
        assertTrue(customer1.isPresent());
        assertEquals(customer, customer1.get());
        //assertEquals("Juan", customer1.get().getCustomerName());
    }

    @Test
    void findByCustomerStatus() {
        Optional<Customer> customer2 = customerRepository.findByCustomerStatus(CustomerStatus.SILVER);
        assertTrue(customer2.isPresent());
        assertEquals(customer, customer2.get());
    }
}