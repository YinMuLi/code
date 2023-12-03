package link;

/**
 * @author 饮木
 * @Date 2022/7/2
 * @Description description
 */
public class Link3 {
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
     * @param head 链表的头节点
     * @return 返回链表的头节点
     */
    public ListNode reverseList(ListNode head) {
        //使用双链表的方式
        //新链表的头节点
        ListNode newLink = null;
        ListNode temp;
        while (head != null) {
            //暂存没访问过的下一个节点
            temp = head.next;
            //每从原始的链表访问到一个节点，就把这个节点取下来，使之称为新链表的头节点
            head.next = newLink;
            newLink = head;
            //移动到下一个节点
            head = temp;
        }
        return newLink;
    }
}
