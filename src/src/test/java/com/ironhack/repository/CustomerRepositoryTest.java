package com.ironhack.repository;

import com.ironhack.model.components.CustomerStatus;
import com.ironhack.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    //private List<Customer> customerList;

    @BeforeEach
    void setUp() {
        customer1 = new Customer("Rai", CustomerStatus.GOLD, 10000);
        customerRepository.save(customer1);
        customer2 = new Customer("Simone", CustomerStatus.SILVER, 20000);
        customerRepository.save(customer2);
        customer3 = new Customer("Juan", CustomerStatus.GOLD, 30000);
        customerRepository.save(customer3);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteById(customer1.getCustomerId());
        customerRepository.deleteById(customer2.getCustomerId());
        customerRepository.deleteById(customer3.getCustomerId());
    }

    //Write tests to verify your ability to create new customers.
    @Test
    public void testCreateCustomer(){
        Optional<Customer> customerFromDb = customerRepository.findById(customer1.getCustomerId());
        assertTrue(customerFromDb.isPresent());
        assertEquals(customer1, customerFromDb.get());
    }

    //Write tests to verify your ability to find customers by name.
    @Test
    public void testFindCustomerByName(){
        Optional<Customer> customerFromDb = customerRepository.findCustomerByCustomerName(customer1.getCustomerName());
        assertTrue(customerFromDb.isPresent());
        assertEquals(customer1, customerFromDb.get());
    }

    //Write tests to verify your ability to find customers by status.
    @Test
    public void testFindCustomersByStatus(){
        List<Customer> customersFromDb = customerRepository.findAllByCustomerStatus(CustomerStatus.GOLD);
        assertEquals(2, customersFromDb.size());
    }
}