package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Author 饮木
 * @Date 2022/7/22 16:55
 * @Description TODO
 */
@Controller
public class MyController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 使用原生的servletAPI
     */
    @RequestMapping("/originServlet")
    public String originServlet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = request.getParameter("username");
        System.out.println(name);
        return "index";
    }

    @RequestMapping("/springServlet")
    public String springServlet(String hobby) {
        System.out.println(hobby);
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testPojo(User user) {
        System.out.println(user);
        return "success";
    }
}
