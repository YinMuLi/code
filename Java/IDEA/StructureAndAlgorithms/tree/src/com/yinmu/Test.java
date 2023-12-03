package com.yinmu;

/**
 * @author 饮木
 * @Date 2022年06月17日21时45分
 * @Description 测试类
 */
public class Test {
    public static void main(String[] args) {
        StudentNode root = new StudentNode(1, "桐人");
        StudentNode a = new StudentNode(9, "鸣人");
        StudentNode b = new StudentNode(10, "一叶知秋");
        StudentNode c = new StudentNode(56, "夜雨声烦");
        StudentNode d = new StudentNode(89, "DIO");
        BinaryTree binaryTree = new BinaryTree(root);
        //手动设置节点
        root.setLeft(a);
        root.setRight(b);
        a.setRight(c);
        b.setLeft(d);
        //binaryTree.prefixErgodic();
        binaryTree.delete(56);
        binaryTree.prefixErgodic();
    }
}
