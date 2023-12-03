package yinmu.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yinmu.boot.bean.User;
import yinmu.boot.mapper.UserMapper;

/**
 * @Author 饮木
 * @Date 2022/8/6 19:32
 * @Description TODO
 */
@RestController
public class TestController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/sql")
    public User test(int id){
        return userMapper.queryByIdUser(id);
    }
}
