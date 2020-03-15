package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spittr.pojo.User;

import java.util.ArrayList;
import java.util.List;

@Controller
// @org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/rest")
    @ResponseBody
    public User user(@RequestParam(
            defaultValue = "2"
    ) int id, @RequestParam(
            defaultValue = "yyf"
    ) String name) {
        User user = new User(1, "sss");
        return user;
    }

    @GetMapping("/rest1")
    @ResponseBody
    public List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "sss"));
        users.add(new User(2, "fff"));
        return users;
    }

//    @GetMapping("/rest/{id}")
//    public User user(@PathVariable int id) {
//        return new User(id, "yyf");
//    }

    @GetMapping("/rest/{id}")
    public ResponseEntity<User> entity(@PathVariable int id) {
        System.out.println(id);
        HttpStatus status = (id == 1 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        return new ResponseEntity<User>(new User(id, "yyf"), status);
    }
}
