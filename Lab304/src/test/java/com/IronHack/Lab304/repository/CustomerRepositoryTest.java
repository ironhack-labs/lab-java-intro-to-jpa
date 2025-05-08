package com.IronHack.Lab304.repository;

import com.IronHack.Lab304.model.Customer;
import com.IronHack.Lab304.model.CustomerStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;
    Customer customer;

    /*@Test
    public void createCustomer_newCustomer(){
       Customer customer = new Customer();
       customer.setCustomerName("Test Doe");
        System.out.println(customer.getCustomerName());
       customer.setCustomerStatus(CustomerStatus.Silver);
        System.out.println(customer.getCustomerStatus());
       customer.setTotalCustomerMileage(123000);
        System.out.println(customer.getTotalCustomerMileage()); //ok hasta aca

      customerRepository.save(customer);
        System.out.println(customer);

    }
*/
    @Test
    public void createCustomer_newCustomerV2(){
       Customer customer1 = new Customer("Test Doe", CustomerStatus.Silver, 32345 );
       customerRepository.save(customer1);
       System.out.println(customer1);
       assertTrue(customerRepository.existsById(customer1.getCustomerId()));
       //cleanup
        customerRepository.delete(customer1);
        assertTrue(!customerRepository.existsById(customer1.getCustomerId()));

    }

    // Customers by name or name fragments
    @Test
    public void findAllByCustomerContaining_customerN_correctName(){
        List<Customer> customerList = customerRepository.findAllByCustomerNameContaining("JA");
        System.out.println(customerList);
        assertEquals(3, customerList.size());

    }

/*
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;
*/
    //Tests by Status
    @Test
    public void findAllByCustomerStatus_status_Gold(){
        List<Customer> goldStatusCustomerList = customerRepository.findAllByCustomerStatus(CustomerStatus.Gold);
        System.out.println("Gold status customers:");
        System.out.println(goldStatusCustomerList);
    }

    @Test
    public void findAllByCustomerStatus_status_Silver(){
        List<Customer> silverStatusCustomerList = customerRepository.findAllByCustomerStatus(CustomerStatus.Silver);
        System.out.println("Silver status customers:");
        System.out.println(silverStatusCustomerList);
    }

    @Test
    public void findAllByCustomerStatus_status_None(){
        List<Customer> noneStatusCustomerList = customerRepository.findAllByCustomerStatus(CustomerStatus.Silver);
        System.out.println("Silver status customers:");
        System.out.println(noneStatusCustomerList);
    }




}



