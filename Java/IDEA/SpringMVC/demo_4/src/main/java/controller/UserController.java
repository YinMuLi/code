package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author 饮木
 * @Date 2022/7/27 14:19
 * @Description TODO
 */
@Controller
public class UserController {
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String toPost() {
        System.out.println("POST");
        return "success";
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public String toPut() {
        System.out.println("PUT");
        return "success";
    }
}
