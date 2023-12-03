package com.yinmu;


/**
 * @author 饮木
 */
class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(10);
        arrayStack.push(8);
        arrayStack.push(7);
        arrayStack.push(4);
        arrayStack.pop();
        arrayStack.print();
    }
}