package com.ironhack.lab304.repository;

import com.ironhack.lab304.model.Customer;
import com.ironhack.lab304.model.CustomerStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    // Create New Customer
    @Test
    public void save_customer_newCustomer() {
        Customer customer = new Customer("Customer Test", CustomerStatus.SILVER, 28900);

        // Save in DB
        customerRepository.save(customer);

        // Verify if the Customer was created
        assertTrue(customerRepository.findById(customer.getCustomerId()).isPresent());
    }

    // Find By Customer Name
    @Test
    void findByCustomerName_validCustomerName_correctCustomer() {

        Optional<Customer> customerOptional = customerRepository.findByCustomerName("Tom Jones");

        assertTrue(customerOptional.isPresent());

    }

    @Test
    void findByCustomerName_invalidCustomerName_incorrectCustomer() {

        Optional<Customer> customerOptional = customerRepository.findByCustomerName("Not Exist");

        assertFalse(customerOptional.isPresent());

    }

    // Find Customers By Status
    @Test
    void findAllByCustomerStatus_validStatus_customerList() {

        List<Customer> customerList = customerRepository.findAllByCustomerStatus(CustomerStatus.GOLD);
        System.out.println(customerList);
        assertEquals(2, customerList.size());

    }


}