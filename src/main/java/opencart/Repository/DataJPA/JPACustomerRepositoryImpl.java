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
        TypedQuery<Customer> query = this.em.createQuery("SELECT c FROM Customer c " +
                "WHERE c.accountName=:account AND c.password=:password", Customer.class);
        query.setParameter("account", accountName);
        query.setParameter("password", password);
        return query.getResultList();
    }

    @Override
    public Collection<Customer> findCustomerByName(String customerName) {
        TypedQuery<Customer> query = this.em.createQuery("SELECT c FROM Customer c " +
                "WHERE c.lastName=:name OR c.firstName=:name", Customer.class);
        query.setParameter("name", customerName);
        return query.getResultList();
    }

    @Override
    public Customer findCustomerByID(Integer ID) {
        TypedQuery<Customer> query = this.em.createQuery("SELECT c FROM Customer c " +
                "WHERE c.customerId=:id", Customer.class);
        query.setParameter("id", ID);
        return query.getSingleResult();
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

    @Override
    public Collection<Customer> findAllCustomer() {
        TypedQuery<Customer> query = this.em.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }
}
