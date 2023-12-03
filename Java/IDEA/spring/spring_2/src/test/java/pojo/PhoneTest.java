package pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Author 饮木
 * @Date 2022/7/17 11:35
 * @Description TODO
 */
public class PhoneTest {

    @Test
    public void testToString() {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        People people= (People) app.getBean("people");
        System.out.println(people);
    }
}