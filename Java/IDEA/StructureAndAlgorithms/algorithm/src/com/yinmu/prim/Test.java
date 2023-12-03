package com.yinmu.prim;


import java.util.Arrays;

/**
 * @author 饮木
 * @Date 2022/6/20
 * @Description description
 */
public class Test {
    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E", "F", "G"};
        Graph graph = new Graph(names);
        graph.set(0, 1, 5);
        graph.set(0, 2, 7);
        graph.set(0, 6, 2);
        graph.set(1, 6, 3);
        graph.set(1, 3, 9);
        graph.set(2, 4, 8);
        graph.set(3, 5, 4);
        graph.set(4, 5, 5);
        graph.set(4, 6, 4);
        graph.set(5, 6, 6);
        graph.printDetails();
        //graph.kruskalAlgorithm();
        graph.dijkstraAlgorithm(0);
    }
}
