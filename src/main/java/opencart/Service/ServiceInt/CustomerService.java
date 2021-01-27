package opencart.Service.ServiceInt;

import opencart.Model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public interface CustomerService extends UserDetailsService {
    Customer findCustomerByName(String name);

    Customer findCustomerByID(Integer ID);

    Collection<Customer> showAllCustomer();

    Customer findCustomerByAccountAndPassword(String account, String password);

    void addCustomer(Customer customer);

    void saveUserInfo(Customer customer);
}
