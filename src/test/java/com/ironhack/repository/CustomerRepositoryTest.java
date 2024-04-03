package com.ironhack.repository;

import com.ironhack.model.Customer;
import com.ironhack.model.CustomerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    @DisplayName("Should create a customer")
    void TestCreateCustomer() {
        customerRepository.save(new Customer("customer1", CustomerStatus.GOLD, 10500));
        assertEquals(1, customerRepository.findAll().size());
    }

    @Test
    @DisplayName("Should create two customer")
    void TestCreateCustomers() {
        customerRepository.save(new Customer("customer1", CustomerStatus.GOLD, 10500));
        customerRepository.save(new Customer("customer2", CustomerStatus.SILVER, 5500));

        assertEquals(2, customerRepository.findAll().size());
    }

    @Test
    @DisplayName("Should find a specific customer by name")
    void TestFindCustomerByName() {
        customerRepository.save(new Customer("customer1", CustomerStatus.GOLD, 10500));

        assertTrue(customerRepository.findAllByCustomerName("customer1").size() == 1);
    }

    @Test
    @DisplayName("Should find a specific customer by status")
    void TestFindCustomerByStatus() {
        customerRepository.save(new Customer("customer1", CustomerStatus.GOLD, 10500));

        assertTrue(customerRepository.findAllByCustomerStatus(CustomerStatus.GOLD).size() == 1);
    }


}