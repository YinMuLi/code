package com.yinmu.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 饮木
 * @Date 2022年06月18日14时38分
 * @Description 赫夫曼树
 */
public class HuffmanTree {
    /**
     * 根据数组创建赫尔曼树
     *
     * @param array 创建赫尔曼树的数组
     */
    public static Node createHuffmanTree(int[] array) {
        List<Node> nodes = new ArrayList<>();
        //根据数组创建节点对象
        for (int item : array) {
            nodes.add(new Node(item));
        }
        //直到集合中只有一个元素为止
        while (nodes.size() > 1) {
            //对元素进行排序
            Collections.sort(nodes);
            //左右节点
            Node leftNode = nodes.remove(0);
            Node rightNode = nodes.remove(0);
            //创建父节点
            Node parentNode = new Node(leftNode.getValue() + rightNode.getValue());
            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);
            //把新创建的节点添加到结合中
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }
}
