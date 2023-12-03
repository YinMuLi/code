package link;


/**
 * @author 饮木
 * @Date 2022/7/3
 * @Description description
 */
public class Link6 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     * 删除链表中的节点
     *
     * @param head 头节点
     * @return true:是环型链表；false：不是环型链表
     */
    public boolean hasCycle(ListNode head) {
        //快慢指针，如果快指针追上了慢指针，就说明该链表是环型链表
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
