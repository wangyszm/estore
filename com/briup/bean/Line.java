package com.briup.bean;

import java.io.Serializable;

public class Line{
	/**
	 * 项目id
	 */
	private Long id;
	/**
	 * 项目数量
	 */
	private Integer num;
	/**
	 * 项目所在订单
	 */
	private Order order;
	/**
	 * 项目对应书
	 */
	private Book book;
	
	public Line() {}
	public Line(Long id, Integer num, Order order, Book book) {
		super();
		this.id = id;
		this.num = num;
		this.order = order;
		this.book = book;
	}
	public Line(Integer num, Order order, Book book) {
		super();
		this.id = id;
		this.num = num;
		this.order = order;
		this.book = book;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Line [id=" + id + ", num=" + num + ", order=" + order
				+ ", book=" + book + "]";
	}
}
