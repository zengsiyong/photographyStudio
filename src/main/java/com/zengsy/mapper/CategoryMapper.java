package com.zengsy.mapper;
 
import java.util.List;

import com.zengsy.pojo.Category;
import com.zengsy.util.Page;

public interface CategoryMapper {
    // 提供一个支持分页的查询方法list(Page page)和获取总数的方法total
    public List<Category> list(Page page);

    public int total();
      
    public int add(Category category);  

    public void delete(int id);  
       
    // 在分类管理界面点击编辑出现的界面所需
    public Category get(int id);  
     
    // 在点击编辑出现的界面完成修改后更新数据库的操作
    public int update(Category category);   
       

}