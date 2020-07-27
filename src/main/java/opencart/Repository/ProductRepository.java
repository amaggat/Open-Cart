/*
25/7/20
 */
package opencart.Repository;

import opencart.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.Collection;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    //    Collection<Product> findAllProduct();
    Collection<Product> findByName(String name);
//    Collection<Product> findByBrandName();
//    Product findById(int ID);
//    Collection<Product> addToCart (int productID, int cartID);
//    Collection<Product> addToWishList(int productID, int wishListID);
}
