package opencart.Controller;

import opencart.Model.Product;
import opencart.Service.OpenCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController{

    private final OpenCartService openCartService;

    @Autowired
    public CartController(OpenCartService openCartService) {
        this.openCartService = openCartService;
    }

    @GetMapping("/cart")
    public ModelAndView showCart(){
        return null;
    }

    @PostMapping("/addProduct")
    public ModelAndView addProductToCart(Product product){
        return null;
    }



}
