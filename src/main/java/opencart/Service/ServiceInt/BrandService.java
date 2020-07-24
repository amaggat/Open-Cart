package opencart.Service.ServiceInt;

import opencart.Model.Brand;
import opencart.Model.Product;

import java.util.Collection;

public interface BrandService {
    Collection<Brand> findBrandByName(String name);
    Brand findBrandByID(Integer ID);
    Collection<Product> showProductByBrand();
    Collection<Product> removeProductFromBrand(Product product);
}
