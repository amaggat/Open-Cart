package opencart.Repository;

import opencart.Model.Product;
import opencart.Model.WishList;

import java.util.Collection;


public interface WishListRepository {
    Collection<Product> findAllProductInWishList();
    Collection<Product> addToCart(Integer productId, Integer customerID);
    Collection<Product> removeProductInWishList (Product product);
    void save(WishList wishList);
    Collection<Product> addProduct(Integer productID, Integer customerID);
}
