package com.airline.lab.repository;

import com.airline.lab.model.Customer;
import com.airline.lab.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // 6. Write tests to verify your ability to find customers by name.
    List<Customer> findAllByCustomerName(String customerName);


    // 7. Write tests to verify your ability to find customers by status.
    List<Customer> findAllByCustomerStatus(CustomerStatus customerStatus);

}