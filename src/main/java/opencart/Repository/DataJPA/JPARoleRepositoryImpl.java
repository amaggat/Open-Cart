package opencart.Repository.DataJPA;

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
    public List<String> getRoleNames(Integer id) {
        try {
            TypedQuery<String> q = em.createQuery(
                    "SELECT role.name FROM Customer customer JOIN customer.roles role " +
                            "WHERE customer.customerId = :id", String.class);
            q.setParameter("id", id);
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
