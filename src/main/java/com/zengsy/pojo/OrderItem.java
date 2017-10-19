package com.zengsy.pojo;


/**
 * Created by zengsy on 2017-10-09.
 * 存放订单项信息，即点击购买按钮后确定订单信息的页面，区分带表已经确认提交的订单Order类
 * 基本属性的getter、setter
 * 与Product的多对一关系
 * 与User的多对一关系
 * 与Order的多对一关系
 * 外键pid，指向产品表id字段
 * 外键oid，指向订单表id字段
 * 外键uid，指向用户表id字段
 * number字段表示购买数量
 * oid外键没有加约束，是因为创建订单项的时候，其所对应的订单可能还未创建
 */
public class OrderItem {
    private int number;
    private Product product;
    private Order order;
    private User user;
    private int id;
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
