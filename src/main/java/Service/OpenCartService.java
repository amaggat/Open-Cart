package Service;

import Model.Customer;
import Model.Product;

import java.util.Collection;

public interface OpenCartService {
    Collection<Product> showCartProduct();
    Collection<Product> showWishListProduct();
}
