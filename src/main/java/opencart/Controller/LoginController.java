package opencart.Controller;

import opencart.Model.Customer;
import opencart.Service.ServiceInt.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class LoginController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String showLogin() {
        return "loginPage";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @RequestParam("accountName") String accountName,
                                     @RequestParam("password") String password) {
        ModelAndView mav = new ModelAndView("login");
//        mav.addObject("accountName", username);


        Customer customer = this.customerService.findCustomerByAccountAndPassword(accountName, password);


//        if (!results.isEmpty()) {
//            System.out.println("Vao duoc roi ban oi");
//            mav = new ModelAndView("welcome");
//            mav.addObject("accountName", accountName);
//        } else {
//            System.out.println("Ko vao duoc dau ban oi");
//            mav = new ModelAndView("login");
//            mav.addObject("message", "Username or Password is wrong!!");
//        }

        /*        System.out.println(login.getAccountName() + " " + login.getPassword());*/
        return mav;
    }
}
