package com.niit.bikes.services;

import java.util.List;

import com.niit.bikes.model.CategoryModel;
import com.niit.bikes.model.ProductModel;
import com.niit.bikes.model.SupplierModel;

public interface ProductService {
	public void insertProductModel(ProductModel u);


	public List<ProductModel> getProductList();


	public void update(ProductModel p);


	public void remove(Integer id);


	

	

}

