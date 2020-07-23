package opencart.Repository;

import opencart.Model.Brand;

import java.util.Collection;

public interface BrandRepository {
    Collection<Brand> findBrandByName(String name);
    Brand findBrandByID(int ID);
    void removeProductInBrand (int productID);
}
