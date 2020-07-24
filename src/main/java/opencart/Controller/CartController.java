package opencart.Controller;

import opencart.Model.Cart;
import opencart.Model.Customer;
import opencart.Service.ServiceInt.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CartController{

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @InitBinder("customer")
    public void initCustomerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("cart")
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/cart.html")
    public ModelAndView showCart(){
        Cart cart = new Cart();
        ModelAndView mav = new ModelAndView();
        mav.addObject(this.cartService.showProductByCart());
        return mav;
    }

//    @ModelAttribute("customer")
//    public Customer findCustomer(@PathVariable("customerID") Integer customerId) {
//        return this.cartService.findCustomerByID(customerId);
//    }

    @ModelAttribute("cart")
    public Cart findCart(@PathVariable("cartID") Integer cartID) {
        return this.cartService.findCartByID(cartID);
    }

    @PostMapping(value = "/customer/{customerId}/cart/{cartID}/product/new")
    public String addProductToCart(@Valid Integer productID, @Valid Integer customerID, BindingResult result){
        if (result.hasErrors()) {
            return "cart/createOrUpdateProduct";
        } else {
            this.cartService.addProductToCart(productID, customerID);
            return "redirect:/cart/{customerID}";
        }
    }

    @GetMapping("/cart/checkout")
    public ModelAndView getCheckOut(){
        ModelAndView mav = new ModelAndView();
        mav.addObject(cartService.checkOutCart());
        return mav;
    }

}
