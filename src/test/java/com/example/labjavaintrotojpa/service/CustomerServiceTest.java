package com.example.labjavaintrotojpa.service;

import com.example.labjavaintrotojpa.model.Customer;
import com.example.labjavaintrotojpa.model.CustomerStatus;
import com.example.labjavaintrotojpa.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Mock
    private CustomerRepository customerRepositoryMocked;

    @InjectMocks
    private CustomerService customerServiceMocked;

    @Test
    @DisplayName("Create new Customer")
    void createNewCustomer() {

        when(customerRepositoryMocked.save(any(Customer.class))).thenAnswer(invocation -> {
            Customer customer = invocation.getArgument(0);
            customer.setCustomerId(99);
            return customer;
        });

        String customerName = "Diego Martins";
        CustomerStatus customerStatus = CustomerStatus.GOLD;
        Integer totalCustomerMileage = 1000;

        Customer createdCustomer = customerServiceMocked.createNewCustomer(customerName, customerStatus, totalCustomerMileage);

        assertNotNull(createdCustomer.getCustomerId());
        assertEquals(customerName, createdCustomer.getCustomerName());
        assertEquals(customerStatus, createdCustomer.getCustomerStatus());
        assertEquals(totalCustomerMileage, createdCustomer.getTotalCustomerMileage());

        verify(customerRepositoryMocked, times(1)).save(any(Customer.class));
    }

    @Test
    @DirtiesContext
    @DisplayName("Find customer by name")
    void testFindCustomersByName() {

        String customerName = "Agustine Riviera";

        List<Customer> foundCustomers = customerService.findCustomersByName(customerName);

        assertNotNull(foundCustomers);
        assertEquals(1, foundCustomers.size()); // Check if all customers with the same name are found

    }

    @ParameterizedTest
    @EnumSource(CustomerStatus.class)
    @DirtiesContext
    @DisplayName("Find customers by status")
    void testFindCustomersByStatus(CustomerStatus status) {
        List<Customer> foundCustomers = customerService.findCustomerByStatus(status);

        assertNotNull(foundCustomers);
        assertTrue(foundCustomers.size() > 0);
    }

    @ParameterizedTest
    @EnumSource(value = CustomerStatus.class, names = {"GOLD"})
    @DirtiesContext
    @DisplayName("Find customers by status")
    void testFindCustomersByGOLDStatus(CustomerStatus status) {
        List<Customer> foundCustomers = customerService.findCustomerByStatus(status);

        assertEquals(2, foundCustomers.size());
    }

}