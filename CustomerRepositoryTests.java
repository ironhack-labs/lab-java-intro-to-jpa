import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void testCreateNewCustomer() {
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setStatus("Gold");
        Customer savedCustomer = repository.save(customer);
        assertNotNull(savedCustomer.getId());
    }

    @Test
    public void testFindCustomerByName() {
        // similar setup as above and then
        Customer foundCustomer = repository.findByName("John Doe");
        assertNotNull(foundCustomer);
    }

    @Test
    public void testFindCustomerByStatus() {
        // similar setup as above and then
        Customer foundCustomer = repository.findByStatus("Gold");
        assertNotNull(foundCustomer);
    }
}
