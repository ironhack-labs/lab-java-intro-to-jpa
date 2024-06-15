package com.ironhack.introjpa1.repository;

import com.ironhack.introjpa1.models.Customer;
import com.ironhack.introjpa1.models.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerName(String customerName);
    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);

}
