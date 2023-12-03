package link;

/**
 * @author 饮木
 * @Date 2022/7/1
 * @Description description
 */
public class Link1 {
    private Link1() {
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     * 删除链表中的节点
     *
     * @param node 要删除的节点
     */
    public static void deleteNode(ListNode node) {
//        //传入的节点就是要删除的节点，所以不知道它的上一个节点
//        //只能把后面的值赋给前面的值，然后删除最后一个节点
//        ListNode previous=node;
//        while (node.next!=null){
//            //用后面值替换掉前面的值
//            node.val=node.next.val;
//            //先把当前的节点记录下来
//            previous=node;
//            //节点往后移，此时previous就是node节点的上一个节点
//            node=node.next;
//        }
//        //跳出循环的时候就是node.next==null，即node是该链表的尾结点
//        previous.next=null;

        //看了下面的评论才知道，我TM太笨了
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

