package yinmu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 饮木
 * @Date 2022/8/4 12:32
 * @Description TODO
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String toHello(Model model){
        model.addAttribute("message","Hello SpringBoot");
        return "success";
    }
}
