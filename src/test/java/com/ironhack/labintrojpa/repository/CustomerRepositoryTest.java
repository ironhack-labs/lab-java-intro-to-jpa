package com.ironhack.labintrojpa.repository;

import com.ironhack.labintrojpa.enums.CustomerStatus;
import com.ironhack.labintrojpa.model.Customer;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        List<Customer> customers = List.of(
                new Customer("Daniel", CustomerStatus.GOLD, 15000),
                new Customer("Juan", CustomerStatus.SILVER, 10000),
                new Customer("Alan", CustomerStatus.NONE, 5000)
        );
        customerRepository.saveAll(customers);
    }

    @AfterEach
    void afterEach() {
        customerRepository.deleteAll();
    }

    @Test
    public void testCreateCustomers() {
        List<Customer> customers = customerRepository.findAll();
        assertNotNull(customers);
        assertEquals(3, customers.size());
    }

    @Test
    public void testFindCustomerByName() {
        List<Customer> customers = customerRepository.findByCustomerNameContainingIgnoreCase("Juan");
        assertNotNull(customers);
        assertEquals(1, customers.size());
        assertEquals("Juan", customers.get(0).getCustomerName());
    }

    @Test
    public void testFindCustomersByStatus() {
        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.SILVER);
        assertNotNull(customers);
        assertEquals(CustomerStatus.SILVER, customers.get(0).getCustomerStatus());
    }

}