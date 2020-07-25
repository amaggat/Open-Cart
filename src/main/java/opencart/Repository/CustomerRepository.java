package opencart.Repository;

import opencart.Model.Customer;
import opencart.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerRepository extends JpaRepository<Role, Long> {
    Collection<Customer> findByAccountNameAndPassword (String accountName, String password);
    Collection<Customer> findCustomerByName (String customerName);
    Customer findCustomerByID(Integer ID);
    Customer findByUsername(String username);
}
