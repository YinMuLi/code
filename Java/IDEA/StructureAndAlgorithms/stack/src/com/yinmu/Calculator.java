package com.yinmu;


/**
 * @author 饮木
 * 模拟中缀的栈类型的简单计算器
 */
public class Calculator {
    /**
     * 表示栈的顶部,并指向最后插入的数据
     */
    private int top;
    /**
     * 模拟栈的数组
     */
    private int[] stack;
    /**
     * 栈的最大容量
     */
    private int capacity;

    /**
     * 初始化栈
     *
     * @param capacity 构建栈的容量
     */
    public Calculator(int capacity) {
        this.capacity = capacity;
        //一开始栈顶的值为-1
        top = -1;
        //初始化栈
        stack = new int[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 判断栈是否为已满
     */
    public boolean isFull() {
        return top == capacity - 1;
    }

    /**
     * 压栈，向栈中插入数据
     */
    public void push(int value) {
        //如果栈已经满了,就不能向其中插入数据了
        if (isFull()) {
            System.out.println("error:栈已满");
            return;
        }
        //向栈中插入数据
        top++;
        stack[top] = value;
    }

    /**
     * 向栈中取出数据，即弹栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("error:栈为空");
        }
        //从栈中取出数据
        int temp = stack[top];
        top--;
        return temp;
    }

    /**
     * 打印栈中的所有数据,从栈顶开始
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("error:栈为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    /**
     * 指定运算符的优先级
     * priority有优先级的意思
     *
     * @param operator 运算符字符
     * @return 返回的数字越大，优先级越高
     */
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 返回栈顶的值
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 把计算出来的结果自动存储到栈中
     *
     * @param i        运算符前面的数
     * @param j        运算符后面的数
     * @param operator 运算符
     */
    public void calculator(int i, int j, int operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = i + j;
                break;
            case '-':
                result = i - j;
                break;
            case '*':
                result = i * j;
                break;
            case '/':
                result = i / j;
                break;
            default:
        }
        push(result);
    }

    /**
     * 返回栈的实际大小
     */
    public int getLength() {
        return top + 1;
    }
}
