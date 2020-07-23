package opencart.Repository;

import opencart.Model.Product;
import opencart.Model.WishList;

import java.util.Collection;

public interface WishListRepository {
    Collection<Product> findAllProductInWishList();
    void addToCart(Product product);
    void removeProductInWishList (Product product);
    void save(WishList wishList);
}
