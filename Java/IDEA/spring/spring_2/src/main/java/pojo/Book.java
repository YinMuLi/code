package pojo;

/**
 * @Author 饮木
 * @Date 2022/7/17 10:26
 * @Description TODO
 */
public class Book {
    String name;

    public Book() {
        System.out.println("第一步：调用无参数构造方法");
    }

    public void setName(String name) {
        System.out.println("第二步：调用set方法");
        this.name = name;
    }

    /**
     * bean的初始化方法
     */
    public void init() {
        System.out.println("第三步：初始化bean");
    }

    /**
     * bean销毁的方法
     */
    public void destroy() {
        System.out.println("第五步：销毁bean");
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
