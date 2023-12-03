package com.yinmu;

/**
 * @author 饮木
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：表示没有棋子 1：表示黑子 2：表示白子
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[3][3] = 2;
        //printOrigin(chessArray);
        int[][] sparseArray = toSparseArray(chessArray);
        //输出稀疏数组
        for (int[] item : sparseArray) {
            System.out.printf("%d\t%d\t%d", item[0], item[1], item[2]);
            System.out.println();
        }
        //输出根据稀疏数组转换而来的原数组
        int[][] originArray = toOriginArray(sparseArray);
        printOrigin(originArray);
    }

    /**
     * 输出原数组
     */
    private static void printOrigin(int[][] array) {
        for (int[] i : array) {
            for (int j : i) {
                System.out.printf("%d\t", j);
            }
            System.out.println();
        }
    }

    /**
     * 将原始数组转换为稀疏数组
     */
    private static int[][] toSparseArray(int[][] array) {
        //获取数组的行数和列数
        int row, column;
        row = array.length;
        column = array[0].length;
        //遍历数组算出非0的个数，并存储到sum中
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (array[i][j] != 0) {
                    sum++;
                }
            }
        }
        /*
         * 创建稀疏数组，并将原数组中非0的值存储进去
         */
        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //第一行用来存储原始数组的大小和非0的个数
        sparseArray[0][0] = row;
        sparseArray[0][1] = column;
        sparseArray[0][2] = sum;
        //用来计算存储的行数
        int count = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (array[i][j] != 0) {
                    //存储行
                    sparseArray[count][0] = i;
                    //存储列
                    sparseArray[count][1] = j;
                    //存储非0的值
                    sparseArray[count][2] = array[i][j];
                    count++;
                }
            }
        }
        return sparseArray;
    }

    /**
     * 将稀疏数组转换为原数组
     */
    private static int[][] toOriginArray(int[][] array) {
        //遍历稀疏数组的第一行，创建原数组
        int[][] originArray = new int[array[0][0]][array[0][1]];
        //为原数组赋值
        for (int i = 0; i < array[0][2]; i++) {
            originArray[array[i + 1][0]][array[i + 1][1]] = array[i + 1][2];
        }
        return originArray;
    }
}
