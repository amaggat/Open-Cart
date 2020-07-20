package Repository.DataJPA;

import Model.Product;
import Repository.WishListRepository;

import java.util.List;

public class JPAWishListRepositoryImpl implements WishListRepository {

    @Override
    public List<Product> findAllProductInWishList() {
        return null;
    }

    @Override
    public void addToCart(int productID, int customerID) {

    }
}
