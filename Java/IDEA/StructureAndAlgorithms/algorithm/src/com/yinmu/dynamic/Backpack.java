package com.yinmu.dynamic;

/**
 * @author 饮木
 * @Date 2022/6/20
 * @Description 背包问题
 */
public class Backpack {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {1500, 2000, 3000};
        solveProblem(4, weight, value);
    }

    /**
     * 解决背包的分配问题，每个物品只能使用一次.
     * 这里的数组要升序排好
     *
     * @param capacity 背包的最大容量
     * @param weight   物品的重量
     * @param value    物品的价值
     */
    public static void solveProblem(int capacity, int[] weight, int[] value) {
        //物品的数量
        int count = weight.length;
        //创建二维数组【派生数组】
        //这边创建数组的时候长度+1，是防止后面计算的时候防止下标越界
        int[][] derivedArray = new int[count + 1][capacity + 1];
        //开始动态分布
        for (int i = 1; i < derivedArray.length; i++) {
            for (int j = 1; j < derivedArray[0].length; j++) {
                //这里直接忽略第一行和第一列
                //物品的下标是从0开始的，所以需要减一
                if (weight[i - 1] > j) {
                    //物品的重量大于背包的容量,就采用上一行的分配方法
                    //数组的长度+1就体现在这里离，防止越界
                    derivedArray[i][j] = derivedArray[i - 1][j];
                } else {
                    //物品的重量小于等于背包的容量
                    derivedArray[i][j] = Math.max(derivedArray[i - 1][j], value[i - 1] + derivedArray[i - 1][j - weight[i - 1]]);
                }
            }
        }
        //计算哪些商品被放入到背包中
        int temp = capacity;
        boolean[] isAdd = new boolean[count + 1];
        for (int i = count; i >= 1; i--) {
            if (derivedArray[i][temp] == derivedArray[i - 1][temp]) {
                isAdd[i] = false;
            } else {
                isAdd[i] = true;
                //求剩余的重量
                temp -= weight[i - 1];
            }
        }
        for (int i = 0; i < isAdd.length; i++) {
            if (isAdd[i]) {
                System.out.println(i);
            }
        }
    }
}
