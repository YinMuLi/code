package pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Author 饮木
 * @Date 2022/7/15 18:39
 * @Description: TODO
 */
public class PersonTest {

    @Test
    public void testToString() {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person jack= (Person) app.getBean("person");
        System.out.println(jack);
    }
}