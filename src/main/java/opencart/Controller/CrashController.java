package opencart.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CrashController {
    @GetMapping("/oops")
    public String triggerException(){
        throw new RuntimeException("Expected: controller used to showcase what " +
                "happens when an exception is thrown");
    }
}
