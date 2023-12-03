package pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Author 饮木
 * @Date 2022/7/15 17:31
 * @Description: TODO
 */
public class CatTest {

    @Test
    public void testToString() {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        Cat tom= (Cat) app.getBean("cat");
        System.out.println(tom);
    }
}