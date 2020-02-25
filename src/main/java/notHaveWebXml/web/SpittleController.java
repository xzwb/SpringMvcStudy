package notHaveWebXml.web;

import notHaveWebXml.data.SpittleRepository;
import notHaveWebXml.pojo.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/list")
public class SpittleController {
    @Autowired
    SpittleRepository spittleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Spittle> list = spittleRepository.findSpittle();
        model.addAttribute("spittleList", list);
        return "list";
    }
}
