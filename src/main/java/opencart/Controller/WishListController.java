package opencart.Controller;

import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Service.ServiceInt.CustomerService;
import opencart.Service.ServiceInt.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class WishListController {
    @Autowired
    private WishListService wishListService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer/{ID}/wishlist")
    public String showWishlist(Model model, @PathVariable Integer ID)
    {
        Collection<Product> wishListProducts = wishListService.showProductByWishList(ID);
        model.addAttribute("wishlistProducts",wishListProducts);
        Customer customer = customerService.findCustomerByID(ID);
        model.addAttribute("customer", customer);
        return "wishlist";
    }

    @RequestMapping("/customer/{customerID}/wishlist/remove/{id}")
    public ModelAndView removeProductForm(@PathVariable("customerID") Integer customerID, @PathVariable("id") Integer id)
    {
        ModelAndView modelAndView = new ModelAndView("removeProductFromWishlist");
        Product product = wishListService.findProductByID(id);
        modelAndView.addObject("product",product);
        Customer customer = customerService.findCustomerByID(customerID);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @RequestMapping(value = "/customer/{customerID}/wishlist/remove/{id}/wishlist-remove", method = RequestMethod.POST)
    public String removeProduct(@ModelAttribute("product") Product product,
                                @PathVariable("customerID") Integer customerID,
                                @PathVariable("id") Integer id) {
        wishListService.removeProductFromWishList(product);
        System.out.println(product);
        return "redirect:/customer/" + customerID + "/wishlist";
    }
    @RequestMapping("/customer/{customerID}/wishlist/addtocart/{id}")
    public String AddtoWishlist(@PathVariable("customerID") Integer customerID,@PathVariable("id") Integer id)
    {
        Product product = wishListService.findProductByID(id);
        Customer customer = customerService.findCustomerByID(customerID);
        wishListService.addProductToCart(product.getProductId(),customer.getCustomerId());
        return "redirect:/customer/" + customerID + "/wishlist";
    }



}
