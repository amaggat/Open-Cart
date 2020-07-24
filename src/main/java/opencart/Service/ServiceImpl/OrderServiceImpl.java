package opencart.Service.ServiceImpl;

import opencart.Model.Product;
import opencart.Repository.OrderRepository;
import opencart.Service.ServiceInt.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Collection<Product> showProductOrdered() {
        return orderRepository.showProductOrdered();
    }
}
