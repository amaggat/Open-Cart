package Controller;

import Service.OpenCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WishListController {
    private final OpenCartService openCartService;

    public WishListController(OpenCartService openCartService) {
        this.openCartService = openCartService;
    }

    @GetMapping("/wishlist")
    public ModelAndView showWishList(){
        ModelAndView mav = new ModelAndView();
        mav.addObject(openCartService.showWishListProduct());
        return mav;
    }
}
