package com.zengsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zengsy.mapper.CategoryMapper;
import com.zengsy.pojo.Category;
import com.zengsy.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;
	
	
	public List<Category> list(){
		return categoryMapper.list();
	}


}
