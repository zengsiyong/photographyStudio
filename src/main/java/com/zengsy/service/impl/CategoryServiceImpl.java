package com.zengsy.service.impl;

import java.util.List;

import com.zengsy.pojo.CategoryExample;
import com.zengsy.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zengsy.mapper.CategoryMapper;
import com.zengsy.pojo.Category;
import com.zengsy.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;

	// 提供一个支持分页的查询方法list(Page page)和获取总数的方法total
	//@Override
	//public List<Category> list(Page page){
	//	return categoryMapper.list(page);
	//}
    //
	//@Override
	//public int total() {
	//	return categoryMapper.total();
	//}


	@Override
	public List<Category> list() {
		//return categoryMapper.list();
		CategoryExample example = new CategoryExample();
		example.setOrderByClause("id desc");
		return categoryMapper.selectByExample(example);
	}


	@Override
	public void add(Category category) {
		categoryMapper.insert(category);

	}

	@Override
	public void delete(int id) {
		categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Category get(int id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Category category) {
		categoryMapper.updateByPrimaryKeySelective(category);
	}


}
