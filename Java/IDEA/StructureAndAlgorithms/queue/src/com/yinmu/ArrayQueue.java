package com.yinmu;

/**
 * @author 饮木
 */
public class ArrayQueue {
    /**
     * 指向队列的头部
     */
    private int front;
    /**
     * 指向队列的尾部
     */
    private int rear;
    /**
     * 表示队列容器的大小
     */
    private int capacity;
    /**
     * 模拟队列的数组
     */
    int[] array;

    /**
     * 根据传入大小，构建数组
     *
     * @param capacity 传入队列初始的大小
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        //一开始头指针和尾指针都等于-1
        //但是两个-1表示的含义却不一样
        //front 指向队列第一位元素的前一位
        //rear 指向队列最后一位元素的位置，-1就表示，没有数据。
        front = -1;
        rear = -1;
        //构造数组
        array = new int[capacity];
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return rear == capacity - 1;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 向对列中添加元素
     */
    public void addElement(int value) {
        //先判断队列是否已满
        if (isFull()) {
            throw new RuntimeException("当前队列已满，无法再添加新的元素");
        }
        //尾指针向后移一位
        rear++;
        //给尾指针指向的数据赋值
        array[rear] = value;
    }

    /**
     * 从队列中移除数据
     */
    public int removeElement() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空，无法取出袁术");
        }
        //头指针向后移一位
        front++;
        //返回头指针指向的元素
        return array[front];
    }

    /**
     * 返回队列中的第一个元素
     */
    public int getFirstElement() {
        return array[front + 1];
    }

    /**
     * 获取队列中元素的个数
     */
    public int getSize() {
        return rear - front;
    }

    /**
     * 显示队列中的所有元素
     */
    public void showArrayQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空");
        }
        for (int i = front + 1; i < getSize(); i++) {
            System.out.println(array[i]);
        }
    }
}