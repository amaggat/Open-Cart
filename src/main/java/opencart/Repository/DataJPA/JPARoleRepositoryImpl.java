package opencart.Repository.DataJPA;

import opencart.Model.Customer;
import opencart.Model.CustomerRole;
import opencart.Repository.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JPARoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<String> getRoleNames(Integer customerId) {
        try {
            TypedQuery<String> q = em.createQuery("SELECT cr.role.name FROM CustomerRole cr WHERE cr.customer.ID = :customerId", String.class);
            q.setParameter("customerId", customerId);
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
