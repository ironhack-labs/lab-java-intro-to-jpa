package ironhack.com.demo.repository;

import ironhack.com.demo.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import ironhack.com.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findFirstByCustomerName(String customerName);

    List<Customer> findByCustomerStatus(CustomerStatus Status);
}
