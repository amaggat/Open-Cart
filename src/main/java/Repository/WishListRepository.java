package Repository;

import Model.Product;

import java.util.List;

public interface WishListRepository {
    List<Product> findAllProductInWishList();
    void addToCart(int productID, int customerID);
}
