/*
25/7/20
 */
package opencart.Service.ServiceImpl;

import opencart.Model.Product;
import opencart.Repository.ProductRepository;
import opencart.Service.ServiceInt.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductByID(Integer ID) {
        return productRepository.findByID(ID);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Product> listAllProducts()
    {
        return productRepository.findAll();//findAllProduct();
    }

    @Override
    @Transactional(readOnly = true)
    public void saveProduct(Product product)
    {
        productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteProduct(Integer ID)
    {
        productRepository.deleteById(ID);
    }

}
