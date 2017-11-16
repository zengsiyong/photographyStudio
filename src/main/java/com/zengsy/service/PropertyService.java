package com.zengsy.service;


import com.zengsy.pojo.Product;
import com.zengsy.pojo.Property;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xlc on 2017-11-13.
 */

public interface PropertyService {
    List list(int cid);
    void add(Property c);
    void delete(int id);
    void update(Property c);
    Property get(int id);

}
