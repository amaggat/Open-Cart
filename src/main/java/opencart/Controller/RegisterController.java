package opencart.Controller;

import opencart.Model.Customer;
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

    private final CustomerService customerService;

    private final CartService cartService;

    private final WishListService wishListService;

    @Autowired
    public RegisterController(CartService cartService, CustomerService customerService, WishListService wishListService) {
        this.cartService = cartService;
        this.customerService = customerService;
        this.wishListService = wishListService;
    }

    @RequestMapping(value = {"/registerPage"}, method = RequestMethod.GET)
    public String viewRegisterPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "Login/registerPage";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("customer") Customer customer) {
        customerService.addCustomer(customer);
        int customerID = customerService.findCustomerByAccountAndPassword(customer.getAccountName(), customer.getPassword()).getCustomerId();
        cartService.initCart(customerID);
        wishListService.initWishlist(customerID);
        return "redirect:/loginPage/";
    }
}
