package opencart.Repository.DataJPA;

import opencart.Model.Order;
import opencart.Model.Product;
import opencart.Repository.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class JPAOrderRepositoryImpl implements OrderRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Order findOrderByID(int ID) {
        Query query = this.em.createQuery("SELECT o FROM Order o WHERE o.orderId = :id");
        query.setParameter("id", ID);
        return (Order) query.getSingleResult();
    }

    @Override
    public void save(Order order) {
        Query query = this.em.createNativeQuery("UPDATE `order` o " +
                "SET o.orderId=:oid, o.customerId=:cusid, o.orderDate=:od, o.requiredDate=:rd, o.shippedDate=:sd, o.status=:os " +
                "WHERE o.orderId=" + order.getOrderId());
        query.executeUpdate();
    }

    @Override
    public void delete(Order order) {
        Query query = this.em.createQuery("DELETE FROM Order o WHERE o.orderId = :ID");
        query.setParameter("ID", order.getOrderId()).executeUpdate();
    }

    @Override
    public Collection<Product> showProductOrdered() {
        return null;
    }
}
