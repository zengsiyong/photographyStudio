package com.zengsy.pojo;

public class Category {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	// 重写toString方法，当打印Category对象的时候，会打印其名称。
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
