package com.niit.bikes.dao;

import java.util.List;

import com.niit.bikes.model.CategoryModel;

public interface CategoryDAO {

	void insertCategoryModel(CategoryModel u);

	List<CategoryModel> getCategoryList();

	void updateCategoryModel(CategoryModel l);

	void remove(Integer id);

	

}
