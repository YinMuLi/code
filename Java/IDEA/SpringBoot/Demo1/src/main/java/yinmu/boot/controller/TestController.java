package yinmu.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yinmu.boot.bean.Game;

/**
 * @Author 饮木
 * @Date 2022/8/2 18:59
 * @Description TODO
 */
@RestController
public class TestController {
    @Autowired
    Game game;
    @RequestMapping("/hello")
    public String toHello(){
        return "Hello SpringBoot!";
    }
    @RequestMapping("/game")
    public Game toGame(){
        return game;
    }
}
