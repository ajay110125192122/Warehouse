package com.app.servie;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodService {
	public Integer saveOrderMethod(OrderMethod omd);
	public void updateOrderMethod(OrderMethod omd);
	public void deleteOrderMethod(Integer oid);
	public OrderMethod getOrderMethodById(Integer oid);
	public List<OrderMethod> getAllOrderMethods();
	public List<Object[]> getOrderModetypeCount();
}
