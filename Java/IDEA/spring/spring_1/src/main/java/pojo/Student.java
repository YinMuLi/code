package pojo;

/**
 * @author 饮木
 * @Date 2022/7/13
 * @Description 学生类
 */
public class Student {
    String name;
    int age;

    public Student() {
        System.out.println("无参构造");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
