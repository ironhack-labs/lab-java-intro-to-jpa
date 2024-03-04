package org.example;

import org.example.Model.Customer;
import org.example.Repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FindCustomerByStatus {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        // Clean up the repository to avoid interference from previous tests
        customerRepository.deleteAll();

        // Given
        Customer customer1 = new Customer("Alice", CustomerStatus.Gold, 1000); // Adjust constructor based on your actual Customer fields
        Customer customer2 = new Customer("Bob", CustomerStatus.Silver, 500);
        Customer customer3 = new Customer("Carol", CustomerStatus.None, 1500);
        Customer customer4 = new Customer("Dave", CustomerStatus.Gold, 2000);

        // Save test data
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
    }

    @Test
    public void testFindCustomersByStatus() {
        // When
        List<Customer> goldCustomers = customerRepository.findByCustomerStatus(CustomerStatus.Gold);

        // Then
        assertThat(goldCustomers).hasSize(2);
        assertThat(goldCustomers).allMatch(customer -> customer.getCustomerStatus().equals(CustomerStatus.Gold));
    }
}
