package opencart.Service.ServiceImpl;

import opencart.Model.Product;
import opencart.Model.WishList;
import opencart.Repository.WishListRepository;
import opencart.Service.ServiceInt.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;

    @Autowired
    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    @Transactional
    public Collection<Product> showProductByWishList(Integer ID) {
        return wishListRepository.findAllProductInWishList(ID);
    }

    @Override
    @Transactional
    public Collection<Product> addProductToWishList(Integer productId, Integer customerID) {
        return wishListRepository.addProduct(productId, customerID);
    }

    @Override
    @Transactional
    public WishList findWishListByID(Integer ID) {
        return wishListRepository.findWishListByID(ID);
    }

    @Override
    @Transactional
    public Collection<Product> removeProductFromWishList(Product product) {
        return wishListRepository.removeProductInWishList(product);
    }

    //null
    @Override
    @Transactional
    public Product findProductByID(Integer ID) {
        return wishListRepository.findProductByID(ID);
    }
}
