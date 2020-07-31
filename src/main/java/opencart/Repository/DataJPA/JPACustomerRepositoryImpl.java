package opencart.Repository.DataJPA;

import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collection;

@Repository
public class JPACustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer findByAccountNameAndPassword(String accountName, String password) {
        TypedQuery<Customer> query = this.em.createQuery("SELECT c FROM Customer c " +
                "WHERE c.accountName=:account AND c.password=:password", Customer.class);
        query.setParameter("account", accountName);
        query.setParameter("password", password);
        return query.getSingleResult();
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

    @Override
    public void addCustomer(Customer customer) {
        Query query = this.em.createNativeQuery("INSERT INTO customer " +
                "(firstName, lastName, email, phone, accountName, password, addressLine1, addressLine2, city, country) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        //query.setParameter(1, customer.getCustomerId());
        query.setParameter(1, customer.getFirstName());
        query.setParameter(2, customer.getLastName());
        query.setParameter(3, customer.getEmail());
        query.setParameter(4, customer.getPhoneNumber());
        query.setParameter(5, customer.getAccountName());
        query.setParameter(6, customer.getPassword());
        query.setParameter(7, customer.getAddressLine1());
        query.setParameter(8, customer.getAddressLine2());
        query.setParameter(9, customer.getCity());
        query.setParameter(10, customer.getCountry());
        query.executeUpdate();
    }
}
