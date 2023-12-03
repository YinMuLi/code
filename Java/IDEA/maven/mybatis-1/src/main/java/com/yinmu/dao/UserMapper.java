package com.yinmu.dao;

import com.yinmu.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 作者：饮木
 */
public interface UserMapper {
    //查询所有数据
    List<User> getUser();

    //根据ID查询数据
    User queryByID(int id);

    //插入数据
    void addUser(User user);

    void addUser(Map map);

    //更新数据
    void updateByID(String account, int id);

    //删除数据
    void deleteByID(int id);
}
