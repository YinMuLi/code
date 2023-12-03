package boot.controller;

import boot.bean.User;
import org.apache.tomcat.util.log.UserDataHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author 饮木
 * @Date 2022/8/4 15:35
 * @Description TODO
 */
@Controller
public class IndexController {
    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        if (user.getUserName().length() != 0 && user.getPassword().length() != 0) {
            session.setAttribute("user", user);
            return "redirect:/main";
        }
        model.addAttribute("message","账号或密码错误");
        return "login";
    }

    @RequestMapping("/main")
    public String main() {
        return "index";
    }
}
