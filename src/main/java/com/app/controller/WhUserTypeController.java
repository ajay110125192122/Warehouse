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

import com.app.export.WhUserTypeExcelExport;
import com.app.export.WhUserTypePdfExport;
import com.app.model.WhUserType;
import com.app.servie.IWhUserTypeService;
import com.app.util.WhUserTypeUtil;
@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private WhUserTypeUtil util;
	@Autowired
	private ServletContext context;

	@RequestMapping("/register")
	public String showReg(ModelMap map) 
	{

		map.addAttribute("whUserType",new WhUserType() );
		return "WhUserTypeRegister";
	}
	@RequestMapping("/insert")
	public String save(@ModelAttribute WhUserType whUserType , ModelMap map) {
		Integer id=	service.saveWhUserType(whUserType);
		map.addAttribute("whUserType", new WhUserType());
		map.addAttribute("message" ,"DATA inserted into DB with "+id);
		return "WhUserTypeRegister";	

	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<WhUserType> list=service.getAllWhUserTypes();
		map.addAttribute("list",list );
		map.addAttribute("message","Data Showing from DataBase");
		return "WhUserTypeData";
	}

	@RequestMapping("/deleteOne")
	public String deleteOne(@RequestParam Integer id , ModelMap map) {

		service.deleteWhUserType(id);
		map.addAttribute("message", "data deleted with id="+id);

		List<WhUserType> list=service.getAllWhUserTypes();
		map.addAttribute("list", list);
		return "WhUserTypeData";
	}


	@RequestMapping("/viewOne")
	public String viewOne(@RequestParam Integer id , ModelMap map) {
		WhUserType wh=service.getWhUserTypeById(id);
		map.addAttribute("wt", wh);
		map.addAttribute("message", "Full Data of"+id);
		return "WhUserTypeDataView";
	}
	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer id, ModelMap map) {
		WhUserType whUserType=	service.getWhUserTypeById(id);
		map.addAttribute("whUserType", whUserType);	
		//map.addAttribute("whUserType",new WhUserType());
		return "WhUserTypeDataEdit";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateOne(@ModelAttribute WhUserType whUserType , ModelMap map) {
		service.updateWhUserType(whUserType);
		map.addAttribute("message", "WhUserType Updated With");

		List<WhUserType> list= service.getAllWhUserTypes();
		map.addAttribute("list",list );
		return "WhUserTypeData";
	}


	@RequestMapping("/exportToExcelAll")
	public ModelAndView doExportAll()
	{
		//ModelAndView mob=new ModelAndView();
		//mob.addObject(new OrderMethod());
		//mob.addObject("list",om);

		List<WhUserType> om= service.getAllWhUserTypes();
		return new ModelAndView(new WhUserTypeExcelExport(), "list", om);
	}

	@RequestMapping("/exportExcelOne")
	public ModelAndView exportOne(@RequestParam Integer id) {

		WhUserType wh=	service.getWhUserTypeById(id);
		return new ModelAndView(new WhUserTypeExcelExport(), "list", Arrays.asList(wh));

	}
	//10. Export Data to PDF
	@RequestMapping("/exportToPdfAll")
	public ModelAndView exportPdfData() {
		List<WhUserType> list=service.getAllWhUserTypes();
		return new ModelAndView(new WhUserTypePdfExport(),"list",list);
	}


	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer id) {
		//reading data from DB
		WhUserType st=service.getWhUserTypeById(id);
		//view, key,value
		return new ModelAndView(new WhUserTypePdfExport(),"list",Arrays.asList(st) );
	}
	@RequestMapping("/piereport")
	public String generatePieReporgt()
	{ //String path="/";
		//context.getRealPath(path);
		String path=context.getRealPath("/");
  List<Object[]> list=service.getWhUsersByCount();
  util.generatePieChart(path, list);
		return "WhuserReports";
	}
}
