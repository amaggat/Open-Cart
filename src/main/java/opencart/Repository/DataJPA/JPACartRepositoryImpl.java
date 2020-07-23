package opencart.Repository.DataJPA;

import opencart.Model.Cart;
import opencart.Model.Product;
import opencart.Model.WishList;
import opencart.Repository.CartRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

public class JPACartRepositoryImpl implements CartRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> findAllProduct() {
        Query query = this.em.createQuery("SELECT productName FROM product p INNER JOIN cart-product cp ON cp.productId = p.productId INNER JOIN cart c ON c.customerId = cp.customerId");
        return query.getResultList();
    }

    @Override
    public void addToWishList(Product product) {
        WishList wishlist = em.find(WishList.class, 1);
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

    @Override
    public void removeProductInCart(Product product) {
        this.em.getTransaction().begin();
        this.em.remove(product);
        this.em.getTransaction().commit();
    }

    @Override
    public void addProduct(Product product) {
        this.em.getTransaction().begin();
        this.em.merge(product);
        this.em.getTransaction().commit();
    }

    @Override
    public void save(Cart cart) {
        if (cart.getId() == null) this.em.persist(cart);
        else this.em.merge(cart);
    }
}
