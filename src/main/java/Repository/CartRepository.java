package Repository;

import Model.Cart;

import java.util.List;

public interface CartRepository {
    List<Cart> findByID(int customerID);
}
