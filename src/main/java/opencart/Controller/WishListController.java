package opencart.Controller;

import opencart.Model.Product;
import opencart.Service.ServiceInt.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "wishlist";
    }


//    @Autowired
//    public WishListController(WishListService wishListService) {
//        this.wishListService = wishListService;
//    }
//
//    @InitBinder("customer")
//    public void initCustomerBinder(WebDataBinder dataBinder) {
//        dataBinder.setDisallowedFields("id");
//    }
//
//    @InitBinder("wishlist")
//    public void setAllowedFields(WebDataBinder dataBinder) {
//        dataBinder.setDisallowedFields("id");
//    }
//
//    @GetMapping("/wishlist.html")
//    public ModelAndView showWishList(){
//        WishList wishList = new WishList();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject(this.wishListService.showProductByWishList());
//        return mav;
//    }
//
////    @ModelAttribute("customer")
////    public Customer findCustomer(@PathVariable("customerID") Integer customerId) {
////        return this.WishList.findCustomerByID(customerId);
////    }
//
//    @ModelAttribute("wishlist")
//    public WishList findWishList(@PathVariable("wishlistID") Integer wishlistID) {
//        return this.wishListService.findWishListByID(wishlistID);
//    }
//
//    @PostMapping(value = "/customer/{customerId}/wishlist/{wishlistID}/product/new")
//    public String addProductToWishList(@Valid Integer productID, @Valid Integer customerID, BindingResult result){
//        if (result.hasErrors()) {
//            return "wishlist/createOrUpdateProduct";
//        } else {
//            this.wishListService.addProductToWishList(productID, customerID);
//            return "redirect:/wishlist/{customerID}";
//        }
//    }

}
