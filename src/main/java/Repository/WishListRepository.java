package Repository;

import Model.Product;
import Model.WishList;

import java.util.List;

public interface WishListRepository {
    List<Product> findAllProductInWishList();
    void addToCart(int productID, int customerID);
    void removeProductInWishList (Product product);
    void save(WishList wishList);
}
