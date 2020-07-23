package opencart.Repository;

import opencart.Model.Customer;

import java.util.Collection;

public interface CustomerRepository {
    Collection<Customer> findByAccountNameAndPassword (String accountName, String password);
    Collection<Customer> findCustomerByName (String customerName);
}
