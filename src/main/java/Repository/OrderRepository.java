package Repository;

import Model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findOrderByID(int ID);
    void save(Order order);
}
