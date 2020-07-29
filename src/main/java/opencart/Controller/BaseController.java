package opencart.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
//    @GetMapping(value = "/welcome")
//    public String Welcome() {
//        return "welcome";
//    }
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
    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }
}