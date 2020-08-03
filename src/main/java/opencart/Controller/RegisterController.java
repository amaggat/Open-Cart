package opencart.Controller;

import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Service.ServiceInt.CartService;
import opencart.Service.ServiceInt.CustomerService;
import opencart.Service.ServiceInt.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @Autowired
    private WishListService wishListService;

    @RequestMapping(value = {"/registerPage"}, method = RequestMethod.GET)
    public String viewRegisterPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "Login/registerPage";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("customer") Customer customer){
        customerService.addCustomer(customer);
        int customerID = customerService.findCustomerByAccountAndPassword(customer.getAccountName(), customer.getPassword()).getCustomerId();
        cartService.initCart(customerID);
        wishListService.initWishlist(customerID);
        return "redirect:/loginPage/";
    }
}
