package com.app.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.WhUserType;
import com.app.servie.IWhUserTypeService;

public class WhUserRestConrtroller {

	@Autowired
	private IWhUserTypeService service;




	@RequestMapping("/save")
	public ResponseEntity<?> saveOne(@RequestBody WhUserType whuser){
		ResponseEntity<?> re=null;
		if(whuser!= null) {
			Integer id=service.getAllWhUserTypes().get(0).getUid();
			re= new ResponseEntity<String> ("Data saved with"+id, HttpStatus.OK);
		}else {
			re	= new ResponseEntity<String> ("Invalid data provided", HttpStatus.BAD_REQUEST);
		}
		return re;
	}



	@RequestMapping("/update")
	public ResponseEntity<?> updateOne(@RequestBody WhUserType whuser)
	{
		ResponseEntity<?> re= null;
		Integer id=service.getAllWhUserTypes().get(0).getUid();	
		if(id!=null && id==whuser.getUid()) {
			service.updateWhUserType(whuser);;
			re= new ResponseEntity<String> ("Data Updated "+id, HttpStatus.OK);
		}else {
			re= new ResponseEntity<String>("provided '"+id+"'not found", HttpStatus.BAD_REQUEST);
		}
		return re;
	}


	@RequestMapping("/getone/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id)
	{
		Integer Indentity=service.getWhUserTypeById(id).getUid();
		ResponseEntity<?> re= null;
		if(id!=null && Indentity==id) {
			WhUserType order=service.getWhUserTypeById(id);
			re= new ResponseEntity<WhUserType>(order, HttpStatus.OK);

		}else {
			re= new ResponseEntity<String> (id+"Not found", HttpStatus.BAD_REQUEST);
		}
		return re;
	}




	@RequestMapping("/delete/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable Integer id) {

		Integer Identity=service.getAllWhUserTypes().get(0).getUid();
		ResponseEntity<?> re= null;
		if(id!=null && Identity==id)
		{
			service.deleteWhUserType(id);;
			re= new ResponseEntity<String> ("Data deleted realted With "+id, HttpStatus.OK);
		}else {

			re= new  ResponseEntity<String> ("Data not found With"+id, HttpStatus.BAD_REQUEST);
		}
		return re;
	}


	@RequestMapping("/getall")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> re= null;
		List<WhUserType> list=service.getAllWhUserTypes();
		if(list!= null) {
			re= new ResponseEntity<List<WhUserType>> (list, HttpStatus.OK);
		}else {
			re= new ResponseEntity<String> ("Data not found In DataBase", HttpStatus.BAD_REQUEST);

		}

		return re;
	}
}
