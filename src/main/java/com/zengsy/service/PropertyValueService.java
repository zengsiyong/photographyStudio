package com.zengsy.service;

import com.zengsy.pojo.Product;
import com.zengsy.pojo.PropertyValue;

import java.util.List;

/**
 * Created by xlc on 2017-12-03.
 */
public interface PropertyValueService {
    void init(Product p);
    void update(PropertyValue pv);

    PropertyValue get(int ptid, int pid);
    List<PropertyValue> list(int pid);
}
