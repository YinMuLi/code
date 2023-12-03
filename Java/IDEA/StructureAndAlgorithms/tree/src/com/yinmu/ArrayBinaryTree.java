package com.yinmu;

/**
 * @author 饮木
 * @Date 2022年06月17日21时20分
 * @Description 顺序存储二叉树
 */
public class ArrayBinaryTree {
    private int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    /**
     * 前序遍历数组
     *
     * @param index 数组的下标
     */
    private void prefixErgodic(int index) {
        //先输出根节点
        System.out.println(array[index]);
        //向左递归输出
        if ((2 * index + 1) < array.length) {
            prefixErgodic(2 * index + 1);
        }
        //向右递归输出
        if ((2 * index + 2) < array.length) {
            prefixErgodic(2 * index + 2);
        }
    }

    /**
     * 封装前序遍历
     */
    public void prefixErgodic() {
        if (array == null || array.length == 0) {
            System.out.println("当前数组不可遍历");
            return;
        }
        //开始前序遍历
        //从下标0开始
        prefixErgodic(0);
    }

    /**
     * 中序遍历数组
     *
     * @param index 数组的下标
     */
    private void infixErgodic(int index) {
        //向左递归输出
        if ((2 * index + 1) < array.length) {
            prefixErgodic(2 * index + 1);
        }
        //输出节点
        System.out.println(array[index]);
        //向右递归输出
        if ((2 * index + 2) < array.length) {
            prefixErgodic(2 * index + 2);
        }
    }

    /**
     * 封装中序遍历
     */
    public void infixErgodic() {
        if (array == null || array.length == 0) {
            System.out.println("当前数组不可遍历");
            return;
        }
        //开始前序遍历
        //从下标0开始
        infixErgodic(0);
    }
}
