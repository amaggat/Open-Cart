package opencart.Repository.DataJPA;

import opencart.Model.Order;
import opencart.Model.Product;
import opencart.Repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
    public void deleteById(Integer Id) {

    }

    @Override
    public Collection<Order> listAllOrders() {
        TypedQuery<Order> query = (TypedQuery<Order>) this.em.createQuery("SELECT o FROM Order o", Order.class);
        return (Collection<Order>) query.getResultList();
    }

}
