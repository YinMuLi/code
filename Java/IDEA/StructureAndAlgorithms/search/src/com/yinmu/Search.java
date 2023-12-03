package com.yinmu;

/**
 * @author 饮木
 * @Date 2022 06 15 19 42
 */
public class Search {
    private Search() {
    }

    /**
     * 线性查找是指，找到一个满足条件的值，就返回
     *
     * @param array 要查找的数组
     * @param value 查找的值
     * @return 找到就返回对应的下标，没有就返回-1.
     */
    public static <T> int linearSearch(T[] array, T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 找到一个满足的值就返回
     *
     * @param array 要查找的数组
     * @param left  左边索引
     * @param right 右边索引
     * @param value 要寻找的值
     * @return 找到返回下标，否则就返回-1
     */
    public static <T extends Comparable<T>> int binarySearchRecursion(T[] array, int left, int right, T value) {
        if (left > right) {
            //left==right的情况就是，二分法分到只有一个数的情况，这是还需要判断一下这个数
            //是不是要寻找的数。
            //所引退出的条件是left>right,也就是没有找到的情况
            return -1;
        }
        //中间索引
        int middleIndex = (left + right) / 2;
        //中间值
        T middleValue = array[middleIndex];
        if (value.compareTo(middleValue) > 0) {
            //要寻找的值大于中间的值，就向右递归
            return binarySearchRecursion(array, middleIndex + 1, right, value);
        } else if (value.compareTo(middleValue) < 0) {
            //要寻找的值小于中间的值，就向左递归
            return binarySearchRecursion(array, left, middleIndex - 1, value);
        } else {
            //最后一种情况就是等于中间的值,直接返回下标
            return middleIndex;
        }
    }

    /**
     * 找到一个满足的值就返回
     *
     * @param array 要查找的数组
     * @param left  左边索引
     * @param right 右边索引
     * @param value 要寻找的值
     * @return 找到返回下标，否则就返回-1
     */
    public static int insertValueSearch(double[] array, int left, int right, double value) {
        if (left > right || value < array[0] || value > array[array.length - 1]) {
            //插值查找推出的条件
            //小于查找数组的最小值或者大于最大值
            //以及左索引大于右索引
            return -1;
        }
        //中间索引
        int middleIndex = (int) (left + (value - array[left]) / (array[right] - array[left]) * (right - left));
        //中间值
        double middleValue = array[middleIndex];
        if (value > middleValue) {
            //要寻找的值大于中间的值，就向右递归
            return insertValueSearch(array, middleIndex + 1, right, value);
        } else if (value < middleValue) {
            //要寻找的值小于中间的值，就向左递归
            return insertValueSearch(array, left, middleIndex - 1, value);
        } else {
            //最后一种情况就是等于中间的值,直接返回下标
            return middleIndex;
        }
    }
}
