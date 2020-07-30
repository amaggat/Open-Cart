package opencart.Controller;

import opencart.Model.Product;
import opencart.Service.ServiceInt.CartService;
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

    @RequestMapping("/cartlist")
    public String showCart(Model model){
        Collection<Product> cartProducts = cartService.showProductByCart();
        model.addAttribute("cartProducts",cartProducts);
        return "cartlist";
    }
    @RequestMapping("/remove-from-cart/{id}")
    public ModelAndView removeProductForm(@PathVariable("id") Integer id)
    {
        ModelAndView modelAndView = new ModelAndView("removeProductFromCart");
        Product product = cartService.findProductByID(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @RequestMapping(value = "/cartRemoveProduct", method = RequestMethod.POST)
    public String removeProduct(@ModelAttribute("product") Product product) {
        cartService.removeProductFromCart(product);
        System.out.println(product);
        return "redirect:/cartList";
    }

}
