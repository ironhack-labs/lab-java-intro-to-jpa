package com.ironhack.LAB.Java.Intro.to.JPA.repository;

import com.ironhack.LAB.Java.Intro.to.JPA.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByCustomerName(String customerName);

    Optional<Customer> findByCustomerStatus(Enum customerStatus);


}
