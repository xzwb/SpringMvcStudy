package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

import javax.servlet.http.Part;
import java.io.IOException;

@Controller
public class UploadFileController {
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public String file(@RequestPart("file")Part part) {
        try {
            part.write(part.getSubmittedFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "home";
    }
}
