package Repository.DataJPA;

import Model.Cart;
import Model.Product;
import Repository.CartRepository;

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
    public void removeProductInCart(Product product) {
        this.em.remove(product);
    }

    @Override
    public void save(Cart cart) {

    }
}
