package com.briup.bean;

import java.sql.Date;

public class Book{
	/**
	 * 书id
	 */
	private Long id;
	/**
	 * 书名
	 */
	private String name;
	/**
	 * 书价格
	 */
	private Double price;
	/**
	 * 出版日期
	 */
	private Date bookDate;
	
	public Book() {}
	public Book(Long id, String name, Double price, Date bookDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.bookDate = bookDate;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", bookDate=" + bookDate + "]";
	}
}
