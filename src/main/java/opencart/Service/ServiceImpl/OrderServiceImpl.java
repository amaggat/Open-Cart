package opencart.Service.ServiceImpl;

import opencart.Model.Order;
import opencart.Model.Product;
import opencart.Repository.OrderDetailRepository;
import opencart.Repository.OrderRepository;
import opencart.Service.ServiceInt.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

//    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
//        this. orderDetailRepository = orderDetailRepository;
    }

    @Override
    @Transactional
    public Collection<Order> listAllOrder() {
        return orderRepository.listAllOrders();
    }

//    @Override
//    public void removeOrder(Order order) {
//        orderRepository.delete(order);
//    }
}
