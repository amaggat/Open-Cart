package opencart.Service.ServiceInt;

import opencart.Model.Category;
import opencart.Model.Product;

import java.util.Collection;

public interface CategoryService {
    Collection<Category> findCategoryByName(String name);

    Category findCategoryByID(Integer ID);

    Collection<Product> showProductByCategory(Integer categoryID);
}
