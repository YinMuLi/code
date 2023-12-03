package com.yinmu;

/**
 * @author 饮木
 * @Date 2022年06月17日13时26分
 * 构造函数是默认的构造函数
 */
public class EmployeeLinkList {
    /**
     * 头指针执行第一个employee，因此我们这个链表的head 是直接指向第一个employee，
     * 默认值是null
     */
    private Employee head;
    /**
     * 尾指针，指向最后一个employee
     */
    private Employee end;

    /**
     * 添加雇员到链表中，是尾插法添加雇员。
     */
    public void add(Employee employee) {
        if (head == null) {
            //添加第一个员工
            head = employee;
            end = employee;
            return;
        }
        end.next = employee;
        //尾指针往后移
        end = employee;
    }

    /**
     * 遍历雇员的信息
     */
    public void list() {
        if (head == null) {
            //当前链表为空的情况
            System.out.println("当前链表为空");
            return;
        }
        //当前链表不为空
        //遍历链表输出雇员的信息
        //辅助指针
        Employee temp = head;
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        //换行
        System.out.println();
    }

    /**
     * 根据id查找雇员
     *
     * @param id 要查找雇员的id
     * @return 有就返回雇员对象，没有就返回null
     */
    public Employee find(int id) {
        if (head == null) {
            //链表为空
            return null;
        }
        //链表不为空
        Employee temp = head;
        while (temp != null) {
            if (temp.getId() == id) {
                //id相等退出循环
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 根据雇员的id删除
     *
     * @param id 要删除信息雇员的id
     * @return 成功删除返回1，否则就是0
     */
    public int delete(int id) {
        if (head == null) {
            return 0;
        }
        Employee temp = head;
        //辅助删除指针,前节点
        Employee previous = head;
        while (temp != null) {
            if (temp.getId() == id) {
                //判断既是头结点又是尾节点
                if (temp == head && temp == end) {
                    head = null;
                    end = null;
                } else if (temp == head) {
                    //头节点
                    head = head.next;
                } else if (temp == end) {
                    //尾节点
                    previous.next = null;
                    end = previous;
                } else {
                    //中间节点
                    previous.next = temp.next;
                }
                return 1;
            }
            previous = temp;
            temp = temp.next;
        }
        return 0;
    }
}
