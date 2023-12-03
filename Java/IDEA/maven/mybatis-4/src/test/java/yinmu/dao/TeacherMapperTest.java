package yinmu.dao;

import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import yinmu.pojo.Teacher;
import yinmu.utils.MybatisUtility;

/**
 * 作者：饮木
 */
public class TeacherMapperTest extends TestCase {

    public void testQueryTeacher() {
        SqlSession session = MybatisUtility.getSqlSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.queryTeacher(1);
        System.out.println(teacher);
        session.close();
    }
}