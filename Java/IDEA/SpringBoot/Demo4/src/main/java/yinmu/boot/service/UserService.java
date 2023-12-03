package yinmu.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yinmu.boot.bean.User;
import yinmu.boot.dao.UserMapper;

/**
 * @Author 饮木
 * @Date 2022/8/6 16:25
 * @Description TODO
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User selectUser(int id){
        return userMapper.selectUser(id);
    }
}
