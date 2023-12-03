package yinmu.dao;

import yinmu.pojo.Teacher;

import java.util.List;

/**
 * 作者：饮木
 */
public interface TeacherMapper {
    //根据老师的序号查询该老师下面的所有学生
    Teacher queryTeacher(int id);
}
