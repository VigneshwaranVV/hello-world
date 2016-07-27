package com.niit.bikes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.bikes.dao.CategoryDAO;
import com.niit.bikes.model.CategoryModel;

@Service
public class CategoryServiceimpl implements CategoryService {

	@Autowired
	CategoryDAO categoryDAO;
	public void insertCategoryModel(CategoryModel u) {
		// TODO Auto-generated method stub
		
		categoryDAO.insertCategoryModel(u);
		}
	public List<CategoryModel> getCategoryList() {
		// TODO Auto-generated method stub
		System.out.println("In SERVICE");
		List<CategoryModel> a1=categoryDAO.getCategoryList();
		System.out.println(a1);
		return a1;
		
	}
	public void update(CategoryModel l) {
		// TODO Auto-generated method stub
		categoryDAO.updateCategoryModel(l);
	}

	public void remove(Integer id) {
		// TODO Auto-generated method stub
		categoryDAO.remove(id);
	}

	
}
