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

import com.app.export.UomExcelExport;
import com.app.export.UomPdfExport;
import com.app.model.Uom;
import com.app.servie.IUomService;
import com.app.util.UomUtil;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private UomUtil util;
	@Autowired
	private ServletContext context;


	//1.showing registration page 
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}



	 //2.insert data into database
	@RequestMapping(value="/insert" , method=RequestMethod.POST)
	public String save(@ModelAttribute Uom uom, ModelMap map)
	{	
		Integer id=service.saveUom(uom);
		map.addAttribute("uom",new Uom());
		String msg="data inserted to UOMTAB with:"+id;
		map.addAttribute("message", msg);
		//map.addAttribute("message", "data inserted into UOMTAB with"+id);
		return "UomRegister";
	}

//3.showing all records
	@RequestMapping("/all")
	public String viewAll(ModelMap map)
	{
		List<Uom> obs=service.getAllUoms();
		map.addAttribute("list", obs);
		//map.addAttribute("uom", new Uom());
		map.addAttribute("message", "Data showing From DB Table");
		return "UomData";

	}

  //4.delete operation
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer eid, ModelMap map)
	{ 	
		service.deleteUom(eid);
		 //reading new data
		List<Uom> obs=service.getAllUoms();
		map.addAttribute("list",obs);
		map.addAttribute("message","data deleted from UOM Table"+eid);
		return "UomData";
	}

	//5. Showing one particular record full details
	@RequestMapping("/viewOne")
	public String viewOne(@RequestParam Integer id,ModelMap map) {
		Uom obj=service.getUomById(id);
		map.addAttribute("list", obj);
		return "UomDataView";
	} 
}

	/*//6. showing edit page
	@RequestMapping("/editOne")
	public String showEdit(@RequestParam Integer id , ModelMap map)
	{
		Uom ut=	service.getUomById(id);
		map.addAttribute("uom", ut);
		return "UomEdit";

	}

	//7. Updating data
	@RequestMapping("/update")
	public String updateOne(@ModelAttribute Uom uom , ModelMap map) {
		service.updateUom(uom);
		map.addAttribute("message","Uom updated" );
		List<Uom> ls=service.getAllUoms();
		map.addAttribute("list", ls);
		//map.addAttribute("list", service.getAllUoms());

		return "UomData";

	}
	//.8 exporting alal data to excel
	@RequestMapping("/exportToExcelAll")
	public ModelAndView doexportAll() {
		List<Uom> uom=	service.getAllUoms();
		return new ModelAndView(new UomExcelExport(), "list", uom); 
	}

	//9. export one row to excel
	@RequestMapping("/exportExcelOne")
	public ModelAndView doexportOne(@RequestParam Integer id) {
		Uom uomd =service.getUomById(id);
		return new ModelAndView( new UomExcelExport(), "list" , Arrays.asList(uomd)); 

	}

	//10. Export Data to PDF
	@RequestMapping("/exportToPdfAll")
	public ModelAndView exportPdfData() {
		List<Uom> list=service.getAllUoms();
		return new ModelAndView(new UomPdfExport(),"list",list);
	}


	@RequestMapping("/exportPdfOne")
	public ModelAndView doOnePdfExport(@RequestParam Integer id) {
		//reading data from DB
		Uom st=service.getUomById(id);
		//view, key,value
		return new ModelAndView(new UomPdfExport(),"list",Arrays.asList(st) );
	}
	@RequestMapping("/piereport")
	public String generatePieReport(){
		String path=context.getRealPath("/");
		List<Object[]> list=service.getUomsByCount();
		util.generatePieChart(path, list);
		return "UomReports";

	}

}
*/