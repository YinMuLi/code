package com.yinmu;

/**
 * @author 饮木
 * @Date 2022年06月17日19时29分
 * 创建节点类
 */
public class StudentNode {
    private int id;
    private String name;
    private StudentNode left;
    private StudentNode right;

    public StudentNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentNode getLeft() {
        return left;
    }

    public void setLeft(StudentNode left) {
        this.left = left;
    }

    public StudentNode getRight() {
        return right;
    }

    public void setRight(StudentNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "StudentNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
