package opencart.Repository.DataJPA;

import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    @Override
    public Customer findCustomerAccount(String accountName) {
        try {
            TypedQuery<Customer> q = em.createQuery("SELECT c FROM Customer c WHERE c.accountName = :accountName", Customer.class);
            q.setParameter("accountName", accountName);
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
