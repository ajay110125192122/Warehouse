package com.app.servie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.servie.IOrderMethodService;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService{
	@Autowired
	private IOrderMethodDao dao;

	@Transactional
	public Integer saveOrderMethod(OrderMethod omd) {
		return dao.saveOrderMethod(omd);
	}

	@Transactional
	public void updateOrderMethod(OrderMethod omd) {
		dao.updateOrderMethod(omd);		
	}

	@Transactional
	public void deleteOrderMethod(Integer oid) {
		dao.deleteOrderMethod(oid);		
	}


	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrderMethods() {
		return dao.getAllOrderMethods();
	}
	@Transactional(readOnly=true)
	public OrderMethod getOrderMethodById(Integer oid) {
		return dao.getOrderMethodById(oid);
	}

	@Transactional(readOnly=true)
	public List<Object[]> getOrderModetypeCount() {
		return dao.getOrderModetypeCount();
	}


}
