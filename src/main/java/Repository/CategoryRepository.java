package Repository;

import Model.Product;

import java.util.List;

public interface CategoryRepository {
    List<Product> findProductByCategory(int CategoryID);
}
