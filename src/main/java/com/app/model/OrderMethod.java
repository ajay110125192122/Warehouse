package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="ordermethtab")
public class OrderMethod {
	@Id
	@Column(name="oid")
	@GeneratedValue
	private Integer oid;
	@Column(name="omode")
	private String orderMode;
	@Column(name="ocode")
	private String orderCode;
	@Column(name="etype")
	private String exeType;
	//for child table
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="orderacpttab",joinColumns=@JoinColumn(name="oid"))
	@OrderColumn(name="data")
	//private List<OrderMethod> orderAccept=new ArrayList<OrderMethod>(0);
	private List<String> orderAccept;
	@Column(name="note")
	private String sDsc;
	public OrderMethod() {
		super();
	}
	public OrderMethod(Integer oid) {
		super();
		this.oid = oid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getExeType() {
		return exeType;
	}
	public void setExeType(String exeType) {
		this.exeType = exeType;
	}
	public List<String> getOrderAccept() {
		return orderAccept;
	}
	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}
	public String getsDsc() {
		return sDsc;
	}
	public void setsDsc(String sDsc) {
		this.sDsc = sDsc;
	}
	@Override
	public String toString() {
		return "OrderMethod [oid=" + oid + ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", exeType="
				+ exeType + ", orderAccept=" + orderAccept + ", sDsc=" + sDsc + "]";
	}
	
	

}