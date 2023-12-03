package design;

/**
 * @author 饮木
 * @Date 2022/7/6
 * @Description Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack {
    /**
     * 栈中最小值
     */
    private int min;
    /**
     * 头节点
     */
    private StackNode head;

    /**
     * 构造函数
     */
    public MinStack() {

    }

    /**
     * 向栈中插入值
     *
     * @param val 要插入的值
     */
    public void push(int val) {
        if (head == null) {
            //head==null:插入的是该最小栈的第一个元素
            head = new StackNode(val, null, val);
            return;
        }
        //在最小栈添加元素的时候，更新最小值
        head = new StackNode(val, head, Math.min(head.currentMin, val));
    }

    /**
     * 删除栈顶的元素
     */
    public void pop() {
        if (head == null) {
            throw new RuntimeException("栈为空");
        }
        head = head.next;
    }

    /**
     * @return 栈顶元素
     */
    public int top() {
        if (head == null) {
            throw new RuntimeException("栈为空");
        }
        return head.value;
    }

    /**
     * @return 栈中的最小值
     */
    public int getMin() {
        return head.currentMin;
    }
}

class StackNode {
    public int value;
    public StackNode next;
    /**
     * 记录在栈中插入该元素时的最小值
     */
    public int currentMin;

    public StackNode(int value, StackNode next, int currentMin) {
        this.value = value;
        this.next = next;
        this.currentMin = currentMin;
    }
}

