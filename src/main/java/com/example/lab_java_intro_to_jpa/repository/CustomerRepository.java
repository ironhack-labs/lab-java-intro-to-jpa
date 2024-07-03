package com.example.lab_java_intro_to_jpa.repository;

import com.example.lab_java_intro_to_jpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerId(Integer customerId);
    List<Customer> findAllByCustomerName(String customerName);
    List<Customer> findAllByCustomerStatus(String customerStatus);
    List<Customer> findAllByTotalCustomerMileage(Integer totalCustomerMileage);
}
