package com.niit.bikes.dao;

import java.util.List;

import com.niit.bikes.model.ProductModel;

public interface ProductDAO {

	void insertProductModel(ProductModel u);

	List<ProductModel> getProductList();

	void updateProductModel(ProductModel p);

	void remove(Integer id);

}
