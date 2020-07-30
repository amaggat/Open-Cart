package opencart.Repository.DataJPA;

import opencart.Repository.OrderDetailRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JPAOrderDetailRepositoryImpl implements OrderDetailRepository {
    @PersistenceContext
    private EntityManager em;
}
