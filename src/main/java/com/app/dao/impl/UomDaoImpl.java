package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl  implements IUomDao{
	@Autowired
	private HibernateTemplate ht;
	public Integer saveUom(Uom uo) {
		return	(Integer) ht.save(uo);

	}

	public void updateUom(Uom uo) {
		ht.update(uo);		
	}

	public void deleteUom(Integer id) {
		ht.delete(new Uom(id));
	}

	public Uom getUomById(Integer id) {
		return ht.get(Uom.class, id);
	}

	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}

	public List<Object[]> getUomsByCount() {
		String hql= " select uomType ,count(uomType) from "+ Uom.class.getName() + " group by uomType ";

		return (List<Object[]>) ht.find(hql);
	}


}
