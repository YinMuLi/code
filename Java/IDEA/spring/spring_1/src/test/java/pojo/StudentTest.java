package pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testToString() {
        ///由spring容器创建对象
        //创建容器对象,启动的同时就创建了对象
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建对象
        Student saber= (Student) app.getBean("student");
        System.out.println(saber);
    }
}