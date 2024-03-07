package com.ironhack.demo;

import com.ironhack.demo.model.Customer;
import com.ironhack.demo.model.CustomerStatus;
import com.ironhack.demo.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Anna", CustomerStatus.GOLD, 100));
        customers.add(new Customer("Jaume", CustomerStatus.SILVER, 70));
        customers.add(new Customer("Talvi", CustomerStatus.NONE, 45));

        customerRepository.saveAll(customers);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    @DisplayName("Test to verify your ability to create new customers.")
    public void createNewCostumerTest() {
        List<Customer> customers = customerRepository.findAll();
        assertEquals(3, customers.size());
    }

    @Test
    @DisplayName("Test to verify your ability to find customers by name.")
    public void findByCostumerNameTest() {
        Optional<Customer> result = customerRepository.findByCustomerName("Jaume");
        assertTrue(result.isPresent());
        assertEquals("Jaume", result.get().getCustomerName());

        Optional<Customer> result1 = customerRepository.findByCustomerName("Jaume");
        assertFalse(result1.isPresent());
    }

    @Test
    @DisplayName("Test to verify your ability to find customers by status.")
    public void findByCostumerStatusTest() {
        Optional<Customer> result = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
        assertTrue(result.isPresent());
        assertEquals(CustomerStatus.GOLD, result.get().getCustomerStatus());
    }
}