package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	@Autowired
	private HibernateTemplate ht;

	public Integer saveOrderMethod(OrderMethod omd) {
		return (Integer)ht.save(omd);
	}

	public void updateOrderMethod(OrderMethod omd) {
		ht.update(omd);
	}

	public void deleteOrderMethod(Integer oid) {
		ht.delete(new OrderMethod(oid));		
	}


	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}

	public OrderMethod getOrderMethodById(Integer oid) {
		return ht.get(OrderMethod.class, oid);
	}

	public List<Object[]> getOrderModetypeCount() {
		String hql=" select orderMode, count(orderMode) from "+OrderMethod.class.getName()+" group by orderMode ";
		return (List<Object[]>) ht.find(hql);
	}

}
