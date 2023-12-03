package com.yinmu.doublelink;

/**
 * @author 饮木
 */
class DoubleLinkListTest {
    public static void main(String[] args) {
        HeroNode a = new HeroNode(20, "赤井秀一", "名侦探柯南");
        HeroNode b = new HeroNode(18, "孙悟空", "七龙珠");
        HeroNode c = new HeroNode(19, "渚薰", "新世纪福音战士");
        //创建双向链表对象
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        //添加数据
        doubleLinkList.pushBack(a);
        doubleLinkList.pushBack(c);
        doubleLinkList.pushBack(b);
        //删除一个节点
        doubleLinkList.delete(20);
        //输出
        doubleLinkList.print();
    }
}