package com.app.model;

import java.util.Set;

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
@Table(name="Usr_tab")
public class User {
	@Id
	@GeneratedValue
	@Column(name="U_ID")
	private Integer userid;
	@Column(name="U_NAME")
	private String userName;
	@Column(name="U_MAIL")
	private String userMail;
	@Column(name="U_PASSWORD")
	private String pwd;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="user_roles_tab",joinColumns=@JoinColumn(name="userId"))
	@OrderColumn(name="roles")
	private Set<String> roles;
	@Column(name="contact")
	private String mobile;

	public User() {
		super();
	}

	public User(Integer userid) {
		super();
		this.userid = userid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", userMail=" + userMail + ", pwd=" + pwd
				+ ", roles=" + roles + ", mobile=" + mobile + "]";
	}




}
