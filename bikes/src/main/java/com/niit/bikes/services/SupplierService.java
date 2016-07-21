package com.niit.bikes.services;

import java.util.List;

import com.niit.bikes.model.SupplierModel;

public interface SupplierService {
	public void insertSupplierModel(SupplierModel u);
	List<SupplierModel> getSupplierList();
	public void update(SupplierModel s);


}
