package yinmu.graph;

import java.util.Arrays;

/**
 * @Author 饮木
 * @Date 2023/3/15 10:32
 * @Description 无向图
 */
public class Graph {
    private int vertexCount;
    private String[] vertexArray;
    /**
     * 邻接矩阵
     */
    private int[][] edgeArray;
    private int edgeCount;
    private boolean[] visitedArray;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        vertexArray = new String[vertexCount];
        visitedArray = new boolean[vertexCount];
        edgeArray = new int[vertexCount][vertexCount];
    }

    public void modifyVertexName(int vertexIndex, String name) {
        if (vertexIndex < vertexCount) {
            vertexArray[vertexIndex] = name;
        }
    }

    public void modifyVertexName(String[] nameArray) {
        for (int i = 0; i < vertexCount; i++) {
            if (i >= nameArray.length) {
                return;
            }
            vertexArray[i] = nameArray[i];
        }
    }

    public void showVertex() {
        System.out.print("图的顶点：");
        for (int i = 0; i < vertexCount; i++) {
            System.out.printf("%s ", vertexArray[i]);
        }
    }

    public void addEdge(int v1, int v2, int edge) {
        if (checkVertexIndex(v1) && checkVertexIndex(v2)) {
            edgeArray[v1][v2] = edge;
            edgeArray[v2][v1] = edge;
        }
    }

    private boolean checkVertexIndex(int vertexIndex) {
        return vertexIndex >= 0 && vertexIndex < vertexCount;
    }

    public void showEdge() {
        for (int[] edge : edgeArray) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
