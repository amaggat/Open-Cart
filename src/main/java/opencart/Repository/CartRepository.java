package opencart.Repository;

import opencart.Model.Cart;
import opencart.Model.Product;

import java.util.Collection;

public interface CartRepository {
    Collection<Product> findAllProduct();
    Collection<Product> removeProductInCart (Product product);
    Collection<Product> addProduct(Integer productID, Integer customerID);
    Cart findCartByID(Integer ID);
    Collection<Cart> findCartByName (String name);
    Collection<Product> addToWishList(Product product);
    void save (Cart cart);
    Double checkOut();
}
