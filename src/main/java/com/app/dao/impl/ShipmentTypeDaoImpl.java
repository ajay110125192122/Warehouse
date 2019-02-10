package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl  implements IShipmentTypeDao{
@Autowired
	private HibernateTemplate ht;

	
	public Integer saveShipmentType(ShipmentType st) {
		return (Integer) ht.save(st);
	}

	public void updateShipmentType(ShipmentType st) {
		ht.update(st);
		
	}

	public void deleteShipmentType(Integer id) {
		ht.delete(new ShipmentType(id));
		}

	public ShipmentType getShipmentTypeById(Integer id ) {
		return ht.get(ShipmentType.class, id);
	}

	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}

	public List<Object[]> getShipmentTypesByCount() {
		String hql=" select shipmentMode ,count(shipmentMode) from "+ ShipmentType.class.getName() + " group by shipmentMode ";
		return (List<Object[]>) ht.find(hql);
	}

}
