package Repository;

import Model.Brand;

import java.util.List;

public interface BrandRepository {
    List<Brand> findBrandByName(String name);
    Brand findByID(int ID);
}
