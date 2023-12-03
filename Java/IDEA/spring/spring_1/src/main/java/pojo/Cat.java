package pojo;

/**
 * @Author 饮木
 * @Date 2022/7/15 17:28
 * @Description: TODO
 */
public class Cat {
    String name;
    String age;

    public Cat(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
