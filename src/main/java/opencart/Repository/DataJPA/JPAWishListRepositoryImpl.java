package opencart.Repository.DataJPA;

import opencart.Model.Cart;
import opencart.Model.Product;
import opencart.Model.WishList;
import opencart.Repository.WishListRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

@Repository
public class JPAWishListRepositoryImpl implements WishListRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Product> findAllProductInWishList() {
        Query query = this.em.createQuery("SELECT p FROM Product p");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> addToCart(Integer productID, Integer customerID) {
//        Query query = this.em.createQuery("INSERT INTO cart-product(customerID, productID) VALUES(:customerID, :productID)");
//        query.setParameter("customerID", customerID).setParameter("productID", productID);
//        Collection<Product> products = query.getResultList();
        return null;
    }

    @Override
    public Collection<Product> removeProductInWishList(Product product) {
//        Query query = this.em.createQuery("DELETE FROM wishlist-product wp WHERE wp.productID = :productID");
//        query.setParameter("productID", product.getId());
//        Collection<Product> products = query.getResultList();
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> addProduct(Integer productId, Integer customerID) {
//        Query query = this.em.createQuery("\n" +
//                "INSERT INTO wishlist-product(customerID, productID) VALUES(:customerID, :productID)");
//        query.setParameter("productID", productId).setParameter("customerID", customerID);
//        Query query1 = this.em.createQuery("SELECT productName FROM product p " +
//                "INNER JOIN wishlist-product wp ON wp.productID = p.productID");
        return null;
    }

    //not
    @Override
    public Product findProductByID(Integer ID) {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b WHERE b.productId = :id", Product.class);
        q.setParameter("id", ID);
        return q.getSingleResult();
    }

    @Override
    public void save(WishList wishList) {
//        if(wishList.getId()==null) this.em.merge(wishList);
//        else this.em.persist(wishList);
    }

    @Override
    @SuppressWarnings("unchecked")
    public WishList findWishListByID(Integer ID) {
//        Query query = this.em.createQuery("SELECT customerName, customerID FROM customer cus" +
//                "INNER JOIN wishlist w ON w.customerID = cus.customerID" +
//                "WHERE cus.customerID = :ID");
//        WishList wishList = (WishList) query.setParameter("ID", ID).getSingleResult();
        return null;
    }

}