package com.book.dao;

import java.util.List;

import com.book.pojo.Cart;

public interface CartDao {

	public boolean addtoCart(Cart c);
	public boolean removeFromCart(int cartid);
	public boolean clearCart(String cemail);
	public boolean updateQuantity(int cartid, int quantity);
	public List<Cart> showMyCart(String cemail);
	public Cart showCartById(int cartid);
	public boolean deleteFromCartCopy(int cartid);
}
