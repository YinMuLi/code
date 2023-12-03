package yinmu.test;

import yinmu.graph.Graph;

/**
 * @Author 饮木
 * @Date 2023/3/15 10:23
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertexName = new String[]{"unity", "unreal", "wechat", "qq", "tim"};
        graph.modifyVertexName(vertexName);
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 30);
        graph.addEdge(0, 3, 40);
        graph.showEdge();
    }
}
