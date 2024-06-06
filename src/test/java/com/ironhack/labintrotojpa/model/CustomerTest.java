package com.ironhack.labintrotojpa.model;

import com.ironhack.labintrotojpa.Repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


// Write tests to verify your ability to create new customers.
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerTest {
    @Autowired
    private CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();

    }

    @Test
    public void givenNewCustomer_whenSaveCustomer_thenCustomerIsSaved() {
        //Given
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName("G.I. Joe");
        newCustomer.setCustomerStatus("Gold");

        //When
        Customer savedCustomer = customerRepository.save(newCustomer);

        //Then
        assertEquals(1, savedCustomer.getCustomerId());


    }
}

