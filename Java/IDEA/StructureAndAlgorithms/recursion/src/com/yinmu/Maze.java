package com.yinmu;

/**
 * @author 饮木
 * maze：迷宫
 * 使用递归实现迷宫寻路
 */
public class Maze {
    private Maze() {
    }

    /**
     * 打印出迷宫
     */
    public static void print(int[][] map) {
        System.out.println("maze:迷宫>----->----->");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 循造到达map[i][j]的路
     * 0表示此地方可走，1：表示墙，2：表示到达目的地的路线，3：演算不可走的情况；
     *
     * @param map 存储地图的二维数组
     * @param i   起点横坐标
     * @param j   起点的纵坐标
     * @return true：找的到前往map[i][j]的路；false:找不到。
     */
    public static boolean findWay(int[][] map, int i, int j) {
        //默认目的地是右下角
        if (map[map.length - 2][map[0].length - 2] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            //没走过的路
            //先假设为2
            map[i][j] = 2;
            if (findWay(map, i - 1, j)) {
                return true;
            } else if (findWay(map, i, j + 1)) {
                return true;
            } else if (findWay(map, i, j - 1)) {
                return true;
            } else if (findWay(map, i + 1, j)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            //1,2,3情况
            return false;
        }
    }
}