package opencart.Service.ServiceInt;

import opencart.Model.Cart;
import opencart.Model.Product;

import java.util.Collection;

public interface CartService {
    Collection<Cart> findCartByName(String name);

    Cart findCartByID(Integer ID);

    Double checkOutCart();

    Collection<Product> showProductByCart(Integer ID);

    void addProductToWishList(Integer productID, Integer customerID);

    void removeProductFromCart(Product product);

    Product findProductByID(Integer ID);

    void addToCart(Integer productID, Integer customerID);

    void initCart(Integer ID);

    void clear(Integer ID);
}
