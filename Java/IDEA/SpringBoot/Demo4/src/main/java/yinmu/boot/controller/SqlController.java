package yinmu.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yinmu.boot.bean.User;
import yinmu.boot.service.UserService;

/**
 * @Author 饮木
 * @Date 2022/8/6 16:26
 * @Description TODO
 */
@RestController
public class SqlController {
    @Autowired
    UserService userService;

    @RequestMapping("/sql")
    public User selectUser(@RequestParam("id") int id) {

        return userService.selectUser(id);
    }
    @GetMapping("/")
    public String test(){
        return "Hello SpringBoot";
    }
}
