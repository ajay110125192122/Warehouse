package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whuser_tab")
public class WhUserType {
	
	
	@Id
	@Column(name="wh_uid")
	@GeneratedValue
	private Integer uid;
	@Column(name="wh_type")
	private String userType;
	@Column(name="wh_code")
	private String userCode;
	@Column(name="wh_user_for")
	private String userFor;
	@Column(name="wh_mail")
	private String userMail;
	@Column(name="contact")
	private String userContact;
	@Column(name="id_type")
	private String userIdType;
	@Column(name="others")
	private String otherType;
	@Column(name="id_number")
	private String idNumber;
	
	public WhUserType() {
		super();
	}

	public WhUserType(Integer uid) {
		super();
		this.uid = uid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public String getOtherType() {
		return otherType;
	}

	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "WhUserType [uid=" + uid + ", userType=" + userType + ", userCode=" + userCode + ", userFor=" + userFor
				+ ", userMail=" + userMail + ", userContact=" + userContact + ", userIdType=" + userIdType
				+ ", otherType=" + otherType + ", idNumber=" + idNumber + "]";
	}

	

}
