package pojo;

/**
 * @Author 饮木
 * @Date 2022/7/28 21:26
 * @Description TODO
 */
public class User {
    String name;
    int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
