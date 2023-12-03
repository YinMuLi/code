package com.yinmu.huffman;

/**
 * @author 饮木
 * @Date 2022年06月18日14时34分
 * @Description 节点
 * 实现comparable接口才能对类进行排序
 */
public class Node implements Comparable<Node> {
    /**
     * 节点的权值
     */
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
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
    public int compareTo(Node o) {
        return value - o.value;
    }

    public int getValue() {
        return value;
    }
}
