package com.shop.pojo;

/**
 * 作者：饮木
 */
public class Shop {
    private int id;
    private String name;
    private double price;

    public Shop() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Shop(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
