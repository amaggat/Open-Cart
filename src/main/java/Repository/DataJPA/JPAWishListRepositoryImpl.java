package Repository.DataJPA;

import Model.Product;
import Model.WishList;
import Repository.WishListRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JPAWishListRepositoryImpl implements WishListRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Product> findAllProductInWishList() {
        return null;
    }

    @Override
    public void addToCart(int productID, int customerID) {

    }

    @Override
    public void removeProductInWishList(Product product) {

    }

    @Override
    public void save(WishList wishList) {

    }
}
