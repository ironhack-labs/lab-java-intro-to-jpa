package com.labs.lab_java_jpaintro.repository;

import com.labs.lab_java_jpaintro.CustomerStatus;
import com.labs.lab_java_jpaintro.model.Customer;
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

    @Test
    void testFindCustomerByName() {
        Optional<Customer> customerOptional = customerRepository.findByCustomerName("Agustine Riviera");
        assertTrue(customerOptional.isPresent());
        assertEquals(115235, customerOptional.get().getTotalCustomerMileage());
    }

    @Test
    void testFindCustomersByStatus() {
        List<Customer> silverCustomers = customerRepository.findByCustomerStatus(CustomerStatus.SILVER);
        assertEquals(4, silverCustomers.size()); // Check the number of customers with Silver status
    }

    @Test
    void testSaveCustomer() {
        Customer newCustomer = new Customer("Charlie", CustomerStatus.NONE, 800);
        Customer savedCustomer = customerRepository.save(newCustomer);
        assertNotNull(savedCustomer.getCustomerId());
        assertEquals("Charlie", savedCustomer.getCustomerName());
        customerRepository.delete(newCustomer);
    }

    @Test
    void testDeleteCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.SILVER, 50000);
        customer = customerRepository.save(customer);

        assertNotNull(customer.getCustomerId(), "Customer ID should not be null");

        customerRepository.delete(customer);

        Optional<Customer> deletedCustomer = customerRepository.findById(customer.getCustomerId());
        assertFalse(deletedCustomer.isPresent(), "Customer should not be present");
    }






}