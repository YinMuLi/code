package pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import javax.sound.midi.Soundbank;

import static org.junit.Assert.*;

/**
 * @Author 饮木
 * @Date 2022/7/17 10:36
 * @Description TODO
 */
public class BookTest {

    @Test
    public void testToString() {
        //这个子类有关闭IOC的方法
        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book= (Book) app.getBean("book");
        System.out.println("第四步：获取bean对象 ");
        //手动关闭IOC容器
        app.close();
    }
}