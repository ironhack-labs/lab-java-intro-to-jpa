package com.ironhack.lab.repository;

import com.ironhack.lab.model.Customer;
import com.ironhack.lab.model.CustomerStatus;
import com.ironhack.lab.model.Flight;
import com.ironhack.lab.model.FlightBooking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ICustomerRepositoryTest {
    @Autowired
    ICustomerRepository iCustomerRepository;

    Customer customer1 = new Customer("Christian Janco", CustomerStatus.SILVER, 14642);

    @BeforeEach
    void setUp(){
        iCustomerRepository.save(customer1);
    }

    @AfterEach
    void tearDown(){
        iCustomerRepository.delete(customer1);
    }

    @Test
    void thereAreOneMoreCustomer_isTrue(){
        System.out.println(iCustomerRepository.findAll().size());

        assertEquals(4,iCustomerRepository.findAll().size());
    }

    @Test
    void findByName_isTrue(){
        //Los test en funcion validate funcionan con los valores de la tabla
        System.out.println(iCustomerRepository.findAll().size());

        assertEquals("Agustine Riviera",iCustomerRepository.findByCustomerName("Agustine Riviera").get().getCustomerName());
    }

    @Test
    void findByStatus_ValueSilver_isSizeCorrect(){

        assertEquals(2,iCustomerRepository.findByCustomerStatus(CustomerStatus.SILVER).size());
    }

}