package opencart.Repository;

import opencart.Model.Product;
import opencart.Model.WishList;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


public interface WishListRepository {
    Collection<Product> findAllProductInWishList(Integer ID);
    Collection<Product> addToCart(Integer productId, Integer customerID);
    Collection<Product> removeProductInWishList (Product product);
    void save(WishList wishList);
    WishList findWishListByID(Integer ID);
    Collection<Product> addProduct(Integer productID, Integer customerID);
    Product findProductByID(Integer ID);
}
