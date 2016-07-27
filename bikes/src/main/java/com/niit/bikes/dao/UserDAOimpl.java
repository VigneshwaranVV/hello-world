package com.niit.bikes.dao;
import com.niit.bikes.model.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UserDAOimpl implements UserDAO{

	Logger log = LoggerFactory.getLogger(UserDAOimpl.class);    


	@Autowired
	private SessionFactory sessionFactory;   
	
	public UserDAOimpl() {}
		
	public UserDAOimpl(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			log.error(" Unable to connect to db");
			e.printStackTrace();
		}
	}

	

	@Transactional
	public void insertSignupModel(SignupModel sm)
	{
		Session s=this.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.save(sm);
		t.commit();
	}
	
	@Transactional
	public boolean isValidUser(String un, String pd){
		System.out.println("UserDAOImpl - isValidUser() started");
		String hql = "from UserDetails where username= '" + un + "' and " + " password ='" + pd + "'";
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		for(UserDetails u : list){
			System.out.println(u.isAdmin());
		}
		if (list != null && !list.isEmpty()) {
			return true;
		}
		System.out.println("isValidUser() ended");
		return false;
	}
	
	@Transactional
	public boolean isAdminUser(String un, String pd){
		System.out.println("UserDAOImpl - isAdminUser() started");
		String hql = "from UserDetails where username= '" + un + "' and " + " password ='" + pd + "'";
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Query query1 = sessionFactory.openSession().createQuery(hql);		
		boolean res=false;
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query1.list();
		for(UserDetails u : list){			
			System.out.println(u.isAdmin());
			res = u.isAdmin();
		}
		return res;
	}

	public void insertUserDetails(UserDetails u) {
		// TODO Auto-generated method stub
		{
			Session s=this.sessionFactory.openSession();
			Transaction t=s.beginTransaction();
			s.save(u);
			t.commit();
		}
	}
	  @SuppressWarnings("unchecked")
	   	@Transactional(propagation=Propagation.SUPPORTS)
	       
	   	public List<UserDetails> getUserList()// method of ProductDAOInt defined
	   	{
	   		System.out.println("-----------  "+sessionFactory);
	   		Session s=sessionFactory.openSession();
	   		Transaction t = s.beginTransaction();
	   		System.out.println("In dao ");
	   		List<UserDetails> al=new ArrayList<UserDetails>();
	   				 al=s.createQuery("from UserDetails").list();
	   		 t.commit();
	   		 return al;
	   	}

	
}

