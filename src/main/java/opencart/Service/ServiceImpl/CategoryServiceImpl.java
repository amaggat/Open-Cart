package opencart.Service.ServiceImpl;

import opencart.Model.Category;
import opencart.Model.Product;
import opencart.Repository.CategoryRepository;
import opencart.Service.ServiceInt.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Collection<Category> findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    @Transactional
    public Category findCategoryByID(Integer ID) {
        return categoryRepository.findCategoryById(ID);
    }

    @Override
    public Collection<Product> showProductByCategory(Integer categoryID) {
        return categoryRepository.findProductByCategory(categoryID);
    }
}
