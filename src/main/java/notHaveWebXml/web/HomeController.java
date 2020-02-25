package notHaveWebXml.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping(value = "/home1", method = RequestMethod.GET)
    public String home() {
        System.out.println("home");
        return "home";
    }

//    @RequestMapping(value = "home2", method = RequestMethod.GET)
//    public String home1() {
//        return "home";
//    }
}
