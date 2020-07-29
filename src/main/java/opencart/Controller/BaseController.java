package opencart.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @RequestMapping(value={"/login", "/"})
    public String login() {
        return "login";
    }
    @RequestMapping("/user")
    public String user() {
        return "user";
    }
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
    @RequestMapping(value = {"/403", "/error"})
    public String accessDenied() {
        return "403";
    }
}