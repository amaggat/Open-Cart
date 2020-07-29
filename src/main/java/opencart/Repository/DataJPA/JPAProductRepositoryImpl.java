package opencart.Repository.DataJPA;

import opencart.Model.Cart;
import opencart.Model.Product;
import opencart.Repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class JPAProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager em;

    //oke
    @Override
    public Collection<Product> findAllProduct() {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b",Product.class);
        return (Collection<Product>)q.getResultList();
    }

    //oke
    @Override
    public Collection<Product> findByName(String name) {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b WHERE b.name = :name", Product.class);
        q.setParameter("name", name);
        return (Collection<Product>) q.getResultList();
    }


//    @Override
//    public Collection<Product> findByBrandName(String brandName) {
//        TypedQuery<Product> q = em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Product.class);
//        q.setParameter("", brandName);
//        return q.getSingleResult();
//    }

    //oke
    @Override
    public Product findById(int ID) {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b WHERE b.id = :id", Product.class);
        q.setParameter("id", ID);
        return q.getSingleResult();
        //return em.find(Product.class, ID);
    }

    //oke
    @Override
    public Product save(Product b) {
        if (b.getId() == null) {
            em.persist(b);
        } else {
            b = em.merge(b);
        }
        return b;
    }

    //oke
    @Override
    public void deleteById(Integer ID) {
        Product b = em.find(Product.class,ID);
        if (em.contains(b)) {
            em.remove(b);
        } else {
            em.merge(b);
        }
    }

    @Override
    public Collection<Product> addToCart(int productID, int cartID) {
        return null;
    }

    @Override
    public Collection<Product> addToWishList(int productID, int wishListID) {
        return null;
    }
}
