package opencart.Controller;

import opencart.Service.OpenCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import opencart.Model.Product;

//@Controller
public class WishListController {
    private final OpenCartService openCartService;

    @Autowired
    public WishListController(OpenCartService openCartService) {
        this.openCartService = openCartService;
    }

    @GetMapping("/wishlist")
    public ModelAndView showWishList(){
        return null;
    }
    @PostMapping
    public ModelAndView addProductToWishList(Product product){
        return null;
    }
}
