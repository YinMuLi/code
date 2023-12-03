package com.yinmu;

/**
 * @author 饮木
 * 环形数组(把数组想象成一个环)
 * front: 指向队列的第一个元素，也就是说array[front]就是队列的第一个元素
 * rear: 指向队列的最后一个元素的后一位，因为希望空出一个空间作为约定，
 * 约定：声明一个容量为5的环形队列，但实际上只能存储4个元素，牺牲掉一个空间来存储raer
 * front和rear的初始值都是0
 * 当队列满时，条件是 (rear+1)%capacity==front
 * 解释：有两种情况
 * 1.rear在front的前面，一开始就是这种情况。
 * 这种情况满，只能是rear指向capacity-1,front指向0
 * 2.rear在front的后面，循环一次就成了这种情况
 * 这种情况满，是rear指向n,front指向n+1
 * 总结(rear+1)%capacity这种取余，真是好奇妙
 * 队列为空的情况：rear==front
 * 队列中的有效个数(rear-font+capacity)%capacity
 * 为了防止rear-front出现负数的情况，所有加了capacity
 */
public class CircleQueue {
    private int front;
    private int rear;
    private int capacity;
    private int[] array;

    public CircleQueue(int capacity) {
        //所以声明的时候多声明一个空间来弥补被约定占据的空间
        this.capacity = capacity + 1;
        front = 0;
        rear = 0;
        array = new int[this.capacity];
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 获取队列中元素的有效个数
     */
    public int getSize() {
        return (rear - front + capacity) % capacity;
    }

    /**
     * 向队列中添加元素
     */
    public void add(int value) {
        //先判断队列是否已满
        if (isFull()) {
            throw new RuntimeException("当前队列已满，无法再添加新的元素");
        }
        array[rear] = value;
        //为了防止出现rear+1>capacity的情况
        rear = (rear + 1) % capacity;
    }

    /**
     * 从队列中移除元素
     */
    public int remove() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空，无法取出袁术");
        }
        int temp = array[front];
        //为了防止出现front+1>capacity的情况
        front = (front + 1) % capacity;
        return temp;
    }
}
