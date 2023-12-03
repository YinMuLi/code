package com.yinmu;

/**
 * @author 饮木
 * @Date 2022/6/19
 * @Description description
 */
public class GraphTest {
    public static void main(String[] args) {
        String[] test = {"A", "B", "C", "D", "E", "F", "G"};
        Graph graph = new Graph(test);
        //A-B相连
        graph.addEdge(0, 1, 1);
        //B-E
        graph.addEdge(1, 4, 1);
        //E-G
        graph.addEdge(4, 6, 1);
        //B-F
        graph.addEdge(1, 5, 1);
        //D-c
        graph.addEdge(2, 3, 1);
        //F-D
        graph.addEdge(5, 3, 1);
        graph.dfs();
    }
}