package pojo;

/**
 * @Author 饮木
 * @Date 2022/7/17 11:31
 * @Description TODO
 */
public class People {
    Phone phone;

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "People{" +
                "phone=" + phone +
                '}';
    }
}
