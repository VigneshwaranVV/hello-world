package com.niit.bikes.services;

import java.util.List;

import com.niit.bikes.model.SupplierModel;

public interface SupplierService {

	void insertSupplierModel(SupplierModel u);

	List<SupplierModel> getSupplierList();

	void update(SupplierModel k);

	void remove(Integer id);

}
