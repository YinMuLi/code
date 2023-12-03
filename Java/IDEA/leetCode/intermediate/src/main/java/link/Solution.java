package link;

/**
 * @author 饮木
 * @Date 2022/7/9
 * @Description 链表
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        //指向新链表的头节点
        ListNode head = null;
        int temp = 0;
        //数在链表中都是倒叙存储的。
        //while条件中temp!=0：只要上一次进了10，循环就可以进行下去。
        while (l1 != null || l2 != null || temp != 0) {
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            if (result == null) {
                result = new ListNode(temp % 10);
                //指向新链表的头节点
                head = result;
            } else {
                result.next = new ListNode(temp % 10);
                result = result.next;
            }
            //保留进十的结果
            temp /= 10;
        }

        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        //存放偶数节点
        ListNode even = new ListNode();
        //记录偶数节点的头节点
        ListNode evenHead = even;
        ListNode temp = head;
        while (temp.next != null) {
            //temp.next指向的永远是偶数节点
            even.next = temp.next;
            //从原节点中删去偶数节点
            temp.next = temp.next.next;
            even = even.next;
            //移动到下一个奇数节点
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //防止偶数链表出现环型
        even.next = null;
        //奇数节点连接偶数节点
        temp.next = evenHead.next;
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //不能改变链表的数据结构
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            if (tempA == null) {
                //如果指针tempA不为空，tempA就往后移一步。
                //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
                tempA = headB;
            } else {
                tempA = tempA.next;
            }

            if (tempB == null) {
                tempB = headA;
            } else {
                tempB = tempB.next;
            }
        }
        //tempA要么是空，要么是两链表的交点
        return tempA;
    }
}
