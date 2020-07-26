/*
25/7/20
 */
package opencart.Repository;

import opencart.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.Collection;
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product,Integer> {
    //    Collection<Product> findAllProduct();
    Collection<Product> findByName(String name);
    Collection<Product> findByBrandName();
    Product findByID(int ID);
//    void save(Product product);
//    void delete(Integer ID);


    Collection<Product> addToCart (int productID, int cartID);
    Collection<Product> addToWishList(int productID, int wishListID);
}
