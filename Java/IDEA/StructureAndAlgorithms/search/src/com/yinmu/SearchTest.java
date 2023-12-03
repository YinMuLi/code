package com.yinmu;


/**
 * @author 饮木
 * @Date 2022年06月15日19时53分
 */
class SearchTest {
    public static void main(String[] args) {
        double[] test = {1, 3, 4, 5, 69};
        System.out.println(Search.insertValueSearch(test, 0, test.length - 1, 1));
    }
}