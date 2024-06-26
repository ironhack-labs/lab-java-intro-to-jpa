package com.IntroToJPA.Lab304IntroToJPA.repository;

import com.IntroToJPA.Lab304IntroToJPA.CustomerStatus;
import com.IntroToJPA.Lab304IntroToJPA.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer("Pepe", CustomerStatus.GOLD, 224534);
        customerRepository.save(customer);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll(customerRepository.findByCustomerName("Pepe"));
    }


    @Test
    public void findByCustomerName_ValidCustomerName_RightCustomers() {
        List<Customer> customerList = customerRepository.findByCustomerName("Pepe");
        assertEquals(1, customerList.size());
    }


    @Test
    public void findByCustomerStatus_ValidStatus_RightCustomers() {
        List<Customer> customersList = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
        assertEquals(1, customersList.size());
    }

}