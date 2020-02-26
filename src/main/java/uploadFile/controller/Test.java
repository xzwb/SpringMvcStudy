package uploadFile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @RequestMapping(value = "/test")
    public String test(String name) {
        System.out.println(name);
        return "test";
    }
}
