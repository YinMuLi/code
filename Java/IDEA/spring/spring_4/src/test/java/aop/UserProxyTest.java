package aop;

import dao.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Author 饮木
 * @Date 2022/7/18 18:19
 * @Description TODO
 */
public class UserProxyTest {

    @Test
    public void before() {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user= (User) app.getBean("user");
        user.showGame();
    }
}