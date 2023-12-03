package com.yinmu.prim;


import java.util.*;

/**
 * @author 饮木
 * @Date 2022/6/20
 * @Description description
 */
public class Graph {
    final int size;
    /**
     * 记录顶点与顶点之间的路程大小
     * 0表示顶点与顶点之间不连通
     */
    int[][] record;
    /**
     * 记录顶点的名字
     */
    String[] names;
    /**
     * 路的最大值
     */
    int maxWeight = 0;

    /**
     * 记录边的条数
     */
    public Graph(String[] names) {
        this.size = names.length;
        record = new int[size][size];
        this.names = names.clone();
    }

    /**
     * 输出图中顶点与顶点之间的信息
     */
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print("[ ");
            for (int j = 0; j < size; j++) {
                System.out.print(record[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * @param i     顶点i
     * @param j     顶点j
     * @param value 顶点i与顶点j之间的路程大小，0表示不可相连
     * @Description 设置顶点与顶点之间的信息
     */
    public void set(int i, int j, int value) {
        record[i][j] = value;
        record[j][i] = value;
        if (value > maxWeight) {
            maxWeight = value;
        }
    }

    /**
     * 输出每个顶点的详细信息
     */
    public void printDetails() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (record[i][j] != 0) {
                    System.out.print(names[i] + "->" + names[j] + ":" + record[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    /**
     * 普利姆算法
     */
    public void prim() {
        int allWeight = 0;
        List<Integer> list = new ArrayList<>();
        //从第一个顶点开始遍历
        list.add(0);
        //最小值
        int minWeight;
        //最小顶点的下标
        int a = 0, b = 0;
        //七个顶点建立六条路就可以了
        //循环一次建立一条边
        for (int i = 0; i < size - 1; i++) {
            //初始化最小值
            minWeight = maxWeight;
            for (int j = 0; j < list.size(); j++) {
                //遍历当前顶点的所有相连的顶点
                int temp = list.get(j);
                for (int k = 0; k < size; k++) {
                    if (record[temp][k] != 0 && !list.contains(k)) {
                        //未访问过的点
                        //计算权值
                        if (record[temp][k] < minWeight) {
                            minWeight = record[temp][k];
                            a = list.get(j);
                            b = k;
                        }
                    }
                }
            }
            System.out.println("<" + names[a] + "," + names[b] + ">\t权重为：" + record[a][b]);
            allWeight += record[a][b];
            list.add(b);
        }
        System.out.println("总权重为：" + allWeight);
        System.out.print("修路的顺序:");
        for (Integer integer : list) {
            System.out.print(names[integer]);
        }
    }

    /**
     * 获取边的条数
     */

    private int getEdgeCount() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (record[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * [1,2,3]
     * 1好顶点与2号顶点之间的边大的权值为3
     *
     * @return 返回一个以边的权值，升序的二维数组
     */
    public int[][] getEdgeDetail() {
        //只要存储两个顶点和两个顶点之间边的权值，所以只要3列
        int[][] edges = new int[getEdgeCount()][3];
        //记录添加的次数
        int count = 0;
        //第二个循环是从1开始，因为自己和自己肯定不相连
        for (int i = 0; i < size; i++) {
            //j=i+1完美避开了之前已经访问过的点
            for (int j = i + 1; j < size; j++) {
                if (record[i][j] != 0) {
                    //添加边的权值，和两个顶点
                    edges[count][0] = record[i][j];
                    edges[count][1] = i;
                    edges[count][2] = j;
                    count++;
                }
            }
        }
        //进行升序
        insertSortAscend(edges);
        return edges;
    }

    /**
     * 专门为edge[][]写的插入排序,根据边的权值进行升序
     *
     * @param array 要排序的数组
     */
    private void insertSortAscend(int[][] array) {
        int length = array.length;
        //假设插入的下标和值
        int insertValue;
        int insertIndex;
        //存储两个顶点
        int a, b;
        //一开始array[1][]以及以后的数组为无序的数组
        for (int i = 1; i < length; i++) {
            insertValue = array[i][0];
            a = array[i][1];
            b = array[i][2];
            insertIndex = i - 1;
            for (int j = insertIndex; j >= 0; j--) {
                if (array[j][0] > insertValue) {
                    //有序数组的元素往后移动一位
                    array[j + 1][0] = array[j][0];
                    array[j + 1][1] = array[j][1];
                    array[j + 1][2] = array[j][2];
                    insertIndex--;
                }
            }
            array[insertIndex + 1][0] = insertValue;
            array[insertIndex + 1][1] = a;
            array[insertIndex + 1][2] = b;
        }
    }

    /**
     * 获取顶点i相连的最终顶点
     *
     * @param array 存储最终顶点的数组
     * @param i     顶点的下标
     * @return 返回最终顶点的下标
     */
    private int getEndVertex(int[] array, int i) {
        //假设A-B-C-D-E-F
        //array[]={1,2,3,4,5,0}
        //如果要查找A的相连的最终顶点
        //传入方法的i就是0，
        //i=1,i=2,i=3,i=4,i=5,
        //array[5]==0，跳出循环
        //return 5;
        while (array[i] != 0) {
            i = array[i];
        }
        return i;
    }

    /**
     * 克鲁斯卡尔算法
     */
    public void kruskalAlgorithm() {
        //获取边与顶点之间的关系
        int[][] relation = getEdgeDetail();
        //存放相连最终顶点的数组
        int[] end = new int[size];
        //记录第一个和第二个顶点的相连的最终顶点
        int a, b;
        //记录边的总权值
        int edgeWeight = 0;
        for (int[] ints : relation) {
            //获得第一个和第二个顶点的相连的最终顶点
            a = getEndVertex(end, ints[1]);
            b = getEndVertex(end, ints[2]);
            //判断是否相等
            if (a != b) {
                //为顶点a添加最终顶点
                end[a] = b;
                System.out.println("<" + names[ints[1]] + "," + names[ints[2]] + ">\t权值：" + ints[0]);
                edgeWeight += ints[0];
            }
        }
        System.out.println("克鲁斯卡尔算法总权值：" + edgeWeight);
    }

    /**
     * 迪杰斯特拉算法，算出起点target到各个顶点之间最短路径
     *
     * @param target 目标点的下标
     */
    public void dijkstraAlgorithm(int target) {
        //记录前驱顶点
        int[] previousVertex = new int[size];
        //记录目标点target到各个顶点之间的距离
        int[] distance = new int[size];
        //一开始初始化为无穷大
        Arrays.fill(distance, Integer.MAX_VALUE);
        //自己到自己的距离为0
        distance[target] = 0;
        //记录点是否被访问过
        boolean[] visit = new boolean[size];
        //一开始target点是被访问过的
        //visit[target]=true;
        for (int i = 0; i < size; i++) {
            int index = getNextVertex(distance, visit);
            calculatePath(index, distance, visit, previousVertex);
        }
        printPath(distance, previousVertex, target);
    }

    /**
     * @param distance 记录目标点到各个顶点之间的距离的数组
     * @param visit    记录顶点是否被访问过的数组
     * @return 从未被访问的顶点中，返回一个距离目前最小的下标，有点像贪心算法。
     */
    private int getNextVertex(int[] distance, boolean[] visit) {
        int max = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (!visit[i] && distance[i] < max) {
                max = distance[i];
                index = i;
            }
        }
        //记录 index已经被访问过
        visit[index] = true;
        return index;
    }

    /**
     * 计算index到周围顶点之间的距离
     *
     * @param index          计算点的下标
     * @param distance       记录目标点到各个顶点之间的距离的数组
     * @param visit          记录顶点是否被访问过的数组
     * @param previousVertex 记录前驱顶点的数组
     */
    private void calculatePath(int index, int[] distance, boolean[] visit, int[] previousVertex) {
        int length = 0;
        for (int i = 0; i < size; i++) {
            if (record[index][i] != 0) {
                //距离的计算：index->i+target->index
                length = record[index][i] + distance[index];
                if (!visit[i] && length < distance[i]) {
                    //更新最小距离
                    distance[i] = length;
                    //更新前驱顶点
                    previousVertex[i] = index;
                }
            }
        }
    }

    /**
     * 输出最短路径
     *
     * @param distance       记录目标点到各个顶点之间的距离的数组
     * @param previousVertex 记录前驱顶点的数组
     * @param target         目标顶点下标
     */
    private void printPath(int[] distance, int[] previousVertex, int target) {
        System.out.println("迪杰斯特拉算法，算出起点" + names[target] + "到各个顶点之间最短路径:");
        //记录点
        int temp;
        for (int i = 0; i < size; i++) {
            //前驱顶点的下标
            int previousIndex = i;
            if (previousIndex != target) {
                temp = previousIndex;
                System.out.print(names[target]);
                while (true) {
                    previousIndex = previousVertex[previousIndex];
                    if (previousIndex == target) {
                        break;
                    }
                    System.out.print("->" + names[previousIndex]);
                }
                System.out.print("->" + names[temp]);
                System.out.println("\t最短距离为：" + distance[i]);
            }
        }
    }
}
