package opencart.Controller;

import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Service.ServiceInt.CustomerService;
import opencart.Service.ServiceInt.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer")
    public String showCustomer(Model model)
    {
        Collection<Customer> listCustomer = customerService.showAllCustomer();
        model.addAttribute("listCustomer",listCustomer);
        return "customer";
    }
    @RequestMapping("/customer/{id}")
    public ModelAndView editCustomer(@PathVariable("id") Integer id)
    {
        ModelAndView modelAndView = new ModelAndView("access");
        Customer customer = customerService.findCustomerByID(id);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String checkCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.findCustomerByAccountAndPassword(customer.getAccountName(),customer.getPassword());
        return "/customerinfo";
    }

}
