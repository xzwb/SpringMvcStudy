package uploadFile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uploadFile.exception.TestException;
import uploadFile.pojo.User;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@Controller
public class Test {
    @RequestMapping(value = "/test")
    public String test(String name) {
        System.out.println(name);
        return "test";
    }

    @RequestMapping(value = "/file")
    public String file() {
        return "uploadFile";
    }

    @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
    public String saveFile(@RequestPart("upfile")Part file) {
        try {
            file.write(file.getSubmittedFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/saveOk";
    }

    @RequestMapping(value = "/saveOk")
    public String saveOk() {
        return "hello";
    }

    @RequestMapping(value = "/josn")
    @ResponseBody
    public User user() {
        return new User(1, "杨一凡");
    }

    @RequestMapping(value = "/error")
    public String error() {
        int count = 0;
        if (count == 0) {
            throw new TestException();
        } else {
            return "hello";
        }
    }

    @RequestMapping(value = "/error1")
    public String error1() {
        int count = 0;
        errorTest(count);
        return "hello";
    }

    @ExceptionHandler(TestException.class)
    public String exceptionHandle() {
        return "test";
    }

    private void errorTest(int count) {
        if (count == 0) {
            throw new TestException();
        }
    }
}
