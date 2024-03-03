package com.ironhacklab.intro_jpa.Repository;

import com.ironhacklab.intro_jpa.Enums.CustomerStatus;
import com.ironhacklab.intro_jpa.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByCustomerStatus(CustomerStatus status);
    List<Customer> findAllByCustomerName(String name);

}
