package Repository;

import Model.Product;
import Model.WishList;

import java.util.Collection;

public interface WishListRepository {
    Collection<Product> findAllProductInWishList();
    void addToCart(Product product);
    void removeProductInWishList (Product product);
    void save(WishList wishList);
}
