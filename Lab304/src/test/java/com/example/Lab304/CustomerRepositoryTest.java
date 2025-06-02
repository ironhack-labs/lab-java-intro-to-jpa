package com.example.Lab304;

import com.example.Lab304.classes.Customer;
import com.example.Lab304.enums.CustomerStatus;
import com.example.Lab304.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void createCustomerTest() {
        Customer customer = new Customer("Fulano Gómez", CustomerStatus.Gold, 50000);
        Customer saved = customerRepository.save(customer);
        assertThat(saved.getCustomerId()).isNotNull();
    }

    @Test
    void findByNameTest() {
        Customer customer = new Customer("Fulano Gómez", CustomerStatus.Gold, 50000);
        Customer search = customerRepository.findByCustomerName("Fulano Gómez");
        assertEquals("Fulano Gómez", customer.getCustomerName());
    }

    @Test
    void findByStatusTest() {
        customerRepository.save(new Customer("Fulano Gómez", CustomerStatus.Gold, 50000));
        customerRepository.save(new Customer("Mengano López", CustomerStatus.None, 100));
        List<Customer> gold = customerRepository.findByCustomerStatus(CustomerStatus.Gold);
        assertEquals(1, gold.size());
    }

}
