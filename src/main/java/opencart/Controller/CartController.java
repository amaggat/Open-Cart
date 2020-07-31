package opencart.Controller;

import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Service.ServiceInt.CartService;
import opencart.Service.ServiceInt.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class CartController{

    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer/{ID}/cart")
    public String showCart(Model model, @PathVariable Integer ID){
        Collection<Product> cartProducts = cartService.showProductByCart(ID);
        model.addAttribute("cartProducts",cartProducts);
        Customer customer = customerService.findCustomerByID(ID);
        model.addAttribute("customer", customer);
        return "cart";
    }
    @RequestMapping("/customer/{customerID}/cart/remove/{id}")
    public ModelAndView removeProductForm(@PathVariable("customerID") Integer customerID, @PathVariable("id") Integer id)
    {
        ModelAndView modelAndView = new ModelAndView("removeProductFromCart");
        Product product = cartService.findProductByID(id);
        modelAndView.addObject("product",product);
        Customer customer = customerService.findCustomerByID(customerID);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @RequestMapping(value = "/customer/{customerID}/cart/remove/{id}/cart-remove", method = RequestMethod.POST)
    public String removeProduct(@ModelAttribute("product") Product product,
                                @PathVariable("customerID") Integer customerID,
                                @PathVariable("id") Integer id) {
        cartService.removeProductFromCart(product);
        System.out.println(product);
        return "redirect:/customer/" + customerID + "/cart";
    }

}
