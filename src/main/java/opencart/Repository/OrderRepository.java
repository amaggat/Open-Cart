package opencart.Repository;

import opencart.Model.Order;

import java.util.Collection;

public interface OrderRepository {
    Collection<Order> findOrderByID(int ID);
    void save(Order order);
}
