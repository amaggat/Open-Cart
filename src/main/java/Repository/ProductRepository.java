package Repository;

import Model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAllProduct();
    Product findByID(int ID);
    void save(Product product);
    void addToCart (int productID, int cartID);
    void addToWishList(int productID, int wishListID);
}
