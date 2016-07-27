package com.niit.bikes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.bikes.dao.UserDAO;
import com.niit.bikes.dao.UserDAOimpl;
import com.niit.bikes.model.CategoryModel;
import com.niit.bikes.model.ProductModel;
import com.niit.bikes.model.SignupModel;
import com.niit.bikes.model.SupplierModel;
import com.niit.bikes.model.UserDetails;
import com.niit.bikes.services.CategoryService;
import com.niit.bikes.services.ProductService;

import com.niit.bikes.services.SupplierService;
import com.niit.bikes.services.UserService;

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
	SessionFactory sf;
	@Autowired
	  SessionFactory sessionFactory;
	@RequestMapping("/")
	public ModelAndView getHomePage() {	
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	@RequestMapping("/index")
	public ModelAndView getindexPage() {	
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView getLoginPage() {	
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
	@RequestMapping("/signup")
	public ModelAndView getSignupPage() {	
		return new ModelAndView("signup","command",new SignupModel());
	}
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer(@ModelAttribute("SignupModel") SignupModel sm ) {
	System.out.println("in add customer");
        us.insertSignupModel(sm);
		
		ModelAndView mv=new ModelAndView("signup","command",new SignupModel());
		return mv;
	}
	
	@RequestMapping("/adminhome")
	public ModelAndView getAdminPage() {	
		ModelAndView mv=new ModelAndView("adminhome");
		return mv;
	}

	@RequestMapping("/categories")
	public ModelAndView category() {

		return new ModelAndView("category","command",new CategoryModel());
	}
	
	@RequestMapping("/addcategory")
	public ModelAndView addCategory(@ModelAttribute("CategoryModel") CategoryModel cm ) {
	System.out.println("in add product");
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
	@RequestMapping("/usercategory")
	public ModelAndView usercategories()
	{
		List<CategoryModel> arr=cs.getCategoryList();
		Gson gson=new Gson();
		String json=gson.toJson(arr);
		return new ModelAndView("usercategory","data",gson.toJson(arr));
	}
	//product crud
	@RequestMapping("/Products")
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
	@RequestMapping("/guest")
	public ModelAndView guestproducts()
	{
		List<ProductModel> arr=ps.getProductList();
		Gson gson=new Gson();
		String json=gson.toJson(arr);
		return new ModelAndView("guestproduct","data",gson.toJson(arr));
	}
	@RequestMapping("/userproduct")
	public ModelAndView userproducts()
	{
		List<ProductModel> arr=ps.getProductList();
		Gson gson=new Gson();
		String json=gson.toJson(arr);
		return new ModelAndView("userproduct","data",gson.toJson(arr));
	}
	@RequestMapping("/suppliers")
	public ModelAndView supplier() {

		return new ModelAndView("supplier","command",new SupplierModel());
	}
	@RequestMapping("/addsupplier")
	public ModelAndView addsupplier(@ModelAttribute("SupplierModel") SupplierModel sm ) {
	System.out.println("in add product");
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
	@RequestMapping("/usersupplier")
	public ModelAndView usersuppliers()
	{
		List<SupplierModel> arr=ss.getSupplierList();
		Gson gson=new Gson();
		String json=gson.toJson(arr);
		return new ModelAndView("usersupplier","data",gson.toJson(arr));
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
	public ModelAndView update(@ModelAttribute("bikes")ProductModel p) 
	 {
		ps.update(p);
		return new ModelAndView("redirect:/viewproduct");  
	 }
	@RequestMapping("/delproduct1/{productid}")
	 public ModelAndView deleteproduct(@PathVariable("productid")int id) 
	 {
		System.out.println("in delete");
		ps.remove(id);
		return new ModelAndView("redirect:/viewproduct");  
	 }
	
	int c;
	@RequestMapping("/editsupplier/{sid}")
	public ModelAndView editsupplier(@PathVariable("sid")int sid,HttpServletRequest req) 
	 {
		System.out.println("in controller1");
		c=sid;
		System.out.println("in controller2");
		SupplierModel k=new SupplierModel();			
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
	public ModelAndView update(@ModelAttribute("bikes")SupplierModel k) 
	 {
		System.out.println("***************updateSupplier");
		ss.update(k);
		return new ModelAndView("redirect:/viewsupplier");  
	 }	

@RequestMapping("/delsupplier1/{supplierid}")
 public ModelAndView deletesupplier(@PathVariable("supplierid")int id) 
 {
	System.out.println("in delete");
	ss.remove(id);
	return new ModelAndView("redirect:/viewsupplier");  
 }
	int b;
	@RequestMapping("/editcategory/{cid}")
	public ModelAndView editcategory(@PathVariable("cid")int sid,HttpServletRequest req) 
	 {
		System.out.println("in controller1");
		c=sid;
		System.out.println("in controller2");
		CategoryModel l=new CategoryModel();			
		System.out.println("in controller3");
		Session s=sf.openSession();
		CategoryModel c1=(CategoryModel)s.get(CategoryModel.class,c);
		System.out.println("haiiiiii");
		System.out.println("s1.getSname()"+c1.getCategoryname());
		ModelAndView m2 = new ModelAndView("updatecategory");
		HttpSession sess=req.getSession();
		sess.setAttribute("data1",c1);
		m2.addObject("command", c1);
		System.out.println(c1.getCategoryname());
		m2.addObject("data", c1);		 
		return m2;
		}
	@RequestMapping("editcategory/updatecategory")
	public ModelAndView update(@ModelAttribute("bikes")CategoryModel l) 
	 {
		System.out.println("***************updateCategory");
		cs.update(l);
		return new ModelAndView("redirect:/viewcategory");  
	 }	

@RequestMapping("/delcategory1/{categoryid}")
 public ModelAndView deletecategory(@PathVariable("categoryid")int id) 
 {
	System.out.println("in delete");
	cs.remove(id);
	return new ModelAndView("redirect:/viewcategory");  
 }
	
	//validation
	@RequestMapping("/logincheck") // from login.jsp
	public ModelAndView logincheck(@RequestParam(value="username")String username,@RequestParam(value="pwd")String pwd) {
		System.out.println("\nMyContoller - logincheck");
		ModelAndView mv;
		System.out.println("\nMyContoller - /loginCheck - before session factory");
		UserDAO ud = new UserDAOimpl(sessionFactory);
		System.out.println("\nMyContoller - /loginCheck - after session factory");
		String p=pwd;
		if(ud.isValidUser(username,pwd)==true && ud.isAdminUser(username,p)==true ) {
			System.out.println("login ok");
			mv=new ModelAndView("loginsuccadmin");
		}
		else if(ud.isValidUser(username,pwd)==true) {
			System.out.println("login ok");
			mv=new ModelAndView("loginsuccesuser");
		}
		else {
			System.out.println("login not ok");			
			mv=new ModelAndView("loginerror");
		}
		return mv;	
	
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		
		
		model.addAttribute("user", getPrincipal());
		return "dba";
	}
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
    @RequestParam(value = "logout", required = false) String logout) {
         
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid Credentials provided.");
        }
 
        if (logout != null) {
            model.addObject("message", "Logged out from application successfully.");
        }
 
        model.setViewName("login");
        return model;
    }
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUserName();
		} else {
			userName = principal.toString();
		}
		return userName;
	}


}
