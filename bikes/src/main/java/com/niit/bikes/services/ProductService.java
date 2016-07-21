package com.niit.bikes.services;

import java.util.List;

import com.niit.bikes.model.ProductModel;

public interface ProductService {
	public void insertProductModel(ProductModel u);
	List<ProductModel> getProductList();
	//void remove(Integer pid);
	void update(ProductModel p);

}

