package com.IntroToJPA.Lab304IntroToJPA.repository;


import com.IntroToJPA.Lab304IntroToJPA.CustomerStatus;
import com.IntroToJPA.Lab304IntroToJPA.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerName(String customerName);
    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
