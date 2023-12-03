package com.yinmu.singlelink;

/**
 * @author 饮木
 * 链表中的节点
 */
public class HeroNode {
    private int rank;
    private String name;
    private String anime;
    /**
     * 指向下一个节点
     */
    public HeroNode next;

    public HeroNode(int rank, String name, String anime) {
        this.rank = rank;
        this.name = name;
        this.anime = anime;
    }

    public HeroNode() {
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", anime='" + anime + '\'' +
                '}';
    }
}
