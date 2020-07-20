package Repository;

import Model.Category;
import Model.Product;

import java.util.List;

public interface CategoryRepository {
    List<Product> findProductByCategory(int CategoryID);
    void save (Category category);
}
