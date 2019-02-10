package com.app.servie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.servie.IUomService;

@Service
public class UomServiceImpl implements IUomService {
	@Autowired
	private IUomDao dao;
	@Transactional
	public Integer saveUom(Uom uo) {
		return dao.saveUom(uo);
	}

	@Transactional
	public void updateUom(Uom uo) {
		dao.updateUom(uo);

	}

	@Transactional
	public void deleteUom(Integer id) {
		dao.deleteUom(id);		
	}

	@Transactional(readOnly=true)
	public Uom getUomById(Integer id) {
		return dao.getUomById(id);
	}

	@Transactional(readOnly=true)
	public List<Uom> getAllUoms() {
		return dao.getAllUoms();
	}

	@Transactional(readOnly=true)
	public List<Object[]> getUomsByCount() {
		return dao.getUomsByCount();
	}



}
