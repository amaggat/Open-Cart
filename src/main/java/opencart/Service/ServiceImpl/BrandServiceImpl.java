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
    @Transactional(readOnly = true)
    public Collection<Brand> findBrandByName(String name) {
        return brandRepository.findBrandByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Brand findBrandByID(Integer ID) {
        return brandRepository.findBrandByID(ID);
    }

    @Override
    public Collection<Product> showProductByBrand() {
        return brandRepository.showProductInBrand();
    }

    @Override
    public Collection<Product> removeProductFromBrand(Product product) {
        return brandRepository.removeProductFromBrand(product.getProductId());
    }
}
