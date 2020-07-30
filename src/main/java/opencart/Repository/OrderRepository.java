package opencart.Repository;

import opencart.Model.Order;
import opencart.Model.Product;

import java.util.Collection;

public interface OrderRepository {
    Order findOrderByID(int ID);
    void save(Order order);
    void delete(Order order);
    Collection<Product> showProductOrdered();
}
