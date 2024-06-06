package com.ironhack.labintrotojpa.Repositories;

import com.ironhack.labintrotojpa.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
        Customer customer = new Customer("G I Joe","Gold",6969);
        Customer customer1 = new Customer("G I Julia","none",7171);
        customerRepository.saveAll(List.of(customer,customer1));
    }

//Write tests to verify your ability to find customers by name.
    @Test
    void findByCustomerName() {
        //Given
        List<Customer> customers = customerRepository.findByCustomerName("G I Joe");
        //When
        assertEquals(1, customers.size());
        //Then
        assertEquals("G I Joe", customers.get(0).getCustomerName());
    }
//Write tests to verify your ability to find customers by status.
    @Test
    void findByCustomerStatus() {
        //Given
        List<Customer> customers = customerRepository.findByCustomerStatus("Gold");
        //When
        assertEquals(1, customers.size());
        //Then
        assertEquals("Gold", customers.get(0).getCustomerStatus());
    }
}