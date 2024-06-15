package com.ironhack.introjpa1.repository;

import com.ironhack.introjpa1.models.Customer;
import com.ironhack.introjpa1.models.CustomerStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.ironhack.introjpa1.models.CustomerStatus.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
        Customer c1=new Customer("Augustine Raviera",SILVER,115235);
        Customer c2=new Customer("Alaina Sepulvida", NONE,6008);
        Customer c3=new Customer("Tom Jones", GOLD,205767);
        Customer c4=new Customer("Sam Rio", NONE,2653);
        Customer c5=new Customer("Jessica James",SILVER,127656);
        Customer c6=new Customer("Ana Janco",SILVER,136773);
        Customer c7=new Customer("Jennifer Cortez",SILVER,300582);
        Customer c8=new Customer("Christian Janco",SILVER,14642);
        customerRepository.saveAll(List.of(c1,c2,c3,c4,c5,c6,c7,c8));

    }

    @Test
    public void testCreateNewCustomer() {

        Customer customer = new Customer("Kofi Ghana", CustomerStatus.GOLD, 600);


        Customer savedCustomer = customerRepository.save(customer);


        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerId()).isNotNull();
        assertThat(savedCustomer.getCustomerName()).isEqualTo("Kofi Ghana");
        assertThat(savedCustomer.getCustomerStatus()).isEqualTo(CustomerStatus.GOLD);
        assertThat(savedCustomer.getTotalCustomerMileage()).isEqualTo(600);
    }




    @Test
    void findByCustomerName() {
        List<Customer> customers = customerRepository.findByCustomerName("Tom Jones");
        assertEquals(1,customers.size());
        assertEquals("Tom Jones",customers.get(0).getCustomerName());
    }

    @Test
    void findByCustomerStatus() {
        List<Customer> customers = customerRepository.findByCustomerStatus(GOLD);
        assertThat(customers.get(0).getCustomerStatus()).isEqualTo(GOLD);
        // check how many gold you found and compare to what you were expecting
    }
}