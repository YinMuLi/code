package com.yinmu;

/**
 * @author 饮木
 * 递归解决八皇后问题
 */
public class EightQueen {
    private static final int COUNT = 8;
    private static int[] array;
    private static int solution;

    static {
        array = new int[COUNT];
    }

    private EightQueen() {
    }

    /**
     * 判断摆放的皇后是否与之前的摆放的皇后冲突
     *
     * @param n 正在摆放皇后的序号
     * @return true：冲突；false：不冲突
     */
    public static boolean judge(int n) {
        for (int i = 0; i < n - 1; i++) {
            //同一列或者在一条斜线上
            //判断是否在一条斜线上是用斜率来判断的
            //横坐标-纵坐标==0表示在一条斜线上
            if (array[i] == array[n - 1] || Math.abs(n - i - 1) == Math.abs(array[i] - array[n - 1])) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param n 正在摆放皇后的序号
     */
    public static void check(int n) {
        if (n == COUNT + 1) {
            //n==9表示已经摆完了
            print();
            return;
        }
        //从第0列开始摆放下一个皇后
        for (int i = 0; i < COUNT; i++) {
            array[n - 1] = i;
            if (!judge(n)) {
                //不冲突进行下一次递归
                check(n + 1);
            }
        }
    }

    /**
     * 打印出一维数组
     */
    private static void print() {
        System.out.printf("第%s种摆放八皇后的方法:\n", ++solution);
        System.out.print("[");
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println("]");
    }
}
