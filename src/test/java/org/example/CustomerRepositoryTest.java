package org.example;

import org.example.Model.Customer;
import org.example.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateNewCustomer() {
        // Given
        String customerName = "Test Customer";
        CustomerStatus customerStatus = CustomerStatus.Gold;
        int totalCustomerMileage = 2000;

        // When
        Customer customer = new Customer(customerName, customerStatus, totalCustomerMileage);
        customer = customerRepository.save(customer);

        // Then
        Customer savedCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerName()).isEqualTo(customerName);
        assertThat(savedCustomer.getCustomerStatus()).isEqualTo(customerStatus);
        assertThat(savedCustomer.getTotalCustomerMileage()).isEqualTo(totalCustomerMileage);
    }
}