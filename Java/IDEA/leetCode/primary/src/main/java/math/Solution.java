package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 饮木
 * @Date 2022/7/6
 * @Description 数学问题
 */
public class Solution {
    /**
     * Fizz Buzz
     *
     * @param n 数组的长度
     * @return 按照题目返回对应的字符串数组
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        //小标从1开始
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                //是3和5的倍数
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                //是3的倍数
                result.add("Fizz");
            } else if (i % 5 == 0) {
                //是5的倍数
                result.add("Buzz");
            } else {
                //其它的情况
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    /**
     * 计算质数的数量
     *
     * @param n 0-n
     * @return 质数的数量
     */
    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                continue;
            }
            count++;
            for (int j = i * 2; j < n; j += i) {
                flag[j] = true;
            }
        }
        return count;
    }

    /**
     * 洗牌算法，打乱传进来的数组
     *
     * @param nums 需要打乱的数组
     */
    public static void shuffle(int[] nums) {
        Random random = new Random();
        int index;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            index = random.nextInt(i, nums.length);
            //交换元素
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    /**
     * 埃拉托斯特尼(Eratosthene)筛法寻找素数
     *
     * @param n 小于但不等于n
     */
    public static void findPrime(int n) {
        //素数标记为：false
        //合数标记为：true
        boolean[] flag = new boolean[n];
        //从2开始，1不算素数
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                continue;
            }
            System.out.println(i);
            /*
            埃拉托斯特尼筛法寻，将合数去除掉。
            for循环的步长为i，倍数递增。
             */
            for (int j = i * 2; j < n; j += i) {
                //标记为合数
                flag[j] = true;
            }
        }
    }

    /**
     * 3的幂
     *
     * @param n 要求的数
     * @return true：n是3的幂次数，否则就是false
     */
    public boolean isPowerOfThree(int n) {
        //小于零的情况不考虑
        if (n > 0) {
            while (n % 3 == 0) {
                n /= 3;
            }
            return n == 1;
        }
        return false;
    }

    /**
     * @param c 罗马字符
     * @return 字符罗马字符c对应的值
     */
    private int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    /**
     * 转换罗马字符
     *
     * @param s 罗马字符串
     * @return 罗马字符转换为int型
     */
    public int romanToInt(String s) {
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            //如果当前字符小于后面的字符，就用后面的字符的值减去前面的值
            if (i + 1 < s.length() && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
                result += getValue(s.charAt(i + 1)) - getValue(s.charAt(i));
                i += 2;
                continue;
            }
            result += getValue(s.charAt(i));
            i++;
        }
        return result;
    }
}
