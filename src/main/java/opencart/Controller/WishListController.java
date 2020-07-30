package opencart.Controller;

import opencart.Model.Product;
import opencart.Service.ServiceInt.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class WishListController {
    @Autowired
    private  WishListService wishListService;

    @RequestMapping("/customer/{customerID}/wishlist")
    public String showWishlist(Model model, @PathVariable("customerID") Integer ID)
    {
        Collection<Product> wishListProducts = wishListService.showProductByWishList(ID);
        model.addAttribute("wishlistProducts",wishListProducts);
        return "wishlist";
    }

    @RequestMapping("/wishlist/remove/{id}")
    public ModelAndView removeProductForm(@PathVariable("id") Integer id)
    {
        ModelAndView modelAndView = new ModelAndView("removeProductFromWishlist");
        Product product = wishListService.findProductByID(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @RequestMapping(value = "/wishlistRemoveProduct", method = RequestMethod.POST)
    public String removeProduct(@ModelAttribute("product") Product product) {
        wishListService.removeProductFromWishList(product);
        return "redirect:/wishlist";
    }

}
