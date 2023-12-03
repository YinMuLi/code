package others;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author 饮木
 * @Date 2022/8/6 9:25
 * @Description TODO
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        /*
        逆波兰计算器,没有运算符的优先级
         */
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!token.matches("[/*+-]")) {
                //如果不是运算符就入栈
                stack.add(Integer.parseInt(token));
                continue;
            }
            //弹出栈顶的两个元素，进行计算
            calculate(token, stack);
        }
        return stack.pop();
    }

    private void calculate(String operator, Stack<Integer> stack) {
        int temp = 0;
        int first = stack.pop();
        int second = stack.pop();
        temp = switch (operator) {
            case "+" -> first + second;
            case "-" -> second - first;
            case "*" -> second * first;
            default -> second / first;
        };
        stack.add(temp);
    }

    public int majorityElement(int[] nums) {
        /*
        核心就是对拼消耗。
        玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。
        最后还有人活下来的国家就是胜利。
        那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），
        或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。
        最后能剩下的必定是自己人。
        解题代码
         */
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //遇到友军阵容增加
            if (res == nums[i]) {

                count++;
            } else {
                //遭遇敌军，对拼消耗
                count--;
                //该批友军阵亡，换下一批作为友军记录
                if (count == 0) {
                    res = nums[i + 1];
                }
            }
        }
        return res;
    }

    public int leastInterval(char[] tasks, int n) {
        int[] temp = new int[26];
        for (char item : tasks) {
            temp[item - 'A']++;
        }
        //最大任务数
        int maxTask = 0;
        //最大任务数的个数
        int maxTaskCount = 0;
        for (int i = 0; i < 26; i++) {
            if (temp[i] > maxTask) {
                maxTask = temp[i];
                maxTaskCount = 1;
            } else if (temp[i] == maxTask) {
                maxTaskCount++;
            }
        }
        return Math.max(tasks.length, (n + 1) * (maxTask - 1) + maxTaskCount);
    }
}
