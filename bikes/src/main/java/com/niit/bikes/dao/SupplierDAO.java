package com.niit.bikes.dao;

import java.util.List;

import com.niit.bikes.model.SupplierModel;

public interface SupplierDAO {

	void insertSupplierModel(SupplierModel u);

	List<SupplierModel> getSupplierList();

	void updateSupplierModel(SupplierModel k);

	void remove(Integer id);

}
