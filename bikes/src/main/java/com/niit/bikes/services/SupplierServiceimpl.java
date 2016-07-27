package com.niit.bikes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.bikes.dao.SupplierDAO;

import com.niit.bikes.model.SupplierModel;
@Service
public class SupplierServiceimpl implements SupplierService {
@Autowired
SupplierDAO supplierDAO;
	
	public void insertSupplierModel(SupplierModel u) {
		// TODO Auto-generated method stub
		supplierDAO.insertSupplierModel(u);
	}

	public List<SupplierModel> getSupplierList() {
		// TODO Auto-generated method stub
		System.out.println("In SERVICE");
		List<SupplierModel> a1=supplierDAO.getSupplierList();
		System.out.println(a1);
		return a1;
	}

	public void update(SupplierModel k) {
		// TODO Auto-generated method stub
		supplierDAO.updateSupplierModel(k);
	}

	
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		supplierDAO.remove (id);
	}

}
