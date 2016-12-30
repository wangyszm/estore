package com.briup.bean;

import java.util.Date;

public class Order{
	/**
	 * 订单编号
	 */
	private Long id;
	/**
	 * 总消费
	 */
	private Double cost;
	/**
	 * 订单创建日期
	 */
	private Date orderDate;
	/**
	 * 订单创建者
	 */
	private Customer customer;
	
	public Order() {}
	public Order(Long id, Double cost, Date orderDate, Customer customer) {
		this.id = id;
		this.cost = cost;
		this.orderDate = orderDate;
		this.customer = customer;
	}
	public Order(Double cost, Date orderDate, Customer customer) {
		this.cost = cost;
		this.orderDate = orderDate;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", cost=" + cost + ", orderDate="
				+ orderDate + ", customer=" + customer + "]";
	}
}
