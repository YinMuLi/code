package com.yinmu.binarysort;

/**
 * @author 饮木
 * @Date 2022年06月18日16时58分
 * @Description 节点
 */
public class Node {
    private Node left;
    private Node right;
    private final int value;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
