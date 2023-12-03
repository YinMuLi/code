package pojo;

/**
 * @Author 饮木
 * @Date 2022/7/15 18:34
 * @Description: TODO
 */
public class Person {
    String name;
    Cat pet;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pet=" + pet +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPet(Cat pet) {
        this.pet = pet;
    }

    public Cat getPet() {
        return pet;
    }
}
