package opencart.Controller;

import opencart.Service.ServiceInt.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = {"/registerPage"}, method = RequestMethod.GET)
    public String viewRegisterPage() {
        return "Login/registerPage";
    }
}
