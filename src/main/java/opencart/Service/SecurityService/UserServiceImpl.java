package opencart.Service.SecurityService;

import opencart.Model.Customer;
import opencart.Repository.CustomerRepository;
import opencart.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Customer customer) {
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customer.setRole(new HashSet<>(roleRepository.findAll()));
        customerRepository.save(customer);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }
}