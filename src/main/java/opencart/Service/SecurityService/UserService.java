package opencart.Service.SecurityService;

import opencart.Model.Customer;

public interface UserService {
    void save(Customer customer);

    Customer findByUsername(String username);
}

