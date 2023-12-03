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

    public void testQueryByID() {
        SqlSession session = MybatisUtility.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 1);
        map.put("offset", 3);
        List<User> user = mapper.queryLimit(map);
        for (User item : user) {
            System.out.println(item);
        }
        session.close();
    }
}