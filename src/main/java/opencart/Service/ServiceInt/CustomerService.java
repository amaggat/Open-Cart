package opencart.Service.ServiceInt;

import opencart.Model.Customer;

import java.util.Collection;

public interface CustomerService {
    Collection<Customer> findCustomerByName(String name);

    Customer findCustomerByID(Integer ID);

    Collection<Customer> showAllCustomer();

    Customer findCustomerByAccountAndPassword(String account, String password);

    void addCustomer(Customer customer);

    void saveUserInfo(Customer customer);
}
