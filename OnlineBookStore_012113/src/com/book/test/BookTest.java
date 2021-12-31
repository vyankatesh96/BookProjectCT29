package com.book.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.book.dao.BookDaoImpl;
import com.book.pojo.Book;

public class BookTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BookDaoImpl bimpl = new BookDaoImpl();
		
		boolean exit=false;
		boolean flag;
		Book b;
		List<Book> list;
		
		int choice;
		int bookid;
		String bookname;
		String author;
		double bookprice;
		String publisher;
		int noOfCopies;
		
		do {
			
			System.out.println("Enter the proper number given in menu");
			System.out.println("1. Add book details");
			System.out.println("2. Update Book");
			System.out.println("3. Delete book");
			System.out.println("4. Show All Books");
			System.out.println("5. Show book by author");
			System.out.println("6. Show book by Publisher");
			System.out.println("7. Exit");
			choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice){
				
			case 1:
				
				System.out.println("Enter book name");
				bookname=sc.nextLine();
				
				System.out.println("Enter author of book");
				author=sc.nextLine();
				
				System.out.println("Enter book price");
				bookprice=sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Enter name of publisher");
				publisher= sc.nextLine();
				
				System.out.println("Enter number of copies available in stores");
				noOfCopies=sc.nextInt();
				sc.nextLine();
				
				b=new Book();
				b.setBookname(bookname);
				b.setAuthor(author);
				b.setBookprice(bookprice);
				b.setPublisher(publisher);
				b.setNoOfCopies(noOfCopies);
				
				flag=bimpl.addBook(b);
				
				if(flag==true) {
					System.out.println("Your book has been successfully added to database");
				}
				else
					System.out.println("Error has occurred!!!");
				break;
				
			case 2:
				
				System.out.println("Enter the id of book to be updated");
				bookid=sc.nextInt();
				sc.nextLine();
				
				b= bimpl.showBookById(bookid);
				
				if(b!=null) {
					System.out.println(b);
					
					System.out.println("Do you want update this? Answer Y or N");
					
					char c = sc.next().charAt(0);
					sc.nextLine();
					if(c=='Y') {
						
						System.out.println("Enter book name");
						bookname=sc.nextLine();
						
						System.out.println("Enter author of book");
						author=sc.nextLine();
						
						System.out.println("Enter book price");
						bookprice=sc.nextDouble();
						sc.nextLine();
						
						System.out.println("Enter name of publisher");
						publisher= sc.nextLine();
						
						System.out.println("Enter number of copies available in stores");
						noOfCopies=sc.nextInt();
						sc.nextLine();
						
						b.setBookname(bookname);
						b.setAuthor(author);
						b.setBookprice(bookprice);
						b.setPublisher(publisher);
						b.setNoOfCopies(noOfCopies);
						
						flag=bimpl.updateBook(b);
						
						if(flag) {
							System.out.println("Book updated Successfully");
						}
						else {
							System.out.println("Error while updating book!!!");
						}
					}
					else
						System.out.println("No Problem!!!");
				}
				else {
					System.out.println("No such book with this id found in database");
				}
				break;
				
			case 3:
				
				System.out.println("Enter id of book to be deleted.");
				bookid=sc.nextInt();
				sc.nextLine();
				
				b=bimpl.showBookById(bookid);
				
				System.out.println(b);
				
				if(b!=null) {
				
				System.out.println("Are you sure want to delete this book? Answer in y or n");
				char c=sc.next().charAt(0);
				sc.nextLine();
				
				  if(c=='y') {
					
					flag=bimpl.deleteBook(bookid);
					
					if(flag)
						System.out.println("Book deleted successfully");
					else
						System.out.println("Error while deleting");
				}
				  else
					  System.out.println("No Problem!!!");
				}
				else
					System.out.println("No such book found");
				break;
				
			case 4:
				
				list= bimpl.showAllBooks();
				
				if(list.isEmpty())
					System.out.println("There are no books in our database!!!!");
				else
				{
					
					Iterator <Book> i = list.iterator();
					
					while(i.hasNext()) {
						System.out.println("\n"+i.next());
						System.out.println("------------------------------------");
					}
				}
				
				break;
				
			case 5:
				
				System.out.println("Enter author name");
				author= sc.nextLine();
				
				list=bimpl.showBookByAuthor(author);
				
				if(list.isEmpty())
					System.out.println("There are no books in our database!!!");
				else
				{
					Iterator<Book> i= list.iterator();
					
					while(i.hasNext()) {
						System.out.println("\n"+i.next());
						System.out.println("----------------------------");
					}
				}
				break;
				
			case 6:
				
				System.out.println("Enter publisher name");
				publisher= sc.nextLine();
				
				list= bimpl.showBookByPublisher(publisher);
				
				if(list.isEmpty())
					System.out.println("There are no books in our database!!!");
				else
				{
					Iterator<Book> i= list.iterator();
					
					while(i.hasNext()) {
						System.out.println("\n"+i.next());
						System.out.println("----------------");
					}
				}
				break;
				
			case 7:
				
				exit=true;
				System.out.println("Thanks");
				break;
				
				default: System.out.println("Please give valid input");
				
			}
			
		}while(exit==false);
		

	}

}
