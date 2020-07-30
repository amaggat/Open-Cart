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


    //oke
    @Override
    public Product findById(int ID) {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b WHERE b.productId = :id", Product.class);
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
        query.setParameter(1, b.getProductId());
        query.setParameter(2, b.getBrand().getBrandId());
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
        Query query = this.em.createNativeQuery("UPDATE product p " +
                "SET " +
                "p.brandId=:bid, " +
                "p.description=:des, " +
                "p.productName=:name, " +
                "p.quantity=:qtt, " +
                "p.dateAdded=:da, " +
                "p.dateModified=:dm, " +
                "p.priceunit=:pr " +
                "WHERE p.productId = " + b.getProductId());
        //query.setParameter("id", b.getProductId());
        query.setParameter("bid", b.getBrand().getBrandId());
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
        Query query = em.createNativeQuery("DELETE FROM product WHERE " +
                "productId = " + ID);
        query.executeUpdate();
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
