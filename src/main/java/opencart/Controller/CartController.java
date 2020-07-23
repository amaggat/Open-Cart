package opencart.Controller;

import opencart.Model.Cart;
import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Service.OpenCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.text.normalizer.NormalizerBase;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

@Controller
public class CartController{

    private final OpenCartService openCartService;

    @Autowired
    public CartController(OpenCartService openCartService) {
        this.openCartService = openCartService;
    }

    @InitBinder("cart")
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/cart.html")
    public ModelAndView showCart(){
        Cart cart = new Cart();
        ModelAndView mav = new ModelAndView();
        mav.addObject(this.openCartService.showCartProduct());
        return mav;
    }

    @ModelAttribute("customer")
    public Customer findCustomer(@PathVariable("customerID") Integer customerId) {
        return this.openCartService.findCustomerByID(customerId);
    }

    @ModelAttribute("cart")
    public Cart findCart(@PathVariable("cartID") Integer cartID) {
        return this.openCartService.findCartByID(cartID);
    }

    @PostMapping(value = "/customer/{customerId}/cart/{cartID}/product/new")
    public String addProductToCart(@Valid Integer productID, @Valid Integer customerID, BindingResult result){
        if (result.hasErrors()) {
            return "cart/createOrUpdateProduct";
        } else {
            this.openCartService.addProductToCart(productID, customerID);
            return "redirect:/cart/{customerID}";
        }
    }



}
