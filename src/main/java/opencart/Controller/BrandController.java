package opencart.Controller;

import opencart.Model.Brand;
import opencart.Model.Customer;
import opencart.Model.Product;
import opencart.Service.ServiceInt.BrandService;
import opencart.Service.ServiceInt.CustomerService;
import opencart.Service.ServiceInt.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class BrandController {
    private final BrandService brandService;
    private final CustomerService customerService;
    private final ProductService productService;

    @Autowired
    public BrandController(BrandService brandService, CustomerService customerService, ProductService productService) {
        this.brandService = brandService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @RequestMapping("/{ID}/list/brands")
    public String showAllBrands(@PathVariable Integer ID, Model model) {
        Collection<Brand> brands = brandService.showAllBrand();
        model.addAttribute("brands", brands);
        Customer customer = customerService.findCustomerByID(ID);
        model.addAttribute("customer", customer);
        Product product = new Product();
        model.addAttribute("product", product);
        return "Brand/list";
    }

    @RequestMapping("/{ID}/list/brands/{brandID}")
    public String showBrandByName(@PathVariable Integer ID, Model model, @PathVariable Integer brandID) {
        Collection<Product> productList = brandService.showProductByBrand(brandID);
        model.addAttribute("productList", productList);
        Customer customer = customerService.findCustomerByID(ID);
        model.addAttribute("customer", customer);
        Product product = new Product();
        model.addAttribute("product", product);
        return "Brand/brandsearch";
    }

}
