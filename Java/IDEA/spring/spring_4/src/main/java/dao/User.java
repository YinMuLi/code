package dao;

import org.springframework.stereotype.Component;

/**
 * @Author 饮木
 * @Date 2022/7/18 18:07
 * @Description 被代理的类
 */
@Component
public class User {
    /**
     * 被增强的方法
     */
    public void showGame(){
//        int a=10/0;
        System.out.println("执行方法");
    }
}
