package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import spittr.exception.NotFoundException;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public String test() {
        return "hello";
    }
}
