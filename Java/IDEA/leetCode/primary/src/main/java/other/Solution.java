package other;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author 饮木
 * @Date 2022/7/6
 * @Description description
 */
public class Solution {
    /**
     * 杨辉三角
     *
     * @param numRows 行数
     * @return 存储前numRows行的杨辉三角的集合
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp;
        /*
        在「杨辉三角」中，每个数是它左上方和右上方的数的和。
        每行的首位和最后一位都是1
         */
        int index;
        //for:控制循环的次数
        for (int i = 0; i < numRows; i++) {
            temp = new ArrayList<>();
            //每行的个数都和行数一样
            for (int j = 0; j <= i; j++) {
                //每行的首位和最后一位都是1
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(temp);
        }
        return result;
    }

    /**
     * 有效的括号
     */
    public boolean isValid(String s) {
        /*
        利用栈的先入后出的特性。如果添加的元素是左括号，就把对应的右括号压入栈。如果添加的元素是右括号，
        那么判断是否和栈顶的元素相等。
         */
        Stack<Character> bucket = new Stack<>();
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (temp == '(') {
                bucket.add(')');
            } else if (temp == '{') {
                bucket.add('}');
            } else if (temp == '[') {
                bucket.add(']');
            } else {
                //右括号的情况,判断是否和栈顶元素相等。但如果栈为空，s也构不成有效的括号。
                //这边要先判断是否为空，否则会造成空指针异常。
                if (bucket.isEmpty() || bucket.peek() != temp) {
                    return false;
                } else {
                    //如果匹配上了就移除栈顶的元素
                    bucket.pop();
                }
            }
        }
        return bucket.isEmpty();
    }

    /**
     * 寻找缺失的数字
     *
     * @return 返回缺失的数字
     */
    public int missingNumber(int[] nums) {
        //数组中的数字范围应该在[0,range]中
        int range = nums.length;
        //把0-range的值相加，然后再循环的时候减去，最后得到缺失的值
        int count = (1 + range) * range / 2;
        for (int num : nums) {
            count -= num;
        }
        return count;
    }
}
