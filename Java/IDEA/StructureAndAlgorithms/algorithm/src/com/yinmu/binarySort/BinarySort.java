package com.yinmu.binarySort;

/**
 * @author 饮木
 * @Date 2022/6/19
 * @Description 二分查找算法(非递归)
 */
public class BinarySort {
    public static void main(String[] args) {
        int[] test = {1, 5, 6, 9, 10, 65};
        System.out.println(binarySort(test, 65));
    }

    /**
     * 二分查找算法(非递归)
     *
     * @param array  目标数组(已经排序好的升序数组)
     * @param target 查找的值
     * @return 找到返回其下标，没找到返回-1
     */
    public static int binarySort(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }
        //左右索引
        int left = 0;
        int right = array.length - 1;
        int middle;
        while (left <= right) {
            middle = (right + left) / 2;
            if (array[middle] == target) {
                return middle;
            }
            if (array[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
