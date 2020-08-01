/*
25/7/20
 */
package opencart.Controller;

import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Service.ServiceInt.CustomerService;
import opencart.Service.ServiceInt.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Collection;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("{ID}/list")
    public String viewListProductPage(Model model, @PathVariable Integer ID) {
        Collection<Product> listProducts = productService.listAllProducts();
        model.addAttribute("listProducts", listProducts);
        Product product = new Product();
        model.addAttribute("product", product);
        Customer customer = customerService.findCustomerByID(ID);
        model.addAttribute("customer", customer);
        return "Product/list";
    }

    @RequestMapping(value="{ID}/list/new", method= RequestMethod.GET)
    public String showNewProductForm(Model model, @PathVariable Integer ID) {
        Product product = new Product();
        model.addAttribute("product", product);
        Customer customer = customerService.findCustomerByID(ID);
        model.addAttribute("customer", customer);
        return "Product/new_product";
    }

    @RequestMapping(value = "{ID}/list/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, @PathVariable Integer ID, Model model) {
        productService.addProduct(product);
        System.out.println(product);
        Customer customer = customerService.findCustomerByID(ID);
        model.addAttribute("customer", customer);
        return "redirect:/{ID}/list";
    }

    @RequestMapping("{customerID}/list/edit/{productID}")
    public ModelAndView editProduct(@PathVariable("productID") Integer productID, @PathVariable("customerID") Integer customerID)
    {
        ModelAndView modelAndView = new ModelAndView("Product/editProduct");
        Product product = productService.findProductByID(productID);
        modelAndView.addObject("product",product);
        Customer customer = customerService.findCustomerByID(customerID);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @RequestMapping(value = "{ID}/list/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product, @PathVariable Integer ID, Model model) {
        productService.saveProduct(product);
        System.out.println(product);
        Customer customer = customerService.findCustomerByID(ID);
        model.addAttribute("customer", customer);
        return "redirect:/{ID}/list";
    }
    @RequestMapping("{customerID}/list/delete/{productID}")
    public ModelAndView deleteProduct(@PathVariable(name = "productID") Integer id, @PathVariable("customerID") Integer ID)
    {
        ModelAndView modelAndView = new ModelAndView("Product/delete");
        Product product = productService.findProductByID(id);
        modelAndView.addObject("product",product);
        Customer customer = customerService.findCustomerByID(ID);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @RequestMapping(value = "{ID}/list/deleteProduct", method = RequestMethod.POST)
    public String deleteProduct(@ModelAttribute("product") Product product, @PathVariable Integer ID, Model model) {
        productService.deleteProduct(product.getProductId());
        System.out.println(product);
        Customer customer = customerService.findCustomerByID(ID);
        model.addAttribute("customer", customer);
        return "redirect:/{ID}/list";
    }

    @RequestMapping(value="{ID}/list/search")
    public String searchProduct(Model model, Product product, @PathVariable Integer ID) {
        Collection<Product> products = productService.findProductByName(product.getName());
        model.addAttribute("products", products);
        System.out.println(products);
        Product p = new Product();
        model.addAttribute("product", p);
        Customer customer = customerService.findCustomerByID(ID);
        model.addAttribute("customer", customer);
        return "Product/searchResult";
    }


}
