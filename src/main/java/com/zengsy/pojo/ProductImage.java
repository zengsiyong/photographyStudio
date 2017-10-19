package com.zengsy.pojo;

/**
 * Created by zengsy on 2017-10-09.
 * 这是作品图片表
 * 与Product是多对一的关系
 * type表示类型，产品图片分单个图片和详情图片两种
 * 本表的外键pid，指向产品表的id字段
 */
public class ProductImage {

    private String type;
    private Product product;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}