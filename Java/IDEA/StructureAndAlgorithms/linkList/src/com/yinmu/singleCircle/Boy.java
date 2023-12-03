package com.yinmu.singleCircle;

/**
 * @author 饮木
 * 节点类
 */
public class Boy {
    private int index;
    public Boy next;

    public Boy(int index) {
        this.index = index;
    }

    public Boy() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
