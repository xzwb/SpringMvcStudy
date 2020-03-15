package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;

@Controller
public class UploadFileController {
    @RequestMapping(value = "/file1", method = RequestMethod.POST)
    public String file(@RequestPart("file")Part part, HttpServletRequest request) {
        try {
            String url = request.getSession().getServletContext().getRealPath("/") + part.getSubmittedFileName();
            System.out.println(url);
            part.write(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "1";
    }

    @RequestMapping("/up")
    public String up() {
        return "uploadFile";
    }

    @RequestMapping("/haha")
    public String haha() {
        return "1";
    }

    @RequestMapping("/try")
    public String tryss() {
        return "home";
    }
}
