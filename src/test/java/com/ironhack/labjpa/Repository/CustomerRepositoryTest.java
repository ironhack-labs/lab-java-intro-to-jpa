package com.ironhack.labjpa.Repository;

import com.ironhack.labjpa.model.Customer;
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
        Customer customer = new Customer(1,"G I JOE","Gold", 4824);
        Customer customer1 = new Customer(2,"G I JOSEPHINE","NONE", 2454);
        customerRepository.saveAll(List.of(customer,customer1));





    }
    @Test
            void findByCustomerName(){
        List<Customer> customers = customerRepository.findByCustomerName("G I JOE");
        assertEquals(1, customers.size());
        assertEquals("G I JOE", customers.get(0).getCustomerName());


    }
    @Test
    void findByCustomerStatus(){
        List<Customer> customers = customerRepository.findByCustomerStatus("Gold");
        assertEquals(1, customers.size());
        assertEquals("Gold", customers.get(0).getCustomerStatus());
    }

  
}