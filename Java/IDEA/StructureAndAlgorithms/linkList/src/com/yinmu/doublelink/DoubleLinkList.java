package com.yinmu.doublelink;

/**
 * @author 饮木
 * 双向链表
 * 注意要考虑到next和pre两个方面
 * 不想还像单节点那样只用考虑next
 */
public class DoubleLinkList {
    private HeroNode head;
    /**
     * 链表中有效元素的长度
     */
    private int length;

    public DoubleLinkList() {
        head = new HeroNode();
        length = 0;
    }

    public int getLength() {
        return length;
    }

    /**
     * 尾插
     */
    public void pushBack(HeroNode value) {
        HeroNode temp = head;
        //找到链表的尾节点
        for (int i = 0; i < length; i++) {
            temp = temp.next;
        }
        temp.next = value;
        value.pre = temp;
        length++;
    }

    /**
     * 根据rank删除指的节点
     */
    public void delete(int rank) {
        if (length == 0) {
            System.out.println("链表中没有任何元素");
            return;
        }
        HeroNode temp = head;
        for (int i = 0; i < length; i++) {
            temp = temp.next;
            if (temp.getRank() == rank) {
                //让次节点的前一个节点指向次节点的下一个节点
                //让下一个节点的指向指向次节点的前一个节点
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                break;
            }
        }
        length--;
    }

    /**
     * 打印出链表中的所有有效元素
     */
    public void print() {
        if (length == 0) {
            System.out.println("链表中没有任何元素");
            return;
        }
        HeroNode temp = head;
        for (int i = 0; i < length; i++) {
            temp = temp.next;
            System.out.println(temp);
        }
    }
}
