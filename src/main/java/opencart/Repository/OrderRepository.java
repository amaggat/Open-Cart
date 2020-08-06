package opencart.Repository;

import opencart.Model.Order;

import java.util.Collection;

public interface OrderRepository {
    Order findOrderByID(int ID);

    void save(Order order);

    void deleteById(Integer Id);

    Collection<Order> listAllOrders();
//    void add(Order order);
}
