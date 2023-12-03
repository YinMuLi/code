package yinmu.queue;

/**
 * @Author 饮木
 * @Date 2023/3/15 20:41
 * @Description
 */
public class LoopQueue {
    private int size;
    private int[] data;
    private int front;
    private int rear;
    /**
     * 计算队列中的元素个数
     */
    private int counter;

    public LoopQueue(int size) {
        this.size = size;
        data = new int[size];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == size;
    }

    public void enterQueue(int value) {
        if (isFull()) {
            return;
        }
        counter++;
        data[rear] = value;
        rear = (rear + 1) % size;
    }

    public int deviateQueue() {
        if (isEmpty()) {
            return 0;
        }
        int temp = data[rear];
        counter--;
        rear = (rear - 1) % size;
        return temp;
    }
}
