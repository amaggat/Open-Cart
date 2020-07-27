/*
25/7/20
 */
package opencart.Controller;

import opencart.Model.Product;
import opencart.Service.ServiceInt.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String viewListProductPage(Model model)
    {
        Collection<Product> listProducts = productService.listAllProducts();
        model.addAttribute("listProducts",listProducts);
        return "list";
    }
    @RequestMapping("/new")
    public String showNewProductForm(Model model)
    {
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product)
    {
        productService.saveProduct(product);
        return "redirect:/list";
    }
}
