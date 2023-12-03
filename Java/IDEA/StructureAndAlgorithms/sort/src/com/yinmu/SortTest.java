package com.yinmu;

/**
 * @author 饮木
 */
class SortTest {
    public static void main(String[] args) {
        Integer[] test = {9, 3, 4, 11, 6, 100, -1};
        Sort.heapSort(test);
        Sort.print(test);

    }
}