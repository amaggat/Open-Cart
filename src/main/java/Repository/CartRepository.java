package Repository;

import Model.Cart;
import Model.Product;

import java.util.Collection;
import java.util.List;

public interface CartRepository {
    List<Cart> findByID(int customerID);
    Collection<Product> findAllProduct();
}
