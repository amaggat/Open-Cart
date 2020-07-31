package opencart.Controller;

import opencart.Model.Order;
import opencart.Service.ServiceInt.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderlist")
    public String viewOrderList(Model model) {
        Collection<Order> listOrders = orderService.listAllOrder();
        model.addAttribute("listOrders", listOrders);
        return "order-list";
    }
}