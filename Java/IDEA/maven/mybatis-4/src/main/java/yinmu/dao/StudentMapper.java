package yinmu.dao;

import yinmu.pojo.Student;

import java.util.List;

/**
 * 作者：饮木
 */
public interface StudentMapper {
    //测试获取所有的学生
    public List<Student> queryAllStudents();
}
