package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spittr.exception.NotFoundException;

@Controller
public class TestController {
    @RequestMapping("/cTest")
    public void test() {
        throw new NotFoundException();
    }
}
