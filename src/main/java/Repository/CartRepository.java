package Repository;

import Model.Cart;
import Model.Product;

import java.util.Collection;
import java.util.List;

public interface CartRepository {
    Collection<Product> findAllProduct();
    void removeProductInCart (Product product);
    void addProduct(Product product);
    void addToWishList(Product product);
    void save (Cart cart);
}
