package com.zengsy.service;

import com.zengsy.pojo.Category;
import com.zengsy.pojo.Product;

import java.util.List;

/**
 * Created by xlc on 2017-11-14.
 */
public interface ProductService {
    List list(int cid);
    void add(Product p);
    void delete(int id);
    Product get(int id);
    void update(Product p);
    // 新增获取产品的第一张展示图片方法
    void setFirstProductImage(Product p);

    // 首页需要新增的3个方法,2018-02-23

    void fill(List<Category> cs);
    void fill(Category c);
    void fillByRow(List<Category> cs);

}
