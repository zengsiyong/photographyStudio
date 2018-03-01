package com.zengsy.service;

import com.zengsy.pojo.Review;

import java.util.List;

/**
 * 提供CURD以及通过产品获取评价
 * Created by zengsy on 2018-02-28.
 */
public interface ReviewService {
    void add(Review c);
    void delete(int id);
    void update(Review c);
    Review get(int id);
    List list(int pid);

    int getCount(int pid);

}
