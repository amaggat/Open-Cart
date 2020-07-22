package Repository;

import Model.Brand;
import Model.Product;

import java.util.Collection;

public interface BrandRepository {
    Collection<Brand> findBrandByName(String name);
    Brand findBrandByID(int ID);
    void removeProductInBrand (int productID);
}
