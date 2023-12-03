package com.yinmu.dao;

import com.yinmu.pojo.Student;
import com.yinmu.utilis.MybatisUtility;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 作者：饮木
 */
public class StudentMapperTest extends TestCase {

    public void testQueryAllStudents() {
        SqlSession session = MybatisUtility.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryAllStudents();
        for (Student item : students) {
            System.out.println(item);
        }
        session.close();
    }
}