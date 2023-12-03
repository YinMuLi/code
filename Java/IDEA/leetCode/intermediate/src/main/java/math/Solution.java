package math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author 饮木
 * @Date 2022/8/2 14:46
 * @Description TODO
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n >= 10) {
                sum += (int) Math.pow(n % 10, 2);
                n /= 10;
            }
            sum += n * n;
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return true;
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            //每次得出该次的前缀表示该次的次数。
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            sum += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, length - 1 - i);
        }
        return sum;
    }

    public double myPow(double x, int n) {
        /*
        折半计算，每次把n缩小一半
        当n为奇数时,需要少乘一次x的值
        判断n是正数还是负数。如果是正数，直接返回结果; 如果是负数,返回 1 / res;
         */
        double result = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                result *= x;
            }
            x *= x;
        }
        if (n >= 0) {
            return result;
        } else {
            return 1 / result;
        }
    }

    public int mySqrt(int x) {
        int right = x;
        int left = 0;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            long current = (long) middle * middle;
            long latter = (long) (middle + 1) * (middle + 1);
            if (current <= x && latter > x) {
                return middle;
            } else if (latter <= x) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //整数部分
        long prefix = (long) numerator / denominator;
        sb.append(prefix);
        //余数
        long remainder = (long) numerator % denominator;
        if (remainder != 0) {
            //如果余数小于零,判断首位是否等于-1
            boolean flag = ((long) (long) numerator * denominator < 0) && sb.charAt(0) != '-';
            if (flag) {
                sb.insert(0, '-');
            }
            sb.append(".");
            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    sb.insert(map.get(remainder), "(");
                    sb.append(")");
                    break;
                }
                map.put(remainder, sb.length());
                //余数乘以10
                remainder *= 10;
                long temp = (remainder / denominator);
                if (temp < 0) {
                    sb.append(-temp);
                } else {
                    sb.append(temp);
                }
                remainder %= denominator;
            }

        }
        return sb.toString();
    }
}
