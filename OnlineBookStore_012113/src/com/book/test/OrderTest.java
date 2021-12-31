package com.book.test;

import java.util.List;
import java.util.Scanner;

import com.book.dao.OrderDaoImpl;
import com.book.pojo.Order;

public class OrderTest {

	public static void main(String[] args) {
		
		boolean exit=false;
		int choice;
		String cemail;
		
		Scanner sc = new Scanner(System.in);
		OrderDaoImpl oimpl=new OrderDaoImpl();
		Order o;
		List<Order> olist;
		
		do {
			
			System.out.println("1. Place order");
			System.out.println("2. Show my order history");
			System.out.println("3. Show all orders");
			
			choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1:
				
				System.out.println("Enter your email id");
				cemail=sc.nextLine();
				
				o=oimpl.placeOrder(cemail);
				
				if(o!=null) {
				System.out.println("Your order has been placed");
				System.out.println("Your order summary is as follows.........");
				
				System.out.println(o);
				}
				
				else
					System.out.println("Error while placing order.");
				break;
				
			case 2:
				
				System.out.println("Enter email id");
				cemail=sc.nextLine();
				
				olist=oimpl.ShowMyOrderHistory(cemail);
				
				if(!(olist.isEmpty())) {
					
				for(Order o1:olist)
					System.out.println(o1);
				}
				
				else
					System.out.println("You have not placed any orders yet");
				break;
				
			case 3:
				
				olist=oimpl.ShowAllorders();
				
				if(!(olist.isEmpty())) {
					
					for(Order o1:olist)
						System.out.println(o1);
					}
					
					else
						System.out.println("You have not placed any orders yet");
					break;
			}
			
		}while(exit==false);
	}
}
