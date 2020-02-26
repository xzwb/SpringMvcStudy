package first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/test1")
    public String test1() {
        System.out.println("HELLO WORLD !!");
        return "WEB-INF/view/hello";
    }

    @RequestMapping("/test2")
    public String test2(String name) {
        System.out.println(name);
        return "WEB-INF/view/hello";
    }

}
