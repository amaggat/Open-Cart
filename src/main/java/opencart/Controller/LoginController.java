package opencart.Controller;

import opencart.Model.Customer;
import opencart.Service.ServiceInt.CartService;
import opencart.Service.ServiceInt.CustomerService;
import opencart.Service.ServiceInt.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Controller
public class LoginController {
    private final CustomerService customerService;

    private final CartService cartService;

    private final WishListService wishListService;

    @Autowired
    public LoginController(CustomerService customerService, CartService cartService, WishListService wishListService) {
        this.customerService = customerService;
        this.cartService = cartService;
        this.wishListService = wishListService;
    }

    @RequestMapping(value = "/loginPage")
    public String showLogin(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "Login/loginPage";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("customer") Customer customer) {
        try {
            customerService.findCustomerByAccountAndPassword(customer.getAccountName(), customer.getPassword());
            int customerID = customerService.findCustomerByAccountAndPassword(customer.getAccountName(), customer.getPassword()).getCustomerId();
            return "redirect:/" + customerID + "/list";
        } catch (Exception e) {
            return "redirect:/registerPage";
        }
    }

}
