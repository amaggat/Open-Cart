package opencart.Repository.DataJPA;

import opencart.Model.Order;
import opencart.Model.Product;
import opencart.Repository.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class JPAOrderRepositoryImpl implements OrderRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Order> findOrderByID(int ID) {
        return null;
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public Collection<Product> showProductOrdered() {
        return null;
    }
}
