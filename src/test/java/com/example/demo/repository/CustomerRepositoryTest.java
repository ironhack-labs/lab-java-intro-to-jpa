package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerStatus;
import org.hibernate.mapping.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        Customer c1=new Customer("Juan", CustomerStatus.GOLD,3000);
        customerRepository.save(c1);
    }

    @Test
    public void findCustomerByName() {
        List customers = customerRepository.findByName("Tom Jones");
        assertThat("Tom Jones").isNotEmpty();
    }
    @Test
    void test(){

    }

    @AfterEach
    void tearDown() {
    }
}