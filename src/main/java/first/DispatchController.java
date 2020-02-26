package first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class DispatchController {
    /**
     * 转发
     * @return
     */
    @RequestMapping("/test1")
    public String test1() {
        return "WEB-INF/view/hello";
    }

    /**
     * 重定向
     * @return
     */
    @RequestMapping("/test2")
    public String test2() {
        // 要写完整的路径
        return "redirect:/hello.jsp";
    }
}
