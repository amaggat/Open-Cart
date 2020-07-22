package Repository;

import Model.Category;
import Model.Product;

import java.util.Collection;

public interface CategoryRepository {
    Collection<Product> findProductByCategory(int CategoryID);
    Collection<Category> findCategoryByName (String categoryName);
    Collection<Category> findCategoryById (int categoryID);
    void save (Category category);
}
