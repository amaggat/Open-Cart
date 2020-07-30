/*
25/7/20
 */
package opencart.Controller;

import opencart.Model.Product;
import opencart.Service.ServiceInt.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String viewListProductPage(Model model) {
        Collection<Product> listProducts = productService.listAllProducts();
        model.addAttribute("listProducts", listProducts);
        return "list";
    }

    @RequestMapping(value="/new", method= RequestMethod.GET)
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        System.out.println(product.getName());
        productService.addProduct(product);
        System.out.println(product);
        return "redirect:/list";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") Integer id)
    {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        Product product = productService.findProductByID(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        System.out.println(product.getName());
        productService.saveProduct(product);
        System.out.println(product);
        return "redirect:/list";
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable(name = "id") Integer id)
    {
        ModelAndView modelAndView = new ModelAndView("delete");
        Product product = productService.findProductByID(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public String deleteProduct(@ModelAttribute("product") Product product) {
        System.out.println(product.getName());
        productService.deleteProduct(product.getProductId());
        System.out.println(product);
        return "redirect:/list";
    }
}
