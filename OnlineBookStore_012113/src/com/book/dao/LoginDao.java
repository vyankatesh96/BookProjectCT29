package com.book.dao;

public interface LoginDao {

	public boolean isOurCustomer(String cemail, String currentpassword);
	
	public boolean isOurAdmin(String adEmail, String adPassword);
}
