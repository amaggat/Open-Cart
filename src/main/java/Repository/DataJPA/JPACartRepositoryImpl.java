package Repository.DataJPA;

import Model.Product;
import Repository.CartRepository;
import org.graalvm.compiler.core.common.SuppressSVMWarnings;

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
        Query query = this.em.createQuery("");
        return null;
    }
}
