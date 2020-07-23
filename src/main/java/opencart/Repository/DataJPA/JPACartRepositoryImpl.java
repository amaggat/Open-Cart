package opencart.Repository.DataJPA;

import opencart.Model.Cart;
import opencart.Model.Product;
import opencart.Model.WishList;
import opencart.Repository.CartRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class JPACartRepositoryImpl implements CartRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> findAllProduct() {
        Query query = this.em.createQuery(
                "SELECT productName FROM product p " +
                        "INNER JOIN cart-product cp ON cp.productId = p.productId " +
                        "INNER JOIN cart c ON c.customerId = cp.customerId");
        Collection<Product> products = query.getResultList();
        return products;
    }

    @Override
    public Collection<Product> addToWishList(Product product) {
        this.em.getTransaction().begin();
        this.em.persist(product);
        this.em.getTransaction().commit();
        Query query = this.em.createQuery(
                "SELECT * FROM product p " +
                        "INNER JOIN wishlist-product wp ON wp.productID = p.productID\n");
        return query.getResultList();
    }

    @Override
    public Collection<Product> removeProductInCart(Product product) {
        //DELETE FROM cart-product cp WHERE cp.productID = productID
        Query query = this.em.createQuery("DELETE FROM cart-product cp WHERE cp.productID = :productID", Product.class);
        Collection<Product> products = query.setParameter("productID", product.getId()).getResultList();
        return products;
    }

    @Override
    public Collection<Product> addProduct(Integer productID, Integer customerID) {
        Query query = this.em.createQuery("INSERT INTO cart-product(customerID, productID) VALUES (:customerId, :productID)");
        query.setParameter("productID", productID).setParameter("customerID", customerID).getResultList();
        Query query1 = this.em.createQuery(
                "SELECT productName FROM product p " +
                        "INNER JOIN cart-product cp ON cp.productID = p.productID");
        Collection<Product> products = query1.getResultList();
        return products;
    }

    @Override
    public Cart findCartByID(Integer ID) {
        Query query = this.em.createQuery("SELECT customerName cus FROM customer c" +
                "INNER JOIN cart c ON c.customerID = cus.customerID" +
                "WHERE cus.customerID = :ID");
        Cart cart = (Cart) query.setParameter("ID", ID).getSingleResult();
        return cart;
    }

    @Override
    public Collection<Cart> findCartByName(String name) {
        Query query = this.em.createQuery("SELECT customerName cus FROM customer c" +
                "INNER JOIN cart c ON c.customerID = cus.customerID" +
                "WHERE cus.customerName = :customerName");
        Collection<Cart> carts = query.setParameter("customerName", name).getResultList();
        return carts;
    }

    @Override
    public void save(Cart cart) {
        if (cart.getId() == null) this.em.persist(cart);
        else this.em.merge(cart);
    }
}
