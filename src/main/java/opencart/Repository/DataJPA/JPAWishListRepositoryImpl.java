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
    public Collection<Product> findAllProductInWishList(Integer ID) {
        Query query = this.em.createNativeQuery("SELECT p.* FROM product p JOIN `wishlist-product` wp on p.productId = wp.productId JOIN wishlist w on wp.customerId = w.customerId WHERE w.customerId = :ID", Product.class);
        query.setParameter("ID", ID);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> addToCart(Integer productID, Integer customerID) {
        Query query = this.em.createNativeQuery("INSERT INTO `cart-product`(customerID, productID) VALUES(:customerID, :productID)", Product.class);
        query.setParameter("customerID", customerID).setParameter("productID", productID);
        return query.getResultList();
    }

    @Override
    public void removeProductInWishList(Product product) {
        Query query = this.em.createQuery("DELETE FROM wishlist-product wp WHERE wp.productID = :productID");
        query.setParameter("productID", product.getProductId());
//        Query query = em.createNativeQuery("DELETE FROM product WHERE " +
//                "productId = " + product.getProductId());
        query.executeUpdate();
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
        if(wishList.getCustomerId()==null) this.em.merge(wishList);
        else this.em.persist(wishList);
    }

    @Override
    @SuppressWarnings("unchecked")
    public WishList findWishListByID(Integer ID) {
        Query query = this.em.createQuery("SELECT w FROM WishList w WHERE w.customerId=:ID");
        query.setParameter("ID", ID);
        return (WishList) query.getSingleResult();
    }

}