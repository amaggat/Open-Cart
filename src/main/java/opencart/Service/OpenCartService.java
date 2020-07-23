package opencart.Service;

import opencart.Model.Product;

import java.util.Collection;

public interface OpenCartService {
    Collection<Product> showCartProduct();
    Collection<Product> showWishListProduct();
}
