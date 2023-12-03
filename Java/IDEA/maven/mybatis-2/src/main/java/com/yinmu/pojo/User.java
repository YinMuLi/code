package com.yinmu.pojo;

/**
 * 作者：饮木
 */
public class User {
    private int id;
    private String account;

    //我在数据库中设置了主键的自增，所以增加了这个构造方法
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    private String password;

    public User(int id, String account, String password) {
        this.id = id;
        this.account = account;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
