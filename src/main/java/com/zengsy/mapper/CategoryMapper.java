package com.zengsy.mapper;
 
import java.util.List;

import com.zengsy.pojo.Category;
import com.zengsy.util.Page;

public interface CategoryMapper {
 
      
    public int add(Category category);  
       
      
    public void delete(int id);  
       
      
    public Category get(int id);  
     
      
    public int update(Category category);   
       
    // 提供一个支持分页的查询方法list(Page page)和获取总数的方法total
    public List<Category> list(Page page);

    public int total();
}