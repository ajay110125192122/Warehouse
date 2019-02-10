package com.app.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Uom;
import com.app.servie.IUomService;

@RequestMapping("/rest/uom")
@RestController
public class UomRestController {

	@Autowired
	private IUomService service;


	/*@RequestMapping("/getone")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> re= null;

		Integer identity=service.getAllUoms().get(0).getId();

		if(id!=null && identity==id) {
			Uom uom=service.getUomById(id);
			re= new ResponseEntity<Uom>(uom, HttpStatus.OK);
		}else {
			re= new ResponseEntity<String> ("Data with id"+id+"not found", HttpStatus.BAD_REQUEST);
		}


		return re;
	}*/



	@RequestMapping("/save")
	public ResponseEntity<?> saveOne(@RequestBody Uom uom){
		ResponseEntity<?> re=null;
		if(uom!= null) {
			Integer id=service.saveUom(uom);
			re= new ResponseEntity<String> ("Data saved with"+id, HttpStatus.OK);
		}else {
			re	= new ResponseEntity<String> ("Invalid data provided", HttpStatus.BAD_REQUEST);
		}
		return re;
	}



	@RequestMapping("/update")
	public ResponseEntity<?> updateOne(@RequestBody Uom uom)
	{
		ResponseEntity<?> re= null;
		Integer id=service.getAllUoms().get(0).getId();	
		if(uom.getId()!=null && id==uom.getId()) {
			service.getUomById(id);
			re= new ResponseEntity<String> ("Data Updated "+id, HttpStatus.OK);
		}else {
			re= new ResponseEntity<String>("provided '"+id+"'not found", HttpStatus.BAD_REQUEST);
		}
		return re;
	}


	@RequestMapping("/getone/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id)
	{
		Uom Indentity=service.getAllUoms().get(0);
		ResponseEntity<?> re= null;
		if(id!=null && Indentity.getId()==id) {

			Uom uom=service.getUomById(id);
			re= new ResponseEntity<Uom>(uom, HttpStatus.OK);

		}else {
			re= new ResponseEntity<String> (id+"Not found", HttpStatus.BAD_REQUEST);
		}
		return re;
	}




	@RequestMapping("/delete/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable Integer id) {

		Integer orderMethod=service.getAllUoms().get(0).getId();
		ResponseEntity<?> re= null;
		if(id!=null && orderMethod==id)
		{
			service.deleteUom(id);
			re= new ResponseEntity<String> ("Data deleted realted With "+id, HttpStatus.OK);
		}else {

			re= new  ResponseEntity<String> ("Data not found With"+id, HttpStatus.BAD_REQUEST);
		}
		return re;
	}


	@RequestMapping("/getall")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> re= null;
		List<Uom> list=service.getAllUoms();
		if(list!= null) {
			re= new ResponseEntity<List<Uom>> (list, HttpStatus.OK);
		}else {
			re= new ResponseEntity<String> ("Data not found In DataBase", HttpStatus.BAD_REQUEST);

		}

		return re;
	}


}
