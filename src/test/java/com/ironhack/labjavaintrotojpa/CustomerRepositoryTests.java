package com.ironhack.labjavaintrotojpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.ironhack.labjavaintrotojpa.model.Customer;
import com.ironhack.labjavaintrotojpa.model.CustomerStatus;
import com.ironhack.labjavaintrotojpa.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setCustomerName("Jane Doe");
        customer.setCustomerStatus(CustomerStatus.GOLD);
        customer.setTotalCustomerMileage(1000);
        customerRepository.save(customer);

        assertThat(customer.getCustomerId()).isNotNull();
    }

    @Test
    public void testFindByCustomerName() {
        List<Customer> customers = customerRepository.findByCustomerName("John Doe");
        assertThat(customers).isNotEmpty();
    }

    @Test
    public void testFindByCustomerStatus() {
        List<Customer> customers = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
    }
}