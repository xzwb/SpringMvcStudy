package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import spittr.exception.NotFoundException;

@Controller
public class ExceptionController {
    @RequestMapping("/eTest")
    public String test() {
        throw new NotFoundException();
    }

    @ExceptionHandler(NotFoundException.class)
    public String test1() {
        return "home";
    }
}
