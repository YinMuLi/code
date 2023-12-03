package linkedList;

/**
 * @Author 饮木
 * @Date 2022/8/19 7:32
 * @Description TODO
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
