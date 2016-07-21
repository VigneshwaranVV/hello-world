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
	public void insertSupplierModel(SupplierModel u)
	{
		supplierDAO.insertSupplierModel(u);
	}
	public List<SupplierModel> getSupplierList() {
		// TODO Auto-generated method stub
		System.out.println("In SERVICE");
		List<SupplierModel> a=supplierDAO.getSupplierList();
		System.out.println(a);
		return a;
	
	}
	public void update(SupplierModel s) {
		// TODO Auto-generated method stub
		supplierDAO.update(s);
		
	}

}
