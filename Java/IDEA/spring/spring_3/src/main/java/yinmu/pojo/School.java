package yinmu.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author 饮木
 * @Date 2022/7/17 12:20
 * @Description 在注解里面 value 属性值可以省略不写，
 * 默认值是类名称，首字母小写:School-->school
 */
@Component(value = "school")
public class School {
    @Value(value = "淮阴工学院")
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }
}
