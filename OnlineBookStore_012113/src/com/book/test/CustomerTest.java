package com.book.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.book.dao.CustomerDaoImpl;
import com.book.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomerDaoImpl cimpl = new CustomerDaoImpl();
		
		boolean exit= false;
		boolean flag;
		Customer c;
		
		List<Customer> customerlist;
		
		int choice;
		int cid;
		String fname;
		String lname;
		String caddress;
		String cemail;
		String contact;
		String password;
		
		do {
			System.out.println("---------Welcome to our Site-------");
			System.out.println("1. Add new Customer");
			System.out.println("2. Search by Customer Id");
			System.out.println("3. Update Customer details");
			System.out.println("4. Delete by Customer Id ");
			System.out.println("5. Search by Customer email ");
			System.out.println("6.show Customers");
			System.out.println("7. Exit");
			
			
			choice= sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1:
				
				System.out.println("Enter FirstName");
				fname= sc.nextLine();
				
				System.out.println("Enter LastName");
				lname= sc.nextLine();
				
				System.out.println("Enter Address");
				caddress= sc.nextLine();
				
				System.out.println("Enter Email");
				cemail = sc.nextLine();

				System.out.println("Enter Contact");
				contact= sc.nextLine();
				
				System.out.println("Enter Password");
				password = sc.nextLine();
				
				c= new Customer();
				
				c.setFname(fname);
				c.setLname(lname);
				c.setCaddress(caddress);
				c.setCemail(cemail);
				c.setContact(contact);
				c.setPassword(password);
				
				flag =cimpl.addCustomer(c);
				
				if(flag==true) {
					System.out.println("Successfully Added");
				}
				else {
					System.out.println("Error while Adding");
				}
			   break;
			   
			case 2:
				
				System.out.println("Enter Customer id");
				cid =sc.nextInt();
				sc.nextLine();
				
				c = cimpl.searchCustomer(cid);
				if(c!=null) {
				System.out.println("FirstName = "+c.getFname());
				System.out.println("LastName = "+c.getLname());
				System.out.println("Address = "+c.getCaddress());
				System.out.println("Email = "+c.getCemail());
				System.out.println("Contact = "+c.getContact());
				System.out.println("Password = "+c.getPassword());
				}
				else {
					System.out.println("No such Customer with this Id found in database");
				}
				break;
			   
			case 3:
				
				System.out.println("Enter Customer id");
				cid =sc.nextInt();
				sc.nextLine();
				
				c = cimpl.searchCustomer(cid);
				
				if(c!=null) {
					System.out.println(c);
					System.out.println("Do really you want to the Update your details? Answer y or n ");
					
					char y=sc.next().charAt(0); 
					sc.nextLine();
					
					if(y=='y') {
						
						System.out.println("Enter FirstName");
						fname= sc.nextLine();
						
						System.out.println("Enter LastName");
						lname= sc.nextLine();
						
						System.out.println("Enter Address");
						caddress= sc.nextLine();
						
						System.out.println("Enter Email");
						cemail = sc.nextLine();

						System.out.println("Enter Contact");
						contact= sc.nextLine();
						
						System.out.println("Enter Password");
						password = sc.nextLine();
						c.setFname(fname);
						c.setLname(lname);
						c.setCaddress(caddress);
						c.setCemail(cemail);
						c.setContact(contact);
						c.setPassword(password);
						
						flag=cimpl.updateCustomer(c);
						
						if(flag==true) {
							System.out.println("Updated Successfully in DataBase");
						}
						else {
							System.out.println("Getting Error while updating");
						}
					}
					else {
						System.out.println("No Problem");
					}
				}
				
				else {
					System.out.println("No such Customer with this id found in database");
				}
				break;
				
			case 4:
				
				System.out.println("Enter Customer id");
				cid =sc.nextInt();
				sc.nextLine();
				
				c = cimpl.searchCustomer(cid);
				
				if(c!=null) {
					System.out.println(c);
					System.out.println("Do really you want to the Delete your details? Answer y or n ");
					
					char y = 'y';
					y= sc.next().charAt(0);
					sc.nextLine();
					
					if(y=='y') {
						
						flag= cimpl.deleteCustomer(cid);
						
						if(flag==true) {
							System.out.println("Successfully Deleted");
						}
						else {
							System.out.println("Error While deleting");
						}
					}
					else {
						System.out.println("No Problem");
					}
				}
				else {
					System.out.println("No such Customer Id found in our Database");
				}
				break;
				
			case 5:
				
				System.out.println("Enter Customer Email");
				cemail= sc.nextLine();
				
				c=cimpl.searchCustomer(cemail);
				
				if(c!=null) {
					
					System.out.println("FirstName = "+c.getFname());
					System.out.println("LastName = "+c.getLname());
					System.out.println("Address = "+c.getCaddress());
					System.out.println("Email = "+c.getCemail());
					System.out.println("Contact = "+c.getContact());
					System.out.println("Password = "+c.getPassword());
				}
				else {
					System.out.println("No such Customer Email found in our Database");
				}
				break;
				
			case 6:
			{
				customerlist=cimpl.showCustomers();
				
				if(customerlist.isEmpty()) {
					System.out.println("There are no books in our database!!!!");
				}
				
				Iterator<Customer> i = customerlist.iterator();
				
				while(i.hasNext()) {
					System.out.println(i.next());
					System.out.println("------------------");
				}
			}
			break;
			
			case 7:
				
				exit=true;
				System.out.println("Thanks for using our site...");
			break;	
				
			default: System.out.println("Please give valid input");
	
			}
			
			
		}while(exit==false);

	}

}
