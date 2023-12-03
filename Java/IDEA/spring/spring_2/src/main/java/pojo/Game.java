package pojo;

/**
 * @Author 饮木
 * @Date 2022/7/16 16:04
 * @Description: TODO
 */
public class Game {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                '}';
    }
}
