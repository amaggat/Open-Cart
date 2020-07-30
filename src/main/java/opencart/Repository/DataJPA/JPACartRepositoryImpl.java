package opencart.Repository.DataJPA;

import opencart.Model.Cart;
import opencart.Model.Product;
import opencart.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class JPACartRepositoryImpl implements CartRepository {

    @Autowired
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> findAllProduct() {
        Query query = this.em.createNativeQuery("SELECT * FROM product p" +
                "INNER JOIN `cart-product` cp ON cp.productId = pINNER.productId");
        query.executeUpdate();
        return query.getResultList();
    }

    @Override
    public void addToWishList(Product product, Integer customerID) {
        Query query = this.em.createNativeQuery("INSERT INTO `wishlist-product`(customerId, productId) " +
                "VALUES (?, ?)");
        query.setParameter(1, customerID);
        query.setParameter(2, product.getProductId());
        query.executeUpdate();
    }

    @Override
    public void removeProductInCart(Product product) {
        Query query = this.em.createNativeQuery("DELETE FROM `cart-product` cp WHERE cp.productId = " + product.getProductId());
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addProduct(Integer productID, Integer customerID) {
        Query query = this.em.createNativeQuery("INSERT INTO `cart-product`(customerId, productId) " +
                "VALUES (?, ?)");
        query.setParameter(1, customerID);
        query.setParameter(2, customerID);
        query.executeUpdate();
    }

    @Override
    public Cart findCartByID(Integer ID) {

        return null;
    }

    @Override
    public Collection<Cart> findCartByName(String name) {
        return null;
    }

    @Override
    public void save(Cart cart) {
//        if (cart.getCustomerId() == null) this.em.persist(cart);
//        else this.em.merge(cart);
    }

    @Override
    public Double checkOut() {
        return null;
    }

    @Override
    public Product findProductById(Integer ID)
    {
        return null;
    }
}
