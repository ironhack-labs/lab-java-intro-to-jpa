package com.ironhack.labjavaintrotojpa.repository;

import com.ironhack.labjavaintrotojpa.model.Customer;
import com.ironhack.labjavaintrotojpa.model.CustomerStatus;
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
    Customer customer;

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customer = new Customer("Hedi Lamarr", CustomerStatus.SILVER, 12334);
        customerRepository.save(customer);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteById(customer.getCustomerId());
        customer = null;
    }

    @Test
    public void findAllTest() {
        List<Customer> customers = customerRepository.findAll();
        assertEquals(1, customers.size());
    }

    @Test
    public void findByCustomerNameTest() {
        Optional<Customer> customer = customerRepository.findByCustomerName("Hedi Lamarr");
        assertTrue(customer.isPresent());
        assertEquals("Hedi Lamarr", customer.get().getCustomerName());
    }

    @Test
    public void findByCustomerStatusTest() {
        Optional<Customer> customer = customerRepository.findByCustomerStatus(CustomerStatus.SILVER);
        assertTrue(customer.isPresent());
        assertEquals(CustomerStatus.SILVER, customer.get().getCustomerStatus());
    }

}
