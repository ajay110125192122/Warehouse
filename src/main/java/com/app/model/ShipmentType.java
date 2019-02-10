package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lowagie.text.pdf.PdfPCell;

@Entity
@Table(name="shipment_type_tab")
public class ShipmentType {
	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer sid;
	@Column(name="smode")
	private String shipmentMode;
	@Column(name="scode")
	private String shipmentCode;
	@Column(name="senbl")
	private String enbleShipment;
	@Column(name="sgrd")
	private String shipmentGrade;
	@Column(name="sdece")
	private String sdec;
	public ShipmentType() {
		super();
	}
	public ShipmentType(Integer sid) {
		super();
		this.sid = sid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getShipmentMode() {
		return shipmentMode;
	}
	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}
	public String getShipmentCode() {
		return shipmentCode;
	}
	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
	public String getEnbleShipment() {
		return enbleShipment;
	}
	public void setEnbleShipment(String enbleShipment) {
		this.enbleShipment = enbleShipment;
	}
	public String getShipmentGrade() {
		return shipmentGrade;
	}
	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}
	public String getSdec() {
		return sdec;
	}
	public void setSdec(String sdec) {
		this.sdec = sdec;
	}
	@Override
	public String toString() {
		return "ShipmentType [sid=" + sid + ", shipmentMode=" + shipmentMode + ", shipmentCode=" + shipmentCode
				+ ", enbleShipment=" + enbleShipment + ", shipmentGrade=" + shipmentGrade + ", sdec=" + sdec + "]";

	}


}