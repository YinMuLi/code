package pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Author 饮木
 * @Date 2022/7/16 13:10
 * @Description: TODO
 */
public class SteamTest {

    @Test
    public void testToString() {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        Steam a= (Steam) app.getBean("steam");
        Steam b= (Steam) app.getBean("steam");
        System.out.println(a==b);
    }
}