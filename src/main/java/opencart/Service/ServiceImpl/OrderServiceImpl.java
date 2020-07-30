package opencart.Service.ServiceImpl;

import opencart.Model.Product;
import opencart.Repository.OrderDetailRepository;
import opencart.Repository.OrderRepository;
import opencart.Service.ServiceInt.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this. orderDetailRepository = orderDetailRepository;
    }

    @Override
    public Collection<Product> showProductOrdered() {
        return orderRepository.showProductOrdered();
    }
}
