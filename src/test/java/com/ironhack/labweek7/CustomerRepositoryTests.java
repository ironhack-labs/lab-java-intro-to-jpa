package com.ironhack.labweek7;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateNewCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.None, 5000);
        customerRepository.save(customer);
        assertThat(customer.getCustomerId()).isNotNull();
    }

    @Test
    public void testFindCustomerByName() {
        Customer customer = new Customer("Jane Doe", CustomerStatus.Gold, 15000);
        customerRepository.save(customer);
        List<Customer> foundCustomers = customerRepository.findByCustomerName("Jane Doe");
        assertThat(foundCustomers).hasSize(1);
        assertThat(foundCustomers.get(0).getCustomerName()).isEqualTo("Jane Doe");
    }

    @Test
    public void testFindCustomerByStatus() {
        Customer customer = new Customer("Alice Smith", CustomerStatus.Silver, 10000);
        customerRepository.save(customer);
        List<Customer> foundCustomers = customerRepository.findByCustomerStatus(CustomerStatus.Silver);
        assertThat(foundCustomers).hasSize(1);
        assertThat(foundCustomers.get(0).getCustomerStatus()).isEqualTo(CustomerStatus.Silver);
    }
}

