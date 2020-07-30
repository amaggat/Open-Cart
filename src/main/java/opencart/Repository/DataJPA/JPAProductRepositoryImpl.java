package opencart.Repository.DataJPA;

import opencart.Model.Cart;
import opencart.Model.Product;
import opencart.Repository.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.*;
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
    public Product findById(int productID) {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b WHERE b.productId = :productId", Product.class);
        q.setParameter("productId", productID);
        return q.getSingleResult();
        //return em.find(Product.class, ID);
    }

    //oke
    @Override
    public void save(Product b) {
//        if (b.getId() == null) {
//            this.em.persist(b);
//        } else {
//            b = this.em.merge(b);
//        }
        Product product = new Product();
        product.setDateAdded(b.getDateAdded());
        product.setBrand(b.getBrand());
        product.setCarts(b.getCarts());
        product.setCategories(b.getCategories());
        product.setProductId(b.getProductId());
        product.setDateModified(b.getDateModified());
        product.setDescription(b.getDescription());
        product.setName(b.getName());
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    //oke
    @Override
    public void deleteById(Integer ID) {
//        Product b = em.find(Product.class,ID);
//        if (em.contains(b)) {
//            em.remove(b);
//        } else {
//            em.merge(b);
//        }
        Query query = this.em.createQuery("DELETE FROM Product p WHERE p.productId = " + ID);
        query.executeUpdate();
        //query.setParameter("id", ID).executeUpdate();
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
