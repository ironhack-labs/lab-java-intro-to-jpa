package com.ironhack.labjpa.model;

import com.ironhack.labjpa.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Test
    public void givenCustomer_whenSaveCustomer_thenCustomerSaved() {
        //Given
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName("G.I JOE");
        newCustomer.setCustomerStatus("Gold");

        //When
        Customer savedCustomer = customerRepository.save(newCustomer);

        //Then
        assertEquals(1, savedCustomer.getCustomerId());
    }


}