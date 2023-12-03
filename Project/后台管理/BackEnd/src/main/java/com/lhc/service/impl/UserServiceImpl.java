package com.lhc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhc.mapper.UserMapper;
import com.lhc.pojo.User;
import com.lhc.service.UserService;
import com.lhc.utils.Result;
import com.lhc.utils.ServiceException;
import org.springframework.stereotype.Service;

/**
 * @author yinmu
 * @description 针对表【user(用户)】的数据库操作Service实现
 * @createDate 2023-10-26 19:43:45
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public User login(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password", password);
        User one = getOne(wrapper);
        if (one != null) {
            return one;
        }
        throw new ServiceException(Result.ERROR, "账号或密码错误");
    }
}




