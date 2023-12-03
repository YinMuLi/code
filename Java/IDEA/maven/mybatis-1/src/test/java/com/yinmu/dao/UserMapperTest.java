package com.yinmu.dao;

import com.yinmu.pojo.User;
import com.yinmu.utils.MybatisUtility;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：饮木
 */
public class UserMapperTest extends TestCase {

    public void testGetUser() {
        //官方推荐的是使用try catch finally 的写法
        //在finally中关闭流
        SqlSession session = MybatisUtility.getSqlSession();
        //获得操作数据库接口接口的对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> user = mapper.getUser();
        for (User item : user) {
            System.out.println(item);
        }
        //关闭流
        session.close();
    }

    public void testQueryByID() {
        SqlSession session = MybatisUtility.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryByID(1);
        System.out.println(user);
        session.close();
    }

    public void testAddUser() {
        SqlSession session = MybatisUtility.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser(new User("张三", "5555"));
        //需要手动提交事务
        session.commit();
        session.close();
    }

    public void testUpdateByID() {
        SqlSession session = MybatisUtility.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateByID("李四", 3);
        session.commit();
        session.close();
    }

    public void testDeleteByID() {
        SqlSession session = MybatisUtility.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteByID(3);
        session.commit();
        session.close();
    }

    public void testTestAddUser() {
        SqlSession session = MybatisUtility.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("account", "石神千空");
        map.put("pwd", "15963");
        mapper.addUser(map);
        session.commit();
        session.close();
    }
}