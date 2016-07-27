package com.niit.bikes.services;

import java.util.List;

import com.niit.bikes.model.CategoryModel;

public interface CategoryService {

	void insertCategoryModel(CategoryModel u);

	List<CategoryModel> getCategoryList();

	void update(CategoryModel l);

	void remove(Integer id);

}
