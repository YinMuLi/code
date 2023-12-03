package com.yinmu;

/**
 * @author 饮木
 * 使用 数组模拟栈
 */
public class ArrayStack {
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
    public ArrayStack(int capacity) {
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
}
