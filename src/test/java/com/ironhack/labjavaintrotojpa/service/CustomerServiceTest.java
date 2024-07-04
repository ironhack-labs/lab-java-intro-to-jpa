package com.ironhack.labjavaintrotojpa.service;

import com.ironhack.labjavaintrotojpa.Enums.CustomerStatusEnum;
import com.ironhack.labjavaintrotojpa.model.Customer;
import com.ironhack.labjavaintrotojpa.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService.saveAll(List.of(
                new Customer("Agustine Riviera", CustomerStatusEnum.SILVER, 115235),
                new Customer("Alaina Sepulvida", CustomerStatusEnum.NONE, 6008),
                new Customer("Tom Jones", CustomerStatusEnum.GOLD, 205767),
                new Customer("Sam Rio", CustomerStatusEnum.NONE, 2653),
                new Customer("Jessica James", CustomerStatusEnum.SILVER, 127656),
                new Customer("Ana Janco", CustomerStatusEnum.SILVER, 136773),
                new Customer("Jennifer Cortez", CustomerStatusEnum.GOLD, 300582),
                new Customer("Christian Janco", CustomerStatusEnum.SILVER, 14642)
        ));
    }

    @AfterEach
    void tearDown() {
        customerService.deleteAll();
    }

    @Test
    void createCustomer() {
        // Arrange
        int initialSize = customerService.findAll().size();
        Customer customer = new Customer("Serhat Karakelle", CustomerStatusEnum.GOLD, 999999);
        // Act
        customerService.save(customer);
        int finalSize = customerService.findAll().size();
        // Assert
        assertEquals(finalSize, initialSize + 1);
    }

    @Test
    void findByName() {
        // Assert
        assertNotNull(customerService.findByName("agustine riviera"));
        assertEquals(1, customerService.findByName("AGUStine riviera").size());
    }

    @Test
    void findByStatus() {
        // Assert
        assertNotNull(customerService.findByStatus(CustomerStatusEnum.GOLD));
        assertEquals(4, customerService.findByStatus(CustomerStatusEnum.SILVER).size());
    }
}