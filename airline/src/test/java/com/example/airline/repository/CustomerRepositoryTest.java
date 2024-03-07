package com.example.airline.repository;

import com.example.airline.model.Customer;
import com.example.airline.model.CustomerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepo;

    private Customer c1;
    private Customer c2;
    private List<Customer> customerList;

    @BeforeEach
    public void setUp() {
        c1 = new Customer("Juan", CustomerStatus.Gold, 1000);
        customerRepo.save(c1);

        c2 = new Customer("Maria", CustomerStatus.Silver, 2000);
        customerRepo.save(c2);
    }

    @AfterEach
    public void tearDown() {
        customerRepo.deleteAll();
    }

    @Test
    public void findAllTest() {
        customerList = customerRepo.findAll();
        assertEquals(2, customerList.size());
    }

    @Test
    public void validateCustomerCreation() {
        customerList = customerRepo.findAll();
        assertEquals(2, customerList.size());
        assertEquals("Maria", customerList.get(1).getCustomerName());
    }

    @Test
    public void findCustomerByName(){
        customerList = customerRepo.findAllByCustomerName("Maria");
        assertEquals(1, customerList.size());
        assertEquals("Maria", customerList.get(0).getCustomerName());
    }

    @Test
    public void findAllByCustomerStatus(){
        customerList = customerRepo.findAllByCustomerStatus(CustomerStatus.Silver);
        assertEquals(1, customerList.size());
        assertEquals("Maria", customerList.get(0).getCustomerName());
    }

}