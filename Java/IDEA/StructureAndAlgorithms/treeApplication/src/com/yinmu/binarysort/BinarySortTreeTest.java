package com.yinmu.binarysort;


/**
 * @author 饮木
 * @Date 2022年06月18日17时30分
 * @Description
 */
class BinarySortTreeTest {
    public static void main(String[] args) {
        int[] test = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree(test);
        binarySortTree.delete(10);
        binarySortTree.infixErgodic();
    }
}