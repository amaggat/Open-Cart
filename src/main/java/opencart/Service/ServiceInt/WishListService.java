package opencart.Service.ServiceInt;

import opencart.Model.Product;
import opencart.Model.WishList;

import java.util.Collection;

public interface WishListService {
    Collection<Product> showProductByWishList(Integer ID);
    Collection<Product> addProductToWishList(Integer productID, Integer customerID);
    WishList findWishListByID(Integer ID);
    void removeProductFromWishList(Product product);
    Product findProductByID(Integer ID);
}
