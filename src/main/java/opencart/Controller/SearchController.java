package opencart.Controller;

import opencart.Service.OpenCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SearchController {
    private final OpenCartService openCartService;

    @Autowired
    public SearchController(OpenCartService openCartService){
        this.openCartService = openCartService;
    }

}
