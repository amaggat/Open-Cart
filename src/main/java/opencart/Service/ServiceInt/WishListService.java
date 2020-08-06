package opencart.Service.ServiceInt;

import opencart.Model.Product;
import opencart.Model.WishList;

import java.util.Collection;

public interface WishListService {
    Collection<Product> showProductByWishList(Integer ID);

    void addProductToCart(Integer productID, Integer customerID);

    WishList findWishListByID(Integer ID);

    void removeProductFromWishList(Product product);

    Product findProductByID(Integer ID);

    void addToWishList(Integer productID, Integer customerID);

    void initWishlist(Integer ID);
}
