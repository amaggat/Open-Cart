package Repository;

import Model.Brand;

import java.util.List;

public interface BrandRepository {
    List<Brand> findBrand(String name);
    Brand findByID(int ID);
}
