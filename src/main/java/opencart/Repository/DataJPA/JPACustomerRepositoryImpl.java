package opencart.Repository.DataJPA;

import opencart.Model.Customer;
import opencart.Repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class JPACustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Customer> findByAccountNameAndPassword(String accountName, String password) {
        return null;
    }

    @Override
    public Collection<Customer> findCustomerByName(String customerName) {
        return null;
    }

    @Override
    public Customer findCustomerByID(Integer ID) {
        return null;
    }
}
