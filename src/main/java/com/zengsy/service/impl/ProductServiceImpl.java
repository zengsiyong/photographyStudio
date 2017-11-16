package com.zengsy.service.impl;

import com.zengsy.mapper.ProductMapper;
import com.zengsy.pojo.Category;
import com.zengsy.pojo.Product;
import com.zengsy.pojo.ProductExample;
import com.zengsy.pojo.Property;
import com.zengsy.service.CategoryService;
import com.zengsy.service.ProductService;
import com.zengsy.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xlc on 2017-11-14.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;


    @Override
    public List list(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List result = productMapper.selectByExample(example);
        setCategory(result);
        return result;
    }

    @Override
    public void add(Product p) {
        productMapper.insert(p);
    }

    @Override
    public void delete(int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Product get(int id) {
        Product p = productMapper.selectByPrimaryKey(id);
        setCategory(p);
        return p;
    }

    @Override
    public void update(Product p) {
        productMapper.updateByPrimaryKeySelective(p);
    }
    // 通过product对象获得cid，再根据categoryservice的get方法获得当前cid对应的category类，存放在pojo Product中方便调用
    public void setCategory(Product p) {
        int cid = p.getCid();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }

    public void setCategory(List<Product> ps) {
        for (Product p : ps) {
            setCategory(p);
        }
    }

}
