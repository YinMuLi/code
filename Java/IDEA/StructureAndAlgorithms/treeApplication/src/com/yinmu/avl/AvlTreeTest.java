package com.yinmu.avl;


/**
 * @author 饮木
 * @Date 2022/6/19
 * @Description description
 */
public class AvlTreeTest {
    public static void main(String[] args) {
        int[] test = {10, 11, 7, 6, 8, 9};
        AvlTree avlTree = new AvlTree(test);
        //avlTree.infixErgodic();
        System.out.println(avlTree.getTreeHeight());
        System.out.println(avlTree.getRightHeight());
        System.out.println(avlTree.getLeftHeight());
        System.out.println(avlTree.getRoot());
    }
}