package com.yinmu.pojo;

/**
 * 作者：饮木
 */
public class User {
    private int id;
    private String account;
    //我在数据库中设置了主键的自增，所以增加了这个构造方法
    private String pwd;

    public User() {
    }

    public User(int id, String account, String pwd) {
        this.id = id;
        this.account = account;
        this.pwd = pwd;
    }

    public User(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
