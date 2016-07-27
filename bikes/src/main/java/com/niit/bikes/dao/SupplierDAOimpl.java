package com.niit.bikes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import com.niit.bikes.model.SupplierModel;

@Repository
public class SupplierDAOimpl implements SupplierDAO {
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Transactional
	public void insertSupplierModel(SupplierModel u) {
		// TODO Auto-generated method stub
		Session s = this.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		s.save(u);
		t.commit();
	}

	 @SuppressWarnings("unchecked")
		@Transactional(propagation=Propagation.SUPPORTS)
		public List<SupplierModel> getSupplierList() {
		// TODO Auto-generated method stub
		 System.out.println("-----------  "+sessionFactory);
			Session s=sessionFactory.openSession();
			Transaction t = s.beginTransaction();
			System.out.println("In dao ");
			List<SupplierModel> al=new ArrayList<SupplierModel>();
					 al=s.createQuery("from SupplierModel").list();
			 t.commit();
			 return al;
	}

	public void updateSupplierModel(SupplierModel k) {
		// TODO Auto-generated method stub
		System.out.println("In update supplier");
		Session s=sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		SupplierModel s1=(SupplierModel)s.load(SupplierModel.class,k.getSupplierid());
		if(s1!=null)
		{
			System.out.println("****inif");
			s.update(k);
		}
		t.commit();
		}

	public void remove(Integer id) {
		{
			System.out.println("in supplier delete");
		
			Session s=sessionFactory.openSession();
			Transaction t=s.beginTransaction();
			SupplierModel p=(SupplierModel)s.load(SupplierModel.class,new Integer(id));
			if(p!=null)
			{
				s.delete(p);
			}
			t.commit();
		}
	}
	}


