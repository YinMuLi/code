package yinmu.pojo;

import java.util.List;

/**
 * 作者：饮木
 */
public class Teacher {
    private String name;
    private int id;
    private List<Student> students;

    public Teacher() {
    }

    public Teacher(String name, int id, List<Student> students) {
        this.name = name;
        this.id = id;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", students=" + students +
                '}';
    }
}
