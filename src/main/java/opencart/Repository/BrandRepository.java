package opencart.Repository;

import opencart.Model.Brand;
import opencart.Model.Product;

import java.util.Collection;

public interface BrandRepository {
    Collection<Brand> findBrandByName(String name);
    Brand findBrandByID(int ID);
    Collection<Product> removeProductInBrand (int productID);
}
