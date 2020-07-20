package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController{
    @GetMapping("/cart")
    public ModelAndView showCart(){
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject("cart");
        return mav;
    }
}
