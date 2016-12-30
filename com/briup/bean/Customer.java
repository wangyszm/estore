package com.briup.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Customer  implements HttpSessionBindingListener{
	/**
	 * 用户id
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 所在地区
	 */
	private String zip;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	
	public Customer() {}
	public Customer(Long id, String name, String password, String zip,
			String address, String telephone, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}
	public Customer(String name, String password, String zip,
			String address, String telephone, String email) {
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}
	public Customer(String password, String zip,
			String address, String telephone, String email) {
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password="
				+ password + ", zip=" + zip + ", address=" + address
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
}
