package opencart.Service.ServiceInt;

import opencart.Model.*;

import java.util.Collection;

public interface OpenCartService {
    Collection<Product> showCartProduct();
    Collection<Product> showWishListProduct();
    Collection<Product> addProductToCart(Integer productID, Integer customerID);
    Collection<Product> addProductToWishList(Integer productID, Integer customerID);
    Collection<Product> findProductByName(String name);
    Product findProductByID(Integer ID);
    Collection<Cart> findCartByName (String name);
    Cart findCartByID(Integer ID);
    Double checkOutCart();
    WishList findWishListByID(Integer ID);
    Collection<Brand> findBrandByName(String name);
    Brand findBrandByID(Integer ID);
    Collection<Category> findCategoryByName(String name);
    Category findCategoryByID(Integer ID);
    Collection<Customer> findCustomerByName(String name);
    Customer findCustomerByID(Integer ID);
    Collection<Product> removeProductFromCart(Product product);
}
