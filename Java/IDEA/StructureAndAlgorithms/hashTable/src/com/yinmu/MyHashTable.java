package com.yinmu;

/**
 * @author 饮木
 * @Date 2022年06月17日15时11分
 * 管理多条链表
 */
public class MyHashTable {
    /**
     * 链表数组
     */
    private EmployeeLinkList[] array;
    /**
     * 数组的大小
     */
    private int capacity;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        //初始化链表数组
        array = new EmployeeLinkList[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = new EmployeeLinkList();
        }
    }

    /**
     * 向链表中添加员工，会自动根据员工的id添加到对应的链表上
     */
    public void add(Employee employee) {
        //取模
        int model = employee.getId() % capacity;
        //添加到对应的链表中
        array[model].add(employee);
    }

    /**
     * 输出链表数组中的信息
     */
    public void list() {
        for (int i = 0; i < capacity; i++) {
            array[i].list();
        }
    }

    /**
     * 根据id查找雇员
     *
     * @param id 要查找雇员的id
     */
    public void find(int id) {
        //取模
        int model = id % capacity;
        Employee employee = array[model].find(id);
        if (employee == null) {
            System.out.println("查无此人");
        } else {
            System.out.println(employee);
        }
    }

    /**
     * 根据id删除员工
     *
     * @param id 要删除信息雇员的id
     */
    public void delete(int id) {
        //取模
        int model = id % capacity;
        int delete = array[model].delete(id);
        if (delete == 0) {
            System.out.println("删除失败");
        } else {
            System.out.println("删除成功");
        }
    }
}
