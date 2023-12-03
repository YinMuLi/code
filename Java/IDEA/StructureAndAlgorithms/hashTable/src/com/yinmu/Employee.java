package com.yinmu;

/**
 * @author 饮木
 * @Date 2022年06月17日13时24分
 */
public class Employee {
    private int id;
    private String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
}
