package com.yinmu.dao;

import com.yinmu.pojo.Teacher;
import com.yinmu.utilis.MybatisUtility;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 作者：饮木
 */
public class TeacherMapperTest extends TestCase {

    public void testQueryAllTeachers() {
        SqlSession session = MybatisUtility.getSqlSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.queryAllTeachers();
        for (Teacher item : teachers) {
            System.out.println(item);
        }
        session.close();
    }
}