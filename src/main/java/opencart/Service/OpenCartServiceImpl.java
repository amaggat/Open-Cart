package opencart.Service;

import opencart.Model.Product;
import opencart.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class OpenCartServiceImpl implements OpenCartService{

    private BrandRepository brandRepository;
    private CartRepository cartRepository;
    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private WishListRepository wishListRepository;

    @Autowired
    public OpenCartServiceImpl(BrandRepository brandRepository,
                               CartRepository cartRepository,
                               CategoryRepository categoryRepository,
                               CustomerRepository customerRepository,
                               OrderRepository orderRepository,
                               ProductRepository productRepository,
                               WishListRepository wishListRepository){
        this.brandRepository = brandRepository;
        this.cartRepository = cartRepository;
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.wishListRepository = wishListRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Product> showCartProduct() {
        return cartRepository.findAllProduct();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Product> showWishListProduct() {
        return wishListRepository.findAllProductInWishList();
    }

}
