package org.example.repository;
import org.example.model.Customer;
import org.example.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerName(String customerName);
    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
