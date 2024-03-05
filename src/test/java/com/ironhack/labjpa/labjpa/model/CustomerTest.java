package com.ironhack.labjpa.labjpa.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void createCustomerTest(){
        customer.setCustomerName("Pepe");
        customer.setStatus(CustomerStatus.GOLD);
        customer.setTotalCustomerMileage(123);
        assertEquals("Pepe", customer.getCustomerName());
        assertEquals(CustomerStatus.GOLD, customer.getStatus());
        assertEquals(123, customer.getTotalCustomerMileage());
    }

}