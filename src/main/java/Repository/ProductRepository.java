package Repository;

import Model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {
    Collection<Product> findAllProduct();
    Collection<Product> findByBrandName();
    Product findByID(int ID);
    void save(Product product);
    void addToCart (int productID, int cartID);
    void addToWishList(int productID, int wishListID);
}
