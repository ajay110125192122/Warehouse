package com.app.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderMethod;
import com.app.servie.IOrderMethodService;

@RestController
@RequestMapping("/rest/order")
public class OrderMethodRestController {

	@Autowired
	private IOrderMethodService service;



	@RequestMapping("/save")
	public ResponseEntity<?> saveOne(@RequestBody OrderMethod order){
		ResponseEntity<?> re=null;
		if(order!= null) {
			Integer id=service.saveOrderMethod(order);
			re= new ResponseEntity<String> ("Data saved with"+id, HttpStatus.OK);
		}else {
			re	= new ResponseEntity<String> ("Invalid data provided", HttpStatus.BAD_REQUEST);
		}
		return re;
	}



	@RequestMapping("/update")
	public ResponseEntity<?> updateOne(@RequestBody OrderMethod order)
	{
		ResponseEntity<?> re= null;
		OrderMethod id=service.getAllOrderMethods().get(0);	
		if(order.getOid()!=null && id.getOid()==order.getOid()) {
			service.updateOrderMethod(order);
			re= new ResponseEntity<String> ("Data Updated "+id.getOid(), HttpStatus.OK);
		}else {
			re= new ResponseEntity<String>("provided '"+id.getOid()+"'not found", HttpStatus.BAD_REQUEST);
		}
		return re;
	}


	@RequestMapping("/getone/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id)
	{
		OrderMethod Indentity=service.getAllOrderMethods().get(0);
		ResponseEntity<?> re= null;
		if(id!=null && Indentity.getOid()==id) {
			OrderMethod order=service.getOrderMethodById(id);
			re= new ResponseEntity<OrderMethod>(order, HttpStatus.OK);

		}else {
			re= new ResponseEntity<String> (id+"Not found", HttpStatus.BAD_REQUEST);
		}
		return re;
	}




	@RequestMapping("/delete/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable Integer id) {

		Integer orderMethod=service.getAllOrderMethods().get(0).getOid();
		ResponseEntity<?> re= null;
		if(id!=null && orderMethod==id)
		{
			service.deleteOrderMethod(id);
			re= new ResponseEntity<String> ("Data deleted realted With "+id, HttpStatus.OK);
		}else {

			re= new  ResponseEntity<String> ("Data not found With"+id, HttpStatus.BAD_REQUEST);
		}
		return re;
	}


	@RequestMapping("/getall")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> re= null;
		List<OrderMethod> list=service.getAllOrderMethods();
		if(list!= null) {
			re= new ResponseEntity<List<OrderMethod>> (list, HttpStatus.OK);
		}else {
			re= new ResponseEntity<String> ("Data not found In DataBase", HttpStatus.BAD_REQUEST);

		}

		return re;
	}
}