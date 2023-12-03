package com.yinmu.huffman;

/**
 * @author 饮木
 * @Date 2022年06月18日14时37分
 * @Description 测试
 */
public class Test {
    public static void main(String[] args) {
        int[] test = {13, 7, 8, 3, 29, 6, 1};
        System.out.println(HuffmanTree.createHuffmanTree(test));
    }
}
