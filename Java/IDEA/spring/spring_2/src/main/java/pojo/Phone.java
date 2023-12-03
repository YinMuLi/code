package pojo;

/**
 * @Author 饮木
 * @Date 2022/7/17 11:31
 * @Description TODO
 */
public class Phone {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                '}';
    }
}
