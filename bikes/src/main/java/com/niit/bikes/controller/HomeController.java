package com.niit.bikes.controller;


import com.google.gson.Gson;
import com.niit.bikes.model.CategoryModel;
import com.niit.bikes.model.ProductModel;
import com.niit.bikes.model.SignupModel;
import com.niit.bikes.model.SupplierModel;
import com.niit.bikes.services.CategoryService;
import com.niit.bikes.services.ProductService;
import com.niit.bikes.services.SupplierService;
import com.niit.bikes.services.UserService;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	@Autowired
	UserService us;
    @Autowired
	ProductService ps;
    @Autowired
	CategoryService cs;
    @Autowired
	SupplierService ss;
    @Autowired
    private SessionFactory sf;
	@RequestMapping("/")
	public ModelAndView getHomePage() {	
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	@RequestMapping("/signup")
	public ModelAndView signup() {
        //us.insertSignupModel(sm);
		return new ModelAndView("signup","command",new SignupModel());
	}
	@RequestMapping("/category")
	public ModelAndView category() {

		return new ModelAndView("category","command",new CategoryModel());
	}
	@RequestMapping("/addcategory")
	public ModelAndView addCategory(@ModelAttribute("CategoryModel") CategoryModel cm ) {
	System.out.println("in add category");
       cs.insertCategoryModel(cm);		
		ModelAndView mv=new ModelAndView("category","command",new CategoryModel());
		return mv;
	}
	@RequestMapping("/viewcategory")
	public ModelAndView viewcategories()
	{
		List<CategoryModel> arr=cs.getCategoryList();
		Gson gson=new Gson();
		String json=gson.toJson(arr);
		return new ModelAndView("categorylist","data",gson.toJson(arr));
	}
	@RequestMapping("/supplier")
	public ModelAndView supplier() {

		return new ModelAndView("supplier","command",new SupplierModel());
	}
	@RequestMapping("/addsupplier")
	public ModelAndView addSupplier(@ModelAttribute("SupplierModel") SupplierModel sm ) {
	System.out.println("in add supplier");
       ss.insertSupplierModel(sm);		
		ModelAndView mv=new ModelAndView("supplier","command",new SupplierModel());
		return mv;
	}
	@RequestMapping("/viewsupplier")
	public ModelAndView viewsuppliers()
	{
		List<SupplierModel> arr=ss.getSupplierList();
		Gson gson=new Gson();
		String json=gson.toJson(arr);
		return new ModelAndView("supplierlist","data",gson.toJson(arr));
	}
	@RequestMapping("/product")
	public ModelAndView product() {

		return new ModelAndView("product","command",new ProductModel());
	}
	@RequestMapping("/addproduct")
	public ModelAndView addProduct(@ModelAttribute("ProductModel") ProductModel pm ) {
	System.out.println("in add product");
	    ps.insertProductModel(pm);		
		ModelAndView mv=new ModelAndView("product","command",new ProductModel());
		return mv;
	}
	@RequestMapping("/viewproduct")
	public ModelAndView viewproducts()
	{
		List<ProductModel> arr=ps.getProductList();
		Gson gson=new Gson();
		String json=gson.toJson(arr);
		return new ModelAndView("productlist","data",gson.toJson(arr));
	}
		
		@RequestMapping("/adminhome")
		public ModelAndView adminhome(){
		ModelAndView mv= new ModelAndView("adminhome");
		return mv;
	}
		int a;
		@RequestMapping("/edit/{pid}")
		public ModelAndView edit(@PathVariable("pid")int pid,HttpServletRequest req) 
		 {
			System.out.println("in controller1");
			a=pid;
			System.out.println("in controller2");
			ProductModel p=new ProductModel();			
			System.out.println("in controller3");
			Session s=sf.openSession();
			ProductModel p1=(ProductModel)s.get(ProductModel.class,a);
			System.out.println("haiiiiii");
			System.out.println("p1.getPname()"+p1.getProductname());
			ModelAndView m1 = new ModelAndView("updatepage");
			HttpSession sess=req.getSession();
			sess.setAttribute("data1",p1);
			m1.addObject("command", p1);
			System.out.println(p1.getProductname());
			m1.addObject("data", p1);		 
			return m1;
			}
		
		@RequestMapping("edit/updateproduct")
		public ModelAndView update(@ModelAttribute("toys")ProductModel p) 
		 {
			ps.update(p);
			return new ModelAndView("redirect:/viewproduct");  
		 }	
		
		int c;
		@RequestMapping("/editsupplier/{sid}")
		public ModelAndView editsupplier(@PathVariable("sid")int sid,HttpServletRequest req) 
		 {
			System.out.println("in controller1");
			c=sid;
			System.out.println("in controller2");
			SupplierModel ss=new SupplierModel();			
			System.out.println("in controller3");
			Session s=sf.openSession();
			SupplierModel s1=(SupplierModel)s.get(SupplierModel.class,c);
			System.out.println("haiiiiii");
			System.out.println("s1.getSname()"+s1.getSuppliername());
			ModelAndView m3 = new ModelAndView("updatesupplier");
			HttpSession sess=req.getSession();
			sess.setAttribute("data1",s1);
			m3.addObject("command", s1);
			System.out.println(s1.getSuppliername());
			m3.addObject("data", s1);		 
			return m3;
			}
		
		@RequestMapping("editsupplier/updatesupplier")
		public ModelAndView update(@ModelAttribute("toys")SupplierModel su) 
		 {
			ss.update(su);
			return new ModelAndView("redirect:/viewsupplier");  
		 }	
			

		
	}
		

