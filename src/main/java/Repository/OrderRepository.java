package Repository;

import Model.Order;

import java.util.Collection;
import java.util.List;

public interface OrderRepository {
    Collection<Order> findOrderByID(int ID);
    void save(Order order);
}
