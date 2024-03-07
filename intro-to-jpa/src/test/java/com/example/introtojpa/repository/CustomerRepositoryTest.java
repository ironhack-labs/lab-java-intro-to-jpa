package com.example.introtojpa.repository;

import com.example.introtojpa.CustomerStatus;
import com.example.introtojpa.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;

    @BeforeEach
    void setUp() {
        customer = new Customer("Xavi", CustomerStatus.Gold, 6000);
        customer1 = new Customer("Thais", CustomerStatus.Gold, 5000);
        customer2 = new Customer("Haku", CustomerStatus.Silver, 1000);
        customer3 = new Customer("Pau", CustomerStatus.None, 100);
        customerRepository.save(customer);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }


    @Test
    public void CreateNewCustomer(){
        customerRepository.save(customer3);
        Optional<Customer> customerRepo = customerRepository.findById(customer3.getCustomerId());
        assertTrue(customerRepo.isPresent());
        assertEquals(customer3.getCustomerId(),customerRepo.get().getCustomerId());
    }

    @Test
    public void FindAllCustomerByName(){
        List<Customer> findCustomer = customerRepository.findAllByCustomerName("Thais");
        assertEquals(customer1.getCustomerId(),findCustomer.get(0).getCustomerId());
    }

    @Test
    public void FindAllCustomerByStatus(){
        List<Customer> findCustomer = customerRepository.findAllByCustomerStatus(CustomerStatus.Gold);
        assertEquals(customer.getCustomerId(),findCustomer.get(0).getCustomerId());
        assertEquals(customer1.getCustomerId(),findCustomer.get(1).getCustomerId());
    }
}