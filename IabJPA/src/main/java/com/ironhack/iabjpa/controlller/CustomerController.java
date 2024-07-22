package com.ironhack.iabjpa.controlller;

import com.ironhack.iabjpa.model.CustomerStatus;
import com.ironhack.iabjpa.model.Customer;
import com.ironhack.iabjpa.service.SpringJpaLab7Application;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomer(@PathVariable Integer customerId) {
        return customerService.findCustomerById(customerId);
    }
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/search/{name}")
    public List<Customer> getCustomersByName(@PathVariable String name) {
        return customerService.findByCustomerName(name);

    }
    @GetMapping("/search/{status}")
    public List<Customer> getCustomersByStatus(@PathVariable CustomerStatus status) {
        return customerService.findByCustomerStatus(status);

    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }
}
