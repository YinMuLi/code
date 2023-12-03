package com.yinmu.singlelink;


/**
 * @author 饮木
 * 模拟单向链表
 */
public class LinkList {
    /**
     * 链表的头节点
     */
    private HeroNode head = null;
    /**
     * 记录链表中有效元素打的个数
     */
    private int size;

    public LinkList() {
        //头节点中不存放任何数据，只是一个记录点
        //来表示链表的开头
        head = new HeroNode();
        size = 0;
    }

    /**
     * 向链表中添加数据
     * 方式：从链表的尾部添加数据
     */
    public void pushBack(HeroNode hero) {
        //创建一个临时的变量来代替头结点
        //头节点不能动
        HeroNode temp = head;
        for (int i = 0; i < size; i++) {
            //获取尾节点
            temp = temp.next;
        }
        temp.next = hero;
        size++;
    }

    /**
     * 按照排名插入数据
     * 如果没有合适的位置插入的话，就尾插
     */
    public void addByRank(HeroNode hero) {
        HeroNode temp = head.next;
        //判断节点中已将存储了的数据的rank属性，
        //和参数hero的rank进行比较
        //只要找到比hero.getRank()大的节点就行了，找小的也行
        //来记录是否存在rank比hero大的节点
        boolean flag = false;
        for (int i = 0; i < size - 1; i++) {
            //如果这里size为0的话就不会执行for循环
            //直接尾插入数据
            if (temp.getRank() > hero.getRank()) {
                flag = true;
                break;
            }
            //每次比较一次，节点后移一位
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            hero.next = temp.next;
            temp.next = hero;
            size++;
        } else {
            pushBack(hero);
        }
    }

    /**
     * 打印链表中的所有元素
     */
    public void print() {
        //判断链表是否为空
        if (size == 0) {
            System.out.println("error : 链表为空");
            return;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size; i++) {
            System.out.println(temp);
            //后移一位
            temp = temp.next;
        }
    }

    /**
     * 更新节点信息
     */
    public void update(int rank, String name, String anime) {
        HeroNode temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.next.getRank() == rank) {
                temp.next.setAnime(anime);
                temp.next.setName(name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("没有该英雄");
    }

    /**
     * 查找倒数第index的节点
     *
     * @param index 倒数节点的序号(index>=1)
     */
    public HeroNode getLastIndexPoint(int index) {
        if (size == 0 || index > size) {
            //链表的容量为0或者传入的数据大于链表的容量
            //抛出运行时的异常
            throw new RuntimeException("error: out range of size");
        }
        //(size-index+1)就是节点的正向排序
        HeroNode temp = head;
        for (int i = 0; i < size - index + 1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 删除节点的信息
     */
    public void delete(int rank) {
        HeroNode temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.next.getRank() == rank) {
                //不需要物理上的删除
                //只要让用户访问不到它
                //java有强大的垃圾回收机制，会体我们回收空间
                temp.next = temp.next.next;
                size--;
                return;
            }
        }
        System.out.println("没有该英雄");
    }

    /**
     * 逆序输出链表中的所有元素
     * 方法：用一个数组把链表中所有的节点存储起来
     * 然后再打印输出
     */
    public void reversePrint() {
        if (size == 0) {
            System.out.println("链表中没有任何元素");
            return;
        }
        HeroNode temp = head;
        //创建存储所有链表节点的数组
        HeroNode[] array = new HeroNode[size];
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            array[i] = temp;
        }
        //逆向输出数组中的元素
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    /**
     * 反转链表额顺序
     * 方法：头节点插入法
     * 需要两个节点：原第一个有效的节点(即正序中第一个有效的节点，一下称为原节点)，和临时节点(临时节点来存储原节点的下一个新的节点)
     * 当遍历到原节点的下一个节点时就是临时节点，使原节点的next指向临时节点的下一个节点，
     * 临时节点的next指向head.next，就是头节点插入法，然后head.next指向临时节点
     * 最后使临时节点等于原节点，因为此时原节点已经成为了第一个有效的节点，需要重置临时节点
     */
    public void reverse() {
        if (size <= 1) {
            return;
        }
        //第一个有效的节点
        HeroNode originFirst = head.next;
        //从第二个节点开始遍历
        HeroNode temp = originFirst;
        for (int i = 0; i < size - 1; i++) {
            temp = temp.next;
            originFirst.next = temp.next;
            temp.next = head.next;
            head.next = temp;
            temp = originFirst;
        }
    }

    /**
     * 获取链表有效元素的个数
     */
    public int getSize() {
        return size;
    }
}
