package opencart.Controller;

import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Model.WishList;
import opencart.Service.ServiceInt.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.Collection;

@Controller
public class WishListController {
    @Autowired
    private  WishListService wishListService;

    @RequestMapping("/wishlist")
    public String showWishlist(Model model)
    {
        Collection<Product> wishListProducts = wishListService.showProductByWishList();
        model.addAttribute("wishlistProducts",wishListProducts);
        return "wishList";
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
