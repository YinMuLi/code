package com.yinmu.singleCircle;


/**
 * @author 饮木
 * 单向环型列表
 */
public class SingleCircle {
    /**
     * 理论上的头节点
     */
    private Boy head;
    /**
     * 链表的长度
     */
    private int length;

    public SingleCircle() {
        //自己构成环
        head = new Boy();
        head.next = head;
        length = 0;
    }

    /**
     * 形成的环默认从1开始，依次递增。
     * 这种是先创建单向链表，最后在成环
     *
     * @param num 初始化环的大小(num>=1)
     */
    public SingleCircle(int num) {
        head = new Boy(1);
        //在没有成环之前永远指向尾节点
        Boy cursor = head;
        for (int i = 1; i < num; i++) {
            //尾节点指向新的对象
            cursor.next = new Boy(i + 1);
            //尾节点后移一位，重新指向列表的尾部
            cursor = cursor.next;
        }
        //最后让尾节点指向头节点，构成环型
        cursor.next = head;
        length = num;
    }

    /**
     * 这里没有对相同编号的对象进行排除
     *
     * @param value 不允许插入同样编号的数值，因为后面要解决约瑟夫环问题
     */
    public void pushBack(Boy value) {
        if (length == 0) {
            head.next = value;
            value.next = head;
            length++;
        } else {
            Boy temp = head;
            for (int i = 0; i < length - 1; i++) {
                //temp指向尾部节点
                temp = temp.next;
            }
            temp.next = value;
            value.next = head;
            length++;
        }
    }

    /**
     * 解决约瑟夫环问题
     * Josephu 问题为：设编号为 1，2，… n 的 n 个人围坐一圈，
     * 约定编号为 k（1<=k<=n）的人从 1 开始报数，
     * 数到 m 的那个人出列，它的下一位又从 1 开始报数，数到 m 的那个人又出列，
     * 依次类推，直到所有人出列为止，
     * 由此产生一个出队编号的序列。
     *
     * @param k 从第几位开始
     * @param m 出局的数字
     */
    public void josephu(int k, int m) {
        if (length <= 1) {
            System.out.println("人数不中，不足以构成游戏");
            return;
        }
        Boy temp = head;
        //找到第k位
        for (int i = 0; i < k % length - 1; i++) {
            temp = temp.next;
        }
        //当count为0的时候游戏结束
        int count = length;
        Boy cursor = head;
        while (count != 0) {
            for (int i = 0; i < m - 2; i++) {
                //获取报到m的前一位
                cursor = cursor.next;
            }
            System.out.println(cursor.next.getIndex());
            //使前一位的next指向报m的下一位
            cursor.next = cursor.next.next;
            //使游标指向报到m的下一位
            cursor = cursor.next;
            count--;
        }
    }
}
