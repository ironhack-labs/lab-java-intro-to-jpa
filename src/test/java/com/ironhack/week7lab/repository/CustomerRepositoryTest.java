package com.ironhack.week7lab.repository;

import com.ironhack.week7lab.enums.CustomerStatus;
import com.ironhack.week7lab.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.Gold, 12000);
        Customer savedCustomer = customerRepository.save(customer);
        assertNotNull(savedCustomer.getCustomerId());
        assertEquals("John Doe", savedCustomer.getCustomerName());
    }

    @Test
    public void testFindCustomerByName() {
        Customer customer = new Customer("Jane Smith", CustomerStatus.Silver, 5000);
        customerRepository.save(customer);
        Customer foundCustomer = customerRepository.findByCustomerName("Jane Smith");
        assertNotNull(foundCustomer);
        assertEquals("Jane Smith", foundCustomer.getCustomerName());
    }

    @Test
    public void testFindCustomerByStatus() {
        Customer customer = new Customer("Alice Brown", CustomerStatus.None, 3000);
        customerRepository.save(customer);
        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.None);
        assertNotNull(customers);
        assertEquals(1, customers.size());
        assertEquals("Alice Brown", customers.get(0).getCustomerName());
    }

}