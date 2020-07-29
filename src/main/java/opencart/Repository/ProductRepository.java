/*
25/7/20
 */
package opencart.Repository;

import opencart.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.Collection;

public interface ProductRepository  {
    Collection<Product> findAllProduct();
    Collection<Product> findByName(String name);
//    Collection<Product> findByBrandName(String brandName);
    Product findById(int ID);
    public void save(Product product);
    public void deleteById(Integer ID);
    Collection<Product> addToCart (int productID, int cartID);
    Collection<Product> addToWishList(int productID, int wishListID);
}
