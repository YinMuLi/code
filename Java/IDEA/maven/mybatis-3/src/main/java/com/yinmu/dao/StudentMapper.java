package com.yinmu.dao;

import com.yinmu.pojo.Student;

import java.util.List;

/**
 * 作者：饮木
 */
public interface StudentMapper {
    //查询所有学生
    List<Student> queryAllStudents();
}
