package com.book.dao;

import java.util.List;

import com.book.pojo.Order;

public interface OrderDao {

	public  Order placeOrder(String cemail);
	public  Order placeOrder(String cemail, double totalBill);
	public List<Order> ShowMyOrderHistory(String cemail);
	public List<Order> ShowAllorders();
	public boolean UpdateStatus(String orderStatus, int orderId);
}
