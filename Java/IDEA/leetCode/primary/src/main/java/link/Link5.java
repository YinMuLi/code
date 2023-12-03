package link;

/**
 * @author 饮木
 * @Date 2022/7/3
 * @Description description
 */
public class Link5 {
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
     * @param head 头节点
     * @return true:回文链表；false：不是回文链表
     */
    public boolean isPalindrome(ListNode head) {
        //通过快慢指针来寻找链表的中点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            //快指针的步长是慢指针的两倍
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast!=null,链表的长度是奇数
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半截的链表
        slow = reverseLink(slow);
        //判断是否为回文链表
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;

            slow = slow.next;
        }
        return true;
    }

    /**
     * 反转链表
     *
     * @param head 头节点
     * @return 返回新链表的头节点
     */
    private ListNode reverseLink(ListNode head) {
        ListNode newLink = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = newLink;
            newLink = head;
            head = temp;
        }
        return newLink;
    }
}
