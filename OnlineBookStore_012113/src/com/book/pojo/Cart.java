package com.book.pojo;

public class Cart {

	private int cartid;
	private int bookid;
	private String cemail;
	private int quantity;
	private String bookname;
	private double bookprice;
	
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "\nCart [cartid=" + cartid + ", \nbookid=" + bookid + ", \ncemail=" + cemail + ", \nquantity=" + quantity
				+ ", \nbookname=" + bookname + ", \nbookprice=" + bookprice + "]";
	}


	public int getCartid() {
		return cartid;
	}
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public double getBookprice() {
		return bookprice;
	}

	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
