package com.example.airlines.demo.repository;

import com.example.airlines.demo.model.Customer;
import com.example.airlines.demo.model.CustomerStatus;
import com.example.airlines.demo.model.Flight;
import jakarta.servlet.http.PushBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class CustomerTest {
    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    public void setCustomer(){
        Customer customer = new Customer("Darwin", CustomerStatus.Gold, 1000);
        customerRepository.save(customer);
    }

    @AfterEach
    public void shutDown(){
        customerRepository.deleteAll();
    }

    @Test
    public void checkCustomer(){
        List<Customer> x = customerRepository.findAll();

        assertEquals(1, x.size());
    }

    @Test
    public void customerName(){
        Customer customer = customerRepository.findByCustomerName("Darwin");

        assertEquals("Darwin", customer.getCustomerName());
    }

    @Test
    public void customerStatus(){
        List<Customer> goldCustomer = customerRepository.findByCustomerStatus(CustomerStatus.Gold);
        List<Customer> silverCustomer = customerRepository.findByCustomerStatus(CustomerStatus.Silver);

        assertEquals(1, goldCustomer.size());
        assertEquals(0, silverCustomer.size());
    }
}
