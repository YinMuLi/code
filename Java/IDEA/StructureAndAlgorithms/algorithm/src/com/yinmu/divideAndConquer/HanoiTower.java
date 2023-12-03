package com.yinmu.divideAndConquer;

/**
 * @author 饮木
 * @Date 2022/6/19
 * @Description 汉诺塔：汉诺塔（又称河内塔）问题是源于印度一个古老传说的益智玩具。
 * 大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
 * 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
 * 并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    /**
     * @param number 汉诺塔的个数
     * @param a      第一个塔的名称
     * @param b      第二个塔的名称
     * @param c      第三个塔的名称
     */
    public static void hanoiTower(int number, char a, char b, char c) {
        if (number == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            //盘的个数>=2
            //第一步：先把上面的所有盘移动到B盘中A->B，移动的过程中会使用到C盘
            hanoiTower(number - 1, a, c, b);
            //第二步：把最下面的盘移动到C盘A->C
            System.out.println("第" + number + "个盘从 " + a + "->" + c);
            //第三步：把B塔中的所有盘移动到C塔中
            hanoiTower(number - 1, b, a, c);
        }
    }
}
