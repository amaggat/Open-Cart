package opencart.Controller;

import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Service.ServiceInt.CustomerService;
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

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/{ID}/customer/info")
    public String checkCustomer(@PathVariable Integer ID, Model model) {
        try {
            Customer customer = customerService.findCustomerByID(ID);
            model.addAttribute("customer", customer);
            return "Customer/customerinfo";
        } catch (Exception e) {
            return "403Page";
        }
    }

    @RequestMapping(value = "/{ID}/customer/info/edit/save", method = RequestMethod.POST)
    public String saveInfo(@ModelAttribute("customer") Customer customer, @PathVariable Integer ID, Model model){
        customerService.saveUserInfo(customer);
        System.out.println(customer);
        return "redirect:/{ID}/customer/info";
    }

    @RequestMapping(value = "/{ID}/customer/info/edit")
    public ModelAndView editUser(@PathVariable("ID") Integer customerID)
    {
        ModelAndView modelAndView = new ModelAndView("Customer/customeredit");
        Customer customer = customerService.findCustomerByID(customerID);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

}
