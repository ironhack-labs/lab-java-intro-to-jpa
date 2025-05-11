package com.ironhack.Lab304IntroToJPA202302.repository;

import com.ironhack.Lab304IntroToJPA202302.model.Customer;
import com.ironhack.Lab304IntroToJPA202302.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
Optional<Customer> findByCustomerName(String customerName);
List<Customer> findByCustomerStatus(CustomerStatus status);

}
