package link;

/**
 * @author 饮木
 * @Date 2022/7/1
 * @Description description
 */
public class Link2 {
    private Link2() {
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     *
     * @param head 头结点
     * @param n    倒数第几个节点
     * @return 链表的头结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //以辅助节点代替头结点遍历链表
        ListNode temp = head;
        //要删除的目标节点
        ListNode target = head;
        //记录节点的长度,至少有一个头结点
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
            if (count >= n + 2) {
                target = target.next;
            }
        }
        //如果要删除的节点是头节点
        if (count == n) {
            return target.next;
        }
        //删除目标节点
        target.next = target.next.next;
        return head;
    }
}


