package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 饮木
 * @Date 2022/8/19 7:33
 * @Description TODO
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (b == null) {
            return a;
        }
        if (a == null) {
            return b;
        }
        //新链表的头节点
        ListNode head = new ListNode();
        ListNode temp = head;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        if (a == null) {
            temp.next = b;
        } else {
            temp.next = a;
        }
        return head.next;
    }

    public ListNode sortList(ListNode head) {
        /*
        归并排序
         */
        //先排除特殊的情况
        if (head == null || head.next == null) {
            return head;
        }
        return merge(head, null);
    }

    private ListNode merge(ListNode start, ListNode end) {
        //这个区间是左闭右开的
        if (start.next == end) {
            //断开节点
            start.next = null;
            return start;
        }
        //利用快慢指针寻找节点的终点
        ListNode fast = start;
        ListNode slow = start;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return mergeTwoLists(merge(start, slow), merge(slow, end));
    }

    public Node copyRandomList(Node head) {
        //利用HashMap记录新节点和旧节点
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node newNode = map.get(temp);
            newNode.next = map.get(temp.next);
            newNode.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
