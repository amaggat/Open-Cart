package opencart.Repository;

import opencart.Model.Product;

import java.util.Collection;

public interface ProductRepository {
    Collection<Product> findAllProduct();
    Collection<Product> findByBrandName();
    Product findByID(int ID);
    void save(Product product);
    void addToCart (int productID, int cartID);
    void addToWishList(int productID, int wishListID);
}
