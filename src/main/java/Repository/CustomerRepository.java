package Repository;

import Model.Customer;

import java.util.Collection;

public interface CustomerRepository {
    Collection<Customer> findByLastName (String lastName);
    Customer findByID(int ID);
    void save (Customer customer);
}
