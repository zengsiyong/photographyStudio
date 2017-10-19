package com.zengsy.pojo;

/**
 * Created by zengsy on 2017-10-09.
 * 这是约拍套餐的所有属性的表
 * 与Category是多对一的关系
 */
public class Property {

    private String name;
    private Category category;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

}