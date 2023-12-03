package com.lhc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhc.pojo.User;

/**
* @author yinmu
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2023-10-26 19:43:45
*/
public interface UserService extends IService<User> {

    User login(String username, String password);
}
