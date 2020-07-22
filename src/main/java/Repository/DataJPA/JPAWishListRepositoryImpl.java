package Repository.DataJPA;

import Model.Cart;
import Model.Product;
import Model.WishList;
import Repository.WishListRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class JPAWishListRepositoryImpl implements WishListRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Product> findAllProductInWishList() {
        Query query = this.em.createQuery("SELECT productName FROM product p INNER JOIN wishlist-product wp ON wp.productID=p.productID INNER JOIN wishlist w ON w.customerID = wp.customerID");
        return query.getResultList();
    }

    @Override
    public void addToCart(Product product) {
        Cart cart = em.find(Cart.class, 1);
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

    @Override
    public void removeProductInWishList(Product product) {
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
    }

    @Override
    public void save(WishList wishList) {
        if(wishList.getId()==null) this.em.merge(wishList);
        else this.em.persist(wishList);
    }
}
