package com.ironhacklab.intro_jpa.Repository;

import com.ironhacklab.intro_jpa.Enums.CustomerStatus;
import com.ironhacklab.intro_jpa.Model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer c4;
    @BeforeEach
    void setUp() {
        Customer c1 = new Customer(1, "Arian", CustomerStatus.GOLD, 170);
        Customer c2 = new Customer(2, "Maria", CustomerStatus.GOLD, 150);
        Customer c3 = new Customer(3, "Pedro", CustomerStatus.SILVER, 110);
        c4 = new Customer(4, "DummyCustomer", CustomerStatus.None, 110);
        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void findCustomerByName() {
        List<Customer> listOfCustomer = customerRepository.findAllByCustomerName("Arian");
        assertNotNull(listOfCustomer);
        assertEquals(1, listOfCustomer.size());
    }

    @Test
    void findListOfCustomerWithGoldStatus(){
        List<Customer> listOfCustomer = customerRepository.findAllByCustomerStatus(CustomerStatus.GOLD);
        assertNotNull(listOfCustomer);
        assertEquals(2, listOfCustomer.size());
    }

    @Test
    void shouldWeCreateNewCustomer(){
        customerRepository.save(c4);
        List<Customer> customerList= customerRepository.findAllByCustomerName("DummyCustomer");
        assertEquals(c4, customerList.get(0));
    }
}
