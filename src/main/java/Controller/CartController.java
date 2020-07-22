package Controller;

import Model.Product;
import Service.OpenCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.attribute.PosixFileAttributes;

@Controller
public class CartController{

    private final OpenCartService openCartService;

    @Autowired
    public CartController(OpenCartService openCartService) {
        this.openCartService = openCartService;
    }

    @GetMapping("/cart")
    public ModelAndView showCart(){
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject(openCartService.showCartProduct());
        return mav;
    }
}
