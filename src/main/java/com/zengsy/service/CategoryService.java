package com.zengsy.service;

import java.util.List;

import com.zengsy.pojo.Category;
import com.zengsy.util.Page;

public interface CategoryService {

	//List<Category> list(Page page);

	//int total();

	List<Category> list();

	void add(Category category);

	void delete(int id);

	Category get(int id);

	void update(Category category);
}
