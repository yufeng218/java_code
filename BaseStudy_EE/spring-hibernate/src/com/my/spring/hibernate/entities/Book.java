package com.my.spring.hibernate.entities;

public class Book
{
	private Integer id;
	private String bookName;
	private String isbn;
	private Double price;
	private Integer stock; // 库存

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getBookName()
	{
		return bookName;
	}

	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Integer getStock()
	{
		return stock;
	}

	public void setStock(Integer stock)
	{
		this.stock = stock;
	}

}
