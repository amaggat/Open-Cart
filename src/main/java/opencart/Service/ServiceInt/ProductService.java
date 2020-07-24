package opencart.Service.ServiceInt;

import opencart.Model.Product;

import java.util.Collection;

public interface ProductService {
    Collection<Product> findProductByName(String name);
    Product findProductByID(Integer ID);
}
