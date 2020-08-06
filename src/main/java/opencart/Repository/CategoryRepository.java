package opencart.Repository;

import opencart.Model.Category;
import opencart.Model.Product;

import java.util.Collection;

public interface CategoryRepository {
    Collection<Product> findProductByCategory(int CategoryID);

    Collection<Category> findCategoryByName(String categoryName);

    Category findCategoryById(int categoryID);

    void save(Category category);
}
