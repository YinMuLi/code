package com.yinmu.kmp;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 饮木
 * @Date 2022/6/20
 * @Description 一个人能能走的多远不在于他在顺境时能走的多快，而在于他在逆境时多久能找到曾经的自己。
 * ————KMP
 */
public class Kmp {
    public static void main(String[] args) {
        String str1 = "saberAndArcher";
        String str2 = "And";
        System.out.println(kmp(str1, str2));
    }

    /**
     * 暴力解决字符串的匹配问题，查看字符串str1是否包含str2
     *
     * @return true：str1包含str2否则就是false
     */
    public static boolean violenceMatch(String str1, String str2) {
        //创建两个指针分别指向str1和str2
        //str1
        int a = 0;
        //str2
        int b = 0;
        while (a < str1.length() && b < str2.length()) {
            if (str1.charAt(a) == str2.charAt(b)) {
                a++;
                b++;
            } else {
                //指向str1的指针移动到匹配前的后一位
                a = a - b + 1;
                //str2的指针重置为0
                b = 0;
            }
        }
        return b == str2.length();
    }

    /**
     * 利用queue来存储str2第一个字母在str2中的下标
     *
     * @return true：str1包含str2否则就是false
     */
    public static boolean selfMatch(String str1, String str2) {
        //创建两个指针分别指向str1和str2
        //str1
        int a;
        //str2
        int b = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                //在字符串str1中寻找str2的首字母，并把其下标放入队列中
                queue.add(i);
            }
        }
        if (queue.size() == 0) {
            return false;
        }
        a = queue.remove();
        while (a < str1.length() && b < str2.length()) {
            if (str1.charAt(a) == str2.charAt(b)) {
                a++;
                b++;
            } else {
                if (queue.size() == 0) {
                    //当str2与str1不匹配的时候，这时队列中的元素为空
                    //就直接返回false
                    return false;
                }
                //指向str1的指针移动到匹配前的后一位
                a = queue.remove();
                //str2的指针重置为0
                b = 0;
            }
        }
        return b == str2.length();
    }

    /**
     * 求字符串的next数组，是kmp算法的核心
     * next[i]的值表示下标为i的字符前的字符串最长相等前后缀的长度。
     *
     * @param str 要求的字符串的数组
     * @return 返回存next数组
     */
    public static int[] getNext(String str) {
        int k = -1;
        int i = 0;
        //数组的第一个元素为默认-1
        //因为第一个字符前面没有任何字符next[0]=-1
        //数组的长度
        int length = str.length();
        int[] next = new int[length];
        next[0] = -1;
        //i<length-1是因为最后i会以i++的形式返回，
        //就是i=length-1
        while (i < length - 1) {
            if (k == -1 || str.charAt(i) == str.charAt(k)) {
                i++;
                k++;
                //所以这里这里匹配到的结果会存储到当前匹配字符的下一位中
                //所以先i++，再把值存储进数组
                next[i] = k;
            } else {
                //这个回溯的方法说不清楚
                k = next[k];
            }
        }
        return next;
    }

    /**
     * kmp算法，查看字符串str1是否包含str2
     *
     * @return true：str1包含str2否则就是false
     */
    public static boolean kmp(String str1, String str2) {
        //创建两个指针分别指向str1和str2
        //str1
        int a = 0;
        //str2
        int b = 0;
        int[] next = getNext(str2);
        while (a < str1.length() && b < str2.length()) {
            //这里b==-1是解决第一个字符匹配不上的情况
            if (b == -1 || str1.charAt(a) == str2.charAt(b)) {
                a++;
                b++;
            } else {
                b = next[b];
            }
        }
        return b == str2.length();
    }
}
