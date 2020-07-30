package opencart.Repository.DataJPA;

import opencart.Model.Cart;
import opencart.Model.Product;
import opencart.Repository.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public Product findById(int ID) {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b WHERE b.id = :id", Product.class);
        q.setParameter("id", ID);
        return q.getSingleResult();
        //return em.find(Product.class, ID);
    }

    //oke
    @Override
    public void add(Product b) {
        Query query = this.em.createNativeQuery("INSERT INTO product " +
                "(productId, brandId, description, productName, quantity, dateAdded, dateModified, priceunit) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        query.setParameter(1, b.getId());
        query.setParameter(2, b.getBrand().getId());
        query.setParameter(3, b.getDescription());
        query.setParameter(4, b.getName());
        query.setParameter(5, b.getQuantity());
        query.setParameter(6, b.getDateAdded());
        query.setParameter(7, b.getDateModified());
        query.setParameter(8, b.getPrice());
        query.executeUpdate();
    }

    @Override
    public void save(Product b) {
        Query query = this.em.createQuery("UPDATE Product p " +
                "SET p.id=:pid, " +
                "p.brand.id=:bid, " +
                "p.description=:des, " +
                "p.name=:name, " +
                "p.quantity=:qtt, " +
                "p.dateAdded=:da, " +
                "p.dateModified=:dm, " +
                "p.price=:pr");
        query.setParameter("pid", b.getId());
        query.setParameter("bid", b.getBrand().getId());
        query.setParameter("des", b.getDescription());
        query.setParameter("name", b.getName());
        query.setParameter("qtt", b.getQuantity());
        query.setParameter("da", b.getDateAdded());
        query.setParameter("dm", b.getDateModified());
        query.setParameter("pr", b.getPrice());
        query.executeUpdate();
    }

    //oke
    @Override
    @Transactional
    public void deleteById(Integer ID) {
        em.getTransaction().begin();
        Query query = this.em.createQuery("SELECT p FROM Product p WHERE p.id = :ID");
        query.setParameter("ID", ID).executeUpdate();
        Product p = (Product) query.getSingleResult();
        em.remove(p);
        em.getTransaction().commit();
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
