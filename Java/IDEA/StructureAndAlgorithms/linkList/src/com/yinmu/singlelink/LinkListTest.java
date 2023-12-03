package com.yinmu.singlelink;

/**
 * @author 饮木
 */
class LinkListTest {
    public static void main(String[] args) {
        //创建接个hero的节点
        //这里的排名都是重网上找的
        HeroNode a = new HeroNode(20, "赤井秀一", "名侦探柯南");
        HeroNode b = new HeroNode(18, "孙悟空", "七龙珠");
        HeroNode c = new HeroNode(19, "渚薰", "新世纪福音战士");
        //创建量表对象
        LinkList linkList = new LinkList();
        //向链表中添加数据
        linkList.pushBack(a);
        linkList.pushBack(c);
        linkList.pushBack(b);
        linkList.reversePrint();
    }
}