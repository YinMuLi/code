package com.yinmu;


/**
 * @author 饮木
 */
class CircleQueueTest {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.remove();
        queue.add(6);
        System.out.println(queue.getSize());
    }
}