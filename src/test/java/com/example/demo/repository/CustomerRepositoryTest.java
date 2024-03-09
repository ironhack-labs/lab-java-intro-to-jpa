package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.utils.CustomerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "Ana", CustomerStatus.GOLD, 1000);
        customerRepository.save(customer);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteById(1);
    }

    @Test
    public void testCreateNewCustomer(){
        Optional<Customer> customerFromDb = customerRepository.findById(1);
        assertTrue(customerFromDb.isPresent());
        assertEquals(customer, customerFromDb.get());
    }

    @Test
    public void testFindByCustomerName(){
        List<Customer> customersFromDb = customerRepository.findByCustomerName("Ana");
        assertEquals(1, customersFromDb.size());
        assertEquals(customer, customersFromDb.get(0));
    }

    @Test
    public void testFindByCustomerStatus(){
        List<Customer> customersFromDb = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
        assertEquals(1, customersFromDb.size());
        assertEquals(customer, customersFromDb.get(0));
    }
}