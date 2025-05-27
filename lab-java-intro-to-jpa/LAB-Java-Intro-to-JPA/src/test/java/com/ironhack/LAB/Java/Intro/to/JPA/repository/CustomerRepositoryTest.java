package com.ironhack.LAB.Java.Intro.to.JPA.repository;

import com.ironhack.LAB.Java.Intro.to.JPA.model.Customer;
import com.ironhack.LAB.Java.Intro.to.JPA.model.CustomerStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.ironhack.LAB.Java.Intro.to.JPA.model.CustomerStatus.GOLD;
import static com.ironhack.LAB.Java.Intro.to.JPA.model.CustomerStatus.SILVER;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;
    Customer customer;


    private String customerName;

    @BeforeEach
    public void SetUp() {
        customer = new Customer("John Doe", CustomerStatus.GOLD, 2000);
        customerRepository.save(customer);
        System.out.println(customer);
    }


    @Test
    public void findCustomerByName() {
        Optional<Customer> customerOptional = customerRepository.findByCustomerName("John Doe");
        assertEquals("John Doe", customerOptional.get().getCustomerName());
        System.out.println(customerOptional.get());
    }

    @Test
    public void findCustomerByStatus() {
        Enum customerStatus = CustomerStatus.NONE;
        Optional<Customer> customerOptional = customerRepository.findByCustomerStatus(customerStatus);
        assertTrue(customerOptional.isEmpty());
        System.out.println(customerOptional);
    }


}











