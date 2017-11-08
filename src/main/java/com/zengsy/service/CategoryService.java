package com.zengsy.service;

import java.util.List;

import com.zengsy.pojo.Category;
import com.zengsy.util.Page;

public interface CategoryService {

	int total();

	List<Category> list(Page page);

	void add(Category category);

	void delete(int id);

	Category get(int id);

	void update(Category category);
}
