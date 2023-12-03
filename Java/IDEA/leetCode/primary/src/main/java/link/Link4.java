package link;

/**
 * @author 饮木
 * @Date 2022/7/2
 * @Description description
 */
public class Link4 {
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
     * @param list1 升序链表一
     * @param list2 升序链表二
     * @return 新链表的头节点
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        //排除特殊情况
//        if (list1 == null) {
//            return list2;
//        }
//        if (list2 == null) {
//            return list1;
//        }
//        //创建一个新的链表来融合链表一和链表二
//        ListNode newNode = new ListNode();
//        ListNode temp = newNode;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                temp.next = list1;
//                list1 = list1.next;
//            } else {
//                temp.next = list2;
//                list2 = list2.next;
//            }
//
//            //temp指向新链表的尾节点
//            temp = temp.next;
//        }
//        //跳出循环时list1或这list2中必有一个为空
//        //把不为空的链表，连到新链表上
//        if (list1 == null) {
//            temp.next = list2;
//        } else {
//            temp.next = list1;
//        }
//        return newNode.next;
        //递归的方法，不用构建新的链表
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //开始递归,不好解释
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }
}
