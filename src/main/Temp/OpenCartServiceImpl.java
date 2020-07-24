package opencart.Service.ServiceImpl;

import opencart.Model.*;
import opencart.Repository.*;
import opencart.Service.ServiceInt.OpenCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class OpenCartServiceImpl implements OpenCartService {

    private final BrandRepository brandRepository;
    private final CartRepository cartRepository;
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final WishListRepository wishListRepository;

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

    @Override
    @Transactional
    public Collection<Product> addProductToCart(Integer productID, Integer customerID) {
        return cartRepository.addProduct(productID, customerID);
    }

    @Override
    @Transactional
    public Collection<Product> addProductToWishList(Integer productId, Integer customerID) {
        return wishListRepository.addProduct(productId, customerID);
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
    public Collection<Cart> findCartByName(String name) {
        return cartRepository.findCartByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Cart findCartByID(Integer ID) {
        return cartRepository.findCartByID(ID);
    }

    @Override
    public WishList findWishListByID(Integer ID) {
        return wishListRepository.findWishListByID(ID);
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
    @Transactional(readOnly = true)
    public Collection<Category> findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Category findCategoryByID(Integer ID) {
        return categoryRepository.findCategoryById(ID);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Customer> findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findCustomerByID(Integer ID) {
        return customerRepository.findCustomerByID(ID);
    }

    @Override
    @Transactional
    public Collection<Product> removeProductFromCart(Product product) {
        return cartRepository.removeProductInCart(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Double checkOutCart() {
        return cartRepository.checkOut();
    }

}
