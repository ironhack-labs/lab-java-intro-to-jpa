package org.example;

import org.example.Model.Customer;
import org.example.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class findCustomerByName {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindCustomerByName() {
        // Given
        String customerName = "Test Customer";
        Customer customer = new Customer(customerName);

        // When
        List<Customer> foundCustomers = customerRepository.findByCustomerName(customerName);

        // Then
        assertThat(foundCustomers).isNotEmpty();
        assertThat(foundCustomers.get(0).getCustomerName()).isEqualTo(customerName);
    }
}
