package com.yinmu.postfixcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 饮木
 * 简单的逆波兰计算器
 * 设计成工具类
 */
public class PostfixCalculator {
    private PostfixCalculator() {
    }

    private static final String PLUS = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";

    /**
     * @param prefix 前缀表达式
     */
    public static List<String> convert(String prefix) {
        //存储符号的栈
        Stack<String> operators = new Stack<>();
        //存储结果的容器，因为最后要逆序打印，而且没有pop操作，所以使用list容器
        List<String> result = new ArrayList<>();
        //正则表达式
        String regex = "(\\d+(\\.\\d+)?)|([+/*()-])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(prefix);
        //临时存储匹配到的值
        String temp = "";
        while (matcher.find()) {
            temp = matcher.group();
            if (temp.matches("\\d+(\\.\\d+)?")) {
                //数字,直接压入结果集
                result.add(temp);
            } else if (temp.matches("[/*+()-]")) {
                //运算符
                if (operators.empty() || LEFT_BRACKET.equals(operators.peek())) {
                    //如果是空栈或者是栈顶是左括号就直接入栈
                    operators.push(temp);
                } else if (RIGHT_BRACKET.equals(temp)) {
                    //如果是右括号“)”，则依次弹出operator栈顶的运算符，并压入result，
                    // 直到遇到左括号为止，此时将这一对括号丢弃
                    while (!operators.empty() && !LEFT_BRACKET.equals(operators.peek())) {
                        result.add(operators.pop());
                    }
                    //舍去左括号
                    operators.pop();
                } else {
                    // 若优先级比栈顶运算符的高，也将运算符压入operators；
                    //否则，将operators栈顶的运算符弹出并压入到result中，再与operators中新的栈顶运算符相比较；
                    //不管怎么样，新的运算符始终要压入operators中
                    while (!operators.empty() && getPriority(temp) <= getPriority(operators.peek())) {
                        result.add(operators.pop());
                    }
                    operators.add(temp);
                }
            }
        }
        //循环结束，把operators中的元素一次放入result中
        //因为每次取出数据的时候operators.size()都会改变
        //需要临时的变量把它储存起来
        int length = operators.size();
        for (int i = 0; i < length; i++) {
            result.add(operators.pop());
        }
        return result;
    }

    /**
     * 比较运算符的级别
     */
    private static int getPriority(String operator) {
        if (MULTIPLY.equals(operator) || DIVIDE.equals(operator)) {
            return 1;
        } else if (PLUS.equals(operator) || SUBTRACT.equals(operator)) {
            return 0;
        }
        return -1;
    }

    /**
     * 计算逆波兰表达式
     * 支持小数
     *
     * @param str 中缀表达式
     */
    public static String calculateInfix(String str) {

        //处理过后的中缀表达式
        List<String> postfix = convert(str);
        //结果栈
        Stack<Double> result = new Stack<>();
        //从集合中一次取出，并进行判断
        for (String item : postfix) {
            if (item.matches("\\d+(\\.\\d+)?")) {
                //是数字的话就压栈
                result.push(Double.parseDouble(item));
            } else if (item.matches("[/*+-]")) {
                //运算符就从栈中取出两个元素，进行运算，然后放入栈中
                double j = result.pop();
                double i = result.pop();
                result.push(calculator(i, j, item));
            }
        }
        return trim(result.peek());
    }

    /**
     * @param i        运算符前面的数字
     * @param j        运算符后面的数字
     * @param operator 运算符
     * @return 运算结果
     */
    private static double calculator(double i, double j, String operator) {
        double result = 0;
        if (PLUS.equals(operator)) {
            result = i + j;
        } else if (SUBTRACT.equals(operator)) {
            result = i - j;
        } else if (MULTIPLY.equals(operator)) {
            result = i * j;
        } else if (DIVIDE.equals(operator)) {
            result = i / j;
        }
        return result;
    }

    /**
     * 去除double类型末尾多余的0
     */
    private static String trim(double value) {
        String temp = String.valueOf(value);
        temp = temp.replaceAll("(0+)?$", "");
        return temp.replaceAll("\\.$", "");
    }
}
