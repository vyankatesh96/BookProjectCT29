package com.book.test;

import java.util.List;
import java.util.Scanner;

import com.book.dao.BookDaoImpl;
import com.book.dao.CartDaoImpl;
import com.book.pojo.Book;
import com.book.pojo.Cart;

public class CartTest {

	public static void main(String[] args) {
		
		boolean exit=false, flag;
		int choice;
		int cartid;
		int bookid;
		String cemail;
		int quantity;
		
		Scanner sc = new Scanner(System.in);
		BookDaoImpl bimpl = new BookDaoImpl();
		List<Book> blist= bimpl.showAllBooks();
		CartDaoImpl cimpl = new CartDaoImpl();
		Cart c;
		List<Cart> clist;
		
		
		for(Book b: blist)
			System.out.println(b);
		
		do {
			System.out.println("---------Welcome To Our Site--------");
			System.out.println("1. Add Book in your Cart");
			System.out.println("2. show all cart");
			System.out.println("3. Remove item from cart");
			System.out.println("4. Clear Cart");
			System.out.println("5. Update Quantity");
			System.out.println("6. Exit");
			
			choice= sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1:
				
				System.out.println("Enter the id of book you want to buy ");
				bookid=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter EmailId");
				cemail=sc.nextLine();
				
				System.out.println("How many copies of this book do you want?");
				quantity=sc.nextInt();
				sc.nextLine();
				
				c=new Cart();
				c.setBookid(bookid);
				c.setCemail(cemail);
				c.setQuantity(quantity);
				
				flag=cimpl.addtoCart(c);
				
				if(flag) {
					System.out.println("Book added Successfully");
				}
				else {
					System.out.println("Getting Error while adding book");
				}
				break;
			
			case 2:
				
				System.out.println("Enter your email Id");
				cemail=sc.nextLine();
				
				clist=cimpl.showMyCart(cemail);
				
				if(clist.isEmpty()) 
					System.out.println("Please the add book in your Cart first!!");
				
				else {
					System.out.println("Items in your Cart............");
				
				
				for(Cart cart:clist) {
					System.out.println(cart);
				}
				
				}
				break;
				
			case 3:
				
				System.out.println("Enter email Id");
				cemail=sc.nextLine();
				
				clist=cimpl.showMyCart(cemail);
				
				if(clist.isEmpty()) 
					System.out.println("Please the add book in your Cart");
				
				else {
					System.out.println("Items in your Cart............");
				
				
				for(Cart cart:clist) {
					System.out.println(cart);
				}
				
				
				System.out.println("\nEnter CartId of the item you want remove");
				cartid= sc.nextInt();
				sc.nextLine();
				
				System.out.println("Are you sure you want to delete the item at cartid=" + cartid);
				System.out.println("press y or n");
				char c1=sc.nextLine().charAt(0);
				
				if(c1 =='y') {
					
					flag=cimpl.removeFromCart(cartid);
					
					if(flag)
						System.out.println("Item removed from cart successfully");
					
				}
				else 
					System.out.println("No problem");
				
				}
				break;
				
			case 4:
				
				System.out.println("Enter the Email-Id");
				cemail=sc.nextLine();
				
				flag=cimpl.clearCart(cemail);
				
				if(flag)
					System.out.println("Your cart has been Cleared");
				else
					System.out.println("Getting error while clearing the Cart");
			
			break;
			
			
			case 5:
				
				System.out.println("Enter Quantity");
				quantity=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter the  cart id of the item to be  updated");
				cartid=sc.nextInt();
				sc.nextLine();
				
				flag=cimpl.updateQuantity(cartid, quantity);
				
				if(flag)
					System.out.println("Quantity of the item "+"with cartid "+cartid+" updated successfully");
				else
					System.out.println("Getting Error while updating");
				break;
			case 6:
				
				exit=true;
				System.out.println("Thanks for using our website");
				
				break;
				
			default	: 
				System.out.println("Please give valid input");
			}	
			
			
		}while(exit==false);
	}

}
