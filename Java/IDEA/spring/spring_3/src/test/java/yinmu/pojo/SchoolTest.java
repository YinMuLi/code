package yinmu.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Author 饮木
 * @Date 2022/7/17 12:23
 * @Description TODO
 */
public class SchoolTest {

    @Test
    public void testToString() {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        School school= (School) app.getBean("school");
        System.out.println(school);
    }
}