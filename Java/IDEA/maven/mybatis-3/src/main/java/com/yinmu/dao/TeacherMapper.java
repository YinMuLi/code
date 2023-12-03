package com.yinmu.dao;

import com.yinmu.pojo.Teacher;

import java.util.List;

/**
 * 作者：饮木
 */
public interface TeacherMapper {
    //查询所有老师
    List<Teacher> queryAllTeachers();
}
