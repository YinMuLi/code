package com.yinmu;

import com.yinmu.postfixcalculator.PostfixCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 饮木
 */
class CalculatorTest {
    public static void main(String[] args) {
        //calculator("12-12+1");
        System.out.println(PostfixCalculator.calculateInfix("1+1/2"));
    }

    /**
     * 计算传入的表达式
     */
    public static void calculator(String str) {
        //字符串的长度
        int length = str.length();
        //创建存放数字和运算符号的栈
        Calculator num = new Calculator(length / 2 + 1);
        Calculator operator = new Calculator(length / 2);
        //正则表达式
        String regex = "(\\d+)|([+/*-])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        //先是把整个字符拆分开来，
        while (matcher.find()) {
            if (matcher.group().matches("\\d+")) {
                //如果是数字，就存储到数字的栈中
                num.push(Integer.parseInt(matcher.group()));
            } else if (matcher.group().matches("[/*+-]")) {
                //如果是运算符
                if (!operator.isEmpty() && operator.priority(matcher.group().charAt(0)) <= operator.priority(operator.peek())) {
                    //如果当前的运算符比栈顶部的运算符级别小
                    //就先把存储在栈中的运算符取出来计算
                    int a = num.pop();
                    int b = num.pop();
                    num.calculator(b, a, operator.pop());
                }
                operator.push(matcher.group().charAt(0));
            }
        }
        //进行同级别的计算
        length = operator.getLength();
        for (int i = 0; i < length; i++) {
            int a = num.pop();
            int b = num.pop();
            num.calculator(b, a, operator.pop());
        }
        System.out.println(num.peek());
    }
}