package com.ironhack.introJPA.repository;

import com.ironhack.introJPA.model.Customer;
import com.ironhack.introJPA.model.CustomerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer4;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer("Pepe", CustomerStatus.Gold, 1000);
        Customer customer1 = new Customer("Ramon", CustomerStatus.None, 3300);
        Customer customer2 = new Customer("Jose", CustomerStatus.Silver, 7000);
        customer4 = new Customer("Ramiro", CustomerStatus.Silver, 6000);
        customerRepository.save(customer);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    public void testCreateNewCustomer() {
        customerRepository.save(customer4);
        List<Customer> customerList= customerRepository.findByCustomerName("Ramiro");
        assertEquals(customer4, customerList.get(0));
    }

    @Test
    void findByCustomerName() {
        List<Customer> listOfCustomer = customerRepository.findByCustomerName("Pepe");
        assertNotNull(listOfCustomer);
        assertEquals(1, listOfCustomer.size());
    }



   @Test
    void findByCustomerStatus() {
       List<Customer> goldCustomers = customerRepository.findByCustomerStatus(CustomerStatus.Gold);
       // Verify that the list is not empty
       assertFalse(goldCustomers.isEmpty());
       // Verify the status of the first customer in the list
       assertEquals(1, goldCustomers.size());

    }
}