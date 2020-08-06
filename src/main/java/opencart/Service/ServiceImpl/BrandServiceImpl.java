package opencart.Service.ServiceImpl;

import opencart.Model.Brand;
import opencart.Model.Product;
import opencart.Repository.BrandRepository;
import opencart.Service.ServiceInt.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    @Transactional
    public Collection<Brand> findBrandByName(String name) {
        return brandRepository.findBrandByName(name);
    }

    @Override
    @Transactional
    public Brand findBrandByID(Integer ID) {
        return brandRepository.findBrandByID(ID);
    }

    @Override
    @Transactional
    public Collection<Product> showProductByBrand(Integer ID) {
        return brandRepository.showProductInBrand(ID);
    }

    @Override
    @Transactional
    public Collection<Product> removeProductFromBrand(Product product) {
        return brandRepository.removeProductFromBrand(product.getProductId());
    }

    @Override
    @Transactional
    public Collection<Brand> showAllBrand() {
        return brandRepository.showAll();
    }
}
