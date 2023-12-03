package pojo;

/**
 * @Author 饮木
 * @Date 2022/7/27 20:03
 * @Description TODO
 */
public class Employee {
    private Integer id;
    private String name;

    private String email;
    /**
     * 1 male, 0 female
     */
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Employee(Integer id, String name, String email, Integer gender) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public Employee() {
    }
}
