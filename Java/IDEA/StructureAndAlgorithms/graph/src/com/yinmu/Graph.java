package com.yinmu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 饮木
 * @Date 2022/6/19
 * @Description 图
 */
public class Graph {
    /**
     * 存储图中各个顶点之间是否相连的二维数组
     */
    private final int[][] vertexes;
    /**
     * 存储顶点的名字
     */
    private final List<String> vertexNames;
    /**
     * 记录图中边的个数
     */
    private int edgeCount;
    /**
     * 表示图的容量
     */
    private final int capacity;
    /**
     * 记录某个节点是否访问过
     */
    private final boolean[] isVisit;
    /**
     * 记录图中有效的顶点数
     */
    private int size;

    /**
     * 构建图
     *
     * @param capacity 表示要构建图的大小
     */
    public Graph(int capacity) {
        this.capacity = capacity;
        vertexes = new int[capacity][capacity];
        vertexNames = new ArrayList<>();
        edgeCount = 0;
        isVisit = new boolean[capacity];
    }

    /**
     * 像图中添加顶点
     *
     * @param vertexName 顶点的名字
     */
    public void add(String vertexName) {
        if (vertexNames.size() > capacity) {
            System.err.println("图已经满了！");
        }
        vertexNames.add(vertexName);
        size++;
    }

    /**
     * 根据字符串数组构建图
     *
     * @param array 字符串数组,图的大小为数组的长度。
     */
    public Graph(String[] array) {
        capacity = array.length;
        vertexes = new int[capacity][capacity];
        vertexNames = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            vertexNames.add(array[i]);
        }
        isVisit = new boolean[capacity];
        edgeCount = 0;
        size = capacity;
    }

    /**
     * 构建图中两个顶点之间的关系
     *
     * @param v1    要构建顶点的下标
     * @param v2    要构建顶点的下标
     * @param value 1表是两个顶点之间相互链接，否则就是0
     */
    public void addEdge(int v1, int v2, int value) {
        if (v1 > capacity - 1 || v2 > capacity - 1) {
            System.err.println("顶点下标越界");
        }
        vertexes[v1][v2] = value;
        vertexes[v2][v1] = value;
        edgeCount++;
    }

    /**
     * 输出图的二维矩阵
     */
    public void print() {
        for (int[] item : vertexes) {
            System.out.print("[ ");
            for (int value : item) {
                System.out.print(value + " ");
            }
            System.out.println("]");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    /**
     * @param i 顶点的下标
     * @return 如果存在相连的节点，就返回其下标，否则返回-1
     */
    private int getNextLinkedVertex(int i) {
        for (int j = i + 1; j < vertexNames.size(); j++) {
            if (vertexes[i][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先算法遍历图(Depth First Search)
     * 这种遍历的方法建立在图中的每个元素都相连的情况下
     *
     * @param i 顶点的下标
     */
    private void dfs(int i) {
        if (!isVisit[i]) {
            //如果这个节点还没有被遍历过，就输出
            System.out.print(vertexNames.get(i) + "->");
            //输出后设置为访问过
            isVisit[i] = true;
            //获取下一个顶点的下标
            int nextIndex = getNextLinkedVertex(i);
            if (nextIndex != -1) {
                //存在下一个相连的顶点
                dfs(nextIndex);
            }
        }
    }

    public void dfs() {
        if (vertexNames.size() == 0) {
            return;
        }
        for (int i = 0; i < capacity; i++) {
            isVisit[i] = false;
        }
        //从第一个顶点开始遍历
        for (int i = 0; i < vertexNames.size(); i++) {
            dfs(i);
        }
    }

    /**
     * 判断两个顶点是否相连
     *
     * @param v1 第一个顶点的下标
     * @param v2 第二个顶点的下标
     * @return true：相连，否则返回false
     */
    private boolean judgeLinked(int v1, int v2) {
        return vertexes[v1][v2] == 1;
    }

    public void bfs() {
        if (size == 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            isVisit[i] = false;
        }
        int temp = 0;
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        //从第一个顶点开始遍历
        queue.add(0);
        //先把第一个顶点的信息输出
        System.out.print(vertexNames.get(0));
        isVisit[0] = true;
        while (queue.size() != 0) {
            //从队列中取出元素
            temp = queue.remove();
            while (index < size) {
                if (judgeLinked(temp, index)) {
                    //如果两个顶点相连
                    if (!isVisit[index]) {
                        System.out.print("->" + vertexNames.get(index));
                        isVisit[index] = true;
                        queue.add(index);
                    }
                }
                index++;
            }
            index = 0;
        }

    }

    public int getSize() {
        return size;
    }
}
