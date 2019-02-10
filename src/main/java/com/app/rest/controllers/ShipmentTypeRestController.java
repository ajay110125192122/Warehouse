package com.app.rest.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ShipmentType;
import com.app.servie.IShipmentTypeService;
@RestController
@RequestMapping("/rest/shipment")
public class ShipmentTypeRestController {

	@Autowired	
	private IShipmentTypeService service;

	@GetMapping("/getOne")
	public ResponseEntity<?> showOne(@RequestParam Integer id) {
		ResponseEntity<?> re= null;
		ShipmentType shipment=service.getShipmentTypeById(id);

		if (shipment==null || equals(null)) {
			re= new ResponseEntity<String> ("no data found", HttpStatus.BAD_REQUEST);
		}else {
			re= new ResponseEntity<ShipmentType> (shipment ,HttpStatus.OK);
		}
		return re;
	}



	@RequestMapping("/getAll")
	public ResponseEntity<?> getAll()
	{ 
		ResponseEntity<?> re= null;
		List<ShipmentType> list=service.getAllShipmentTypes();
		if(list==null || equals(null)) {
			re= new ResponseEntity<String> ("No Data Found",HttpStatus.BAD_REQUEST);
		}else {
			re= new ResponseEntity<List<ShipmentType>> (list, HttpStatus.OK);
		}
		return re;
	}

	@DeleteMapping("/removeOne/{id}") //|| @DeleteMapping
	public ResponseEntity<?> removeOne(@PathParam(value = "id") Integer id){

		ResponseEntity<?> re=null;
		if(id!=null) {

			service.deleteShipmentType(id);
			re=new ResponseEntity<String> ("Data"+id+"removed",HttpStatus.OK);
		} else {
			re=new ResponseEntity<String> ("Invalid data", HttpStatus.BAD_REQUEST);
		}	
		return re;
	}
	@RequestMapping("/save")
	public ResponseEntity<?> saveOne(@RequestBody ShipmentType shipment){

		ResponseEntity<?> re= null;
		if(shipment!=null) {
			int id=service.saveShipmentType(shipment);
			re=new ResponseEntity<String>("DATA SAVED WITH'"+id+"'INTO DATABASE", HttpStatus.OK); 
		}else {
			re= new ResponseEntity<String> ("Provided details are invalid ", HttpStatus.BAD_REQUEST);
		}

		return re;
	}
	@PutMapping("/update")
	public ResponseEntity<?> update( @RequestBody ShipmentType shipment){
		ResponseEntity<?> re=null;

		int id=service.getAllShipmentTypes().get(0).getSid();
		try {

			if(shipment.getSid() != null && shipment.getSid()==id ) {

				service.updateShipmentType(shipment);
				re= new ResponseEntity<String> ("Shipment Data Updated", HttpStatus.OK);

			}else  {
				if(shipment.getSid()!=id && shipment.getSid() != null) {
					Integer data = service.saveShipmentType(shipment);
					re= new ResponseEntity<String>("new data saved with"+data, HttpStatus.OK);
				}
				/*else if(shipment.getSid()==null){
				re= new ResponseEntity<String> ("DATA NOT FOUND", HttpStatus.BAD_REQUEST);
		}*/

			}
		}
		catch (Exception e) {
			if(shipment.getSid()==null){
				re= new ResponseEntity<String> ("DATA NOT FOUND", HttpStatus.BAD_REQUEST);
			}
		}
		return re;
	}
}














