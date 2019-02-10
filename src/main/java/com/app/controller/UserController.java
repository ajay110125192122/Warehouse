package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.export.ShipmentTypePdfExport;
import com.app.export.UomExcelExport;
import com.app.export.UserExcelExport;
import com.app.export.UserPdfExport;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.model.User;
import com.app.servie.IUserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;
	
	
	
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("user", new User());
		return "UserRegister";
	}


	//2.insert data into database
	@RequestMapping(value="/insert" , method=RequestMethod.POST)
	public String save(@ModelAttribute User user, ModelMap map)
	{	
		Integer id=service.saveUser(user);
		map.addAttribute("user",new User());
		//String msg="data inserted to USERTAB with"+""+id;
		//map.addAttribute("message", msg);
		map.addAttribute("message", "data inserted into USER with"+id);
		return "UserRegister";
	}
	

	//3.showing all records
	@RequestMapping("/all")
	public String viewAll(ModelMap map)
	{
		List<User> obs=service.getAllUsers();
		map.addAttribute("list", obs);
		map.addAttribute("user", new User());
		map.addAttribute("message", "Data showing From DB Table");
		return "UserData";

	}

	//4.delete operation
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id, ModelMap map)
	{ 	
		service.deleteUser(id);		//reading new data
		List<User> obs=service.getAllUsers();
		map.addAttribute("list",obs);
		map.addAttribute("message","data deleted from USER Table"+id);
		return "UserData";
	}

	//5. Showing one particular record full details
	@RequestMapping("/viewOne")
	public String viewOne(@RequestParam Integer id,ModelMap map) {
		User obj= service.getUserById(id);
		map.addAttribute("list", obj);
		return "UserDataView";
	} 

	//6. showing edit page
	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer id , ModelMap map)
	{
		User ut=service.getUserById(id);
		
		map.addAttribute("user", ut);
		return "UserDataEdit";

	}

	//7. Updating data
	@RequestMapping("/update")
	public String updateOne(@ModelAttribute User user , ModelMap map) {
		service.updateUser(user);;
		map.addAttribute("message","User updated" );
		List<User> list=service.getAllUsers();
		map.addAttribute("list", list);
		//map.addAttribute("list", service.getAllUsers());

		return "UserData";
	
	}
	//.8 exporting all data to excel
	@RequestMapping("/exportToExcelAll")
	public ModelAndView doexportAll() {
		List<User> user=service.getAllUsers();
		return new ModelAndView(new UserExcelExport(), "list",user); 
	}

//9. export one row to excel
	@RequestMapping("/exportExcelOne")
	public ModelAndView doexportOne(@RequestParam Integer id) {
		User user =service.getUserById(id);
		return new ModelAndView( new UserExcelExport(), "list" , Arrays.asList(user)); 
		
		
	}
	//10. Export Data to PDF
			@RequestMapping("/exportToPdfAll")
			public ModelAndView exportPdfData() {
				List<User> list=service.getAllUsers();
				return new ModelAndView(new UserPdfExport(),"list",list);
			}
			
			
			@RequestMapping("/exportPdfOne")
			public ModelAndView doOnePdfExport(@RequestParam Integer id) {
				//reading data from DB
				User st=service.getUserById(id);
				//view, key,value
				return new ModelAndView(new UserPdfExport(),"list",Arrays.asList(st) );
			}

}
