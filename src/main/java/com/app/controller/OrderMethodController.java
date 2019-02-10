package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.export.OrderMethodExcelExport;
import com.app.export.OrderMethodPdfExport;
import com.app.model.OrderMethod;
import com.app.servie.IOrderMethodService;
import com.app.util.OrderMethodUtil;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private OrderMethodUtil util;


	//1showing register page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	//2. save operation
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveA(@ModelAttribute OrderMethod orderMethod,ModelMap map) {

		Integer id=service.saveOrderMethod(orderMethod);
		map.addAttribute("message",+id);
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	//3.showing all records from database
	@RequestMapping("/all")
	public String showAll(ModelMap map)
	{
		List<OrderMethod> obs=service.getAllOrderMethods();
		map.addAttribute("list", obs);
		map.addAttribute("message", "data shoing from DB");
		return "OrderMethodData";
	}
	//4. delete operation
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id , ModelMap map)

	{
		service.deleteOrderMethod(id);
		map.addAttribute("message", "Data Deleted with"+id);
		List<OrderMethod> lt= service.getAllOrderMethods();
		map.addAttribute("list", lt);
		return "OrderMethodData";	
	}
	//5.showing one record
	@RequestMapping("/viewOne")
	public String viewOne(@RequestParam Integer id , ModelMap map) {
		OrderMethod od=	service.getOrderMethodById(id);
		map.addAttribute("od", od);

		return "OrderMethodDataView";

	}
	//6. showing Edit Page
	@RequestMapping("/editOne")
	public String editOne(@RequestParam Integer id , ModelMap map)
	{ 
		OrderMethod omd=service.getOrderMethodById(id);
		map.addAttribute("orderMethod", omd);
		return "OrderMethodEdit";
	}
	//7.update data in DB
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public String update(@ModelAttribute OrderMethod orderMethod, ModelMap map) {
		service.updateOrderMethod(orderMethod);		
		map.addAttribute("message", "ShipmentUpdated");

		List<OrderMethod> list=	service.getAllOrderMethods();
		map.addAttribute("list",list );
		return "OrderMethodData";

	}

	//8. exporting all data of database to excel
	@RequestMapping("/exportToExcelAll")
	public ModelAndView doExportAll()
	{
		//ModelAndView mob=new ModelAndView();
		//mob.addObject(new OrderMethod());
		//mob.addObject("list",om);

		List<OrderMethod> om= service.getAllOrderMethods();
		return new ModelAndView(new OrderMethodExcelExport(), "list", om);
	}
	//9. exporting one row to excel
	@RequestMapping("/exportExcelOne")
	public ModelAndView exportOne(@RequestParam Integer id) {

		OrderMethod omd=service.getOrderMethodById(id);
		return new ModelAndView(new OrderMethodExcelExport(), "list", Arrays.asList(omd));

	}
	//10. Export Data to PDF
	@RequestMapping("/exportToPdfAll")
	public ModelAndView exportPdfData() {
		List<OrderMethod> list=service.getAllOrderMethods();
		return new ModelAndView(new OrderMethodPdfExport(),"list",list);
	}


	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer id) {
		//reading data from DB
		OrderMethod st=service.getOrderMethodById(id);
		//view, key,value
		return new ModelAndView(new OrderMethodPdfExport(),"list",Arrays.asList(st) );

	}
	// methods to report generation
	@RequestMapping("/piereport")
	public String generatePieCharts() {
		String path=context.getRealPath("/");
		List<Object[]> data=service.getOrderModetypeCount();
		util.generatePieChart(path, data);
		util.generateBar(path, data);
		return "OrderMethodReports";

	}
}