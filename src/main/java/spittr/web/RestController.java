package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spittr.pojo.User;

//@Controller
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/rest")
//    @ResponseBody
    public User user(@RequestParam(
            defaultValue = "2"
    ) int id, @RequestParam(
            defaultValue = "yyf"
    ) String name) {
        User user = new User(1, "sss");
        return user;
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
