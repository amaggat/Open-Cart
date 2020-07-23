package opencart.Repository;

import opencart.Model.Cart;
import opencart.Model.Product;

import java.util.Collection;

public interface CartRepository {
    Collection<Product> findAllProduct();
    void removeProductInCart (Product product);
    void addProduct(Product product);
    void addToWishList(Product product);
    void save (Cart cart);
}
