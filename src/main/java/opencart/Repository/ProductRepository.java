package opencart.Repository;

import opencart.Model.Product;

import java.util.Collection;

public interface ProductRepository {
    Collection<Product> findAllProduct();
    Collection<Product> findByName(String name);
    Collection<Product> findByBrandName();
    Product findByID(int ID);
    void save(Product product);
    Collection<Product> addToCart (int productID, int cartID);
    Collection<Product> addToWishList(int productID, int wishListID);
}
