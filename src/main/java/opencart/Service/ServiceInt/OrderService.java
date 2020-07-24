package opencart.Service.ServiceInt;

import opencart.Model.Product;

import java.util.Collection;

public interface OrderService {
    Collection<Product> showProductOrdered();
}
