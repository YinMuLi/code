package com.yinmu;


/**
 * @author 饮木
 * @Date 2022年06月17日15时36分
 */
class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable test = new MyHashTable(10);
        test.add(new Employee(1, "张三"));
        test.add(new Employee(15, "李四"));
        test.add(new Employee(25, "王五"));
        test.delete(1);
        test.list();
        test.add(new Employee(1, "PDD"));
        test.list();
    }
}