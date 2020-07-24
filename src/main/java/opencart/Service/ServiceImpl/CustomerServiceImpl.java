package opencart.Service.ServiceImpl;

import opencart.Model.Customer;
import opencart.Repository.CustomerRepository;
import opencart.Service.ServiceInt.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Customer> findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findCustomerByID(Integer ID) {
        return customerRepository.findCustomerByID(ID);
    }
}
