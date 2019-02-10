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

import com.app.export.ShipmentTypeExcelExport;
import com.app.export.ShipmentTypePdfExport;
import com.app.model.ShipmentType;
import com.app.servie.IShipmentTypeService;
import com.app.util.ShipmentTypeUtil;
@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ShipmentTypeUtil util;
	@Autowired
	private ServletContext context;

	//1 show register page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		//extra code - creating and adding new object to ModelMap
		map.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";

	}
	//2 insert data to database
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String save(@ModelAttribute ShipmentType shipmentType, ModelMap map) {

		// calling save method of Service layer

		int id= service.saveShipmentType(shipmentType);
		String msg="data saved using id:"+id;
		map.addAttribute("message", msg);
		//extra code - clean and returning new object
		map.addAttribute("shipmentType" , new ShipmentType() );
		return "ShipmentTypeRegister";
	}

	//3. view all records
	@RequestMapping("/all")
	public String viewAll( ModelMap map)
	{

		List<ShipmentType> obj =service.getAllShipmentTypes();
		map.addAttribute("list", obj);
		map.addAttribute("message", "Data showing from DataBase");
		return "ShipmentTypeData";

	}

	//4. delete operation
	@RequestMapping("/delete")
	public String delete(@RequestParam int sid, ModelMap map) {

		service.deleteShipmentType(sid);
		// read new data
		List<ShipmentType> obj=service.getAllShipmentTypes();
		map.addAttribute("list", obj);
		map.addAttribute("message", "Data deleted using :"+sid);

		return "ShipmentTypeData";
	}

	//5. view one record
	@RequestMapping("/viewOne")
	public String view(@RequestParam int sid, ModelMap map)
	{
		ShipmentType obj=service.getShipmentTypeById(sid);
		map.addAttribute("st", obj);

		return "ShipmentTypeDataView";
	}

	//6. showing edit page with data
	@RequestMapping("/editOne")
	public String editOne(@RequestParam Integer sid, ModelMap map) {
		ShipmentType st= service.getShipmentTypeById(sid);		
		map.addAttribute("shipmentType", st);
		return "ShipmentEdit";
	}

	//7. updating data
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public String update(@ModelAttribute ShipmentType shipmentType, ModelMap map) {
		service.updateShipmentType(shipmentType);
		map.addAttribute("message", "ShipmentUpdated");

		List<ShipmentType> list=	service.getAllShipmentTypes();
		map.addAttribute("list",list );
		return "ShipmentTypeData";

	}


	//7. exporting all data to export 
	@RequestMapping("/exportToExcelAll")
	public ModelAndView doExpoertAll() {

		List<ShipmentType> list= service.getAllShipmentTypes();
		//creating shipmentTypeExcelExport class object and adding to modelAndView 
		return new ModelAndView(new ShipmentTypeExcelExport(), "list", list);
	}

	//8. exporting one row data to excel
	@RequestMapping("/exportExcelOne")
	public ModelAndView doExportExcelOne(@RequestParam Integer sid) {
		//reading data from data base 
		ShipmentType st= service.getShipmentTypeById(sid);


		return  new ModelAndView(new ShipmentTypeExcelExport(), "list", Arrays.asList(st));

	}


	//10. Export Data to PDF
	@RequestMapping("/exportToPdfAll")
	public ModelAndView exportPdfData() {
		List<ShipmentType> list=service.getAllShipmentTypes();
		return new ModelAndView(new ShipmentTypePdfExport(),"list",list);
	}


	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer sid) {
		//reading data from DB
		ShipmentType st=service.getShipmentTypeById(sid);
		//view, key,value
		return new ModelAndView(new ShipmentTypePdfExport(),"list",Arrays.asList(st) );
	}



	@RequestMapping("/piereport")	
	public String generatePieChart() 
	{
		String path=context.getRealPath("/");
		List<Object[]> data=service.getShipmentTypesByCount();	
		util.generatePieChart(path, data);
		util.generateBarCharts(path, data);
		return "ShipmentTypesReports";
	}
}



