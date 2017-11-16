package com.zengsy.service;

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

}
