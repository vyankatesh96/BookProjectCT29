package com.book.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.book.pojo.Book;
import com.book.util.DBConnectivity;

import java.sql.*;

public class BookDaoImpl implements BookDao{
	
	Connection con=null;
	PreparedStatement ps;
	ResultSet rs;
	Book b;
	String sql;
	List <Book> list;
	

	@Override
	public boolean addBook(Book b) {
		con=DBConnectivity.getConnection();
		
		sql="insert into book96(bookname, author, bookprice, publisher, noOfCopies, description, rating, category, image) values (?,?,?,?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, b.getBookname());
			ps.setString(2, b.getAuthor());
			ps.setDouble(3, b.getBookprice());
			ps.setString(4, b.getPublisher());
			ps.setInt(5, b.getNoOfCopies());
			
			ps.setString(6, b.getDescription());
			ps.setDouble(7, b.getRating());
			ps.setString(8, b.getCategory());
			ps.setBinaryStream(9, b.getImage());
			
			int i = ps.executeUpdate();
			System.out.println("i of addBook bookdao= "+i);
			if(i>0)
				return true;
			//System.out.println("No of rows affected "+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean updateBook(Book b) {
		
		con= DBConnectivity.getConnection();
		
		sql="update Book96 set bookname=?, author=?, bookprice=?, publisher=?, noOfCopies=?, description=?, rating=?, category=?, image=? where bookid=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, b.getBookname());
			ps.setString(2, b.getAuthor());
			ps.setDouble(3, b.getBookprice());
			ps.setString(4, b.getPublisher());
			ps.setInt(5, b.getNoOfCopies());
			
			ps.setString(6, b.getDescription());
			ps.setDouble(7, b.getRating());
			ps.setString(8, b.getCategory());
			ps.setBinaryStream(9, b.getImage());
			
			ps.setInt(10, b.getBookid());
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}

	@Override
	public boolean deleteBook(int bookid) {
		
		con=DBConnectivity.getConnection();
		
		sql = "delete from Book96 where bookid=?";
		
		try {
			ps= con.prepareStatement(sql);
			
			ps.setInt(1, bookid);
			
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return false;
	}

	@Override
	public List<Book> showAllBooks() {
		
		con = DBConnectivity.getConnection();
		
		sql= "select * from Book96";
		
		try {
			ps= con.prepareStatement(sql);
			
			rs= ps.executeQuery();
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				
				b=new Book();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookprice(rs.getDouble(4));
				b.setPublisher(rs.getString(5));
				b.setNoOfCopies(rs.getInt(6));
				
				b.setDescription(rs.getString(7));
				b.setRating(rs.getDouble(8));
				b.setCategory(rs.getString(9));
				b.setImage(rs.getBinaryStream(10));
				
				list.add(b);
				
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
		
	}

	@Override
	public List<Book> showBookByAuthor(String author) {
		con= DBConnectivity.getConnection();
		
		sql  = "Select * from Book96 where author=?";
		
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, author);
			rs= ps.executeQuery();
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				b=new Book();	
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookprice(rs.getDouble(4));
				b.setPublisher(rs.getString(5));
				b.setNoOfCopies(rs.getInt(6));
				

				b.setDescription(rs.getString(7));
				b.setRating(rs.getDouble(8));
				b.setCategory(rs.getString(9));
				b.setImage(rs.getBinaryStream(10));
				
				list.add(b);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

	@Override
	public List<Book> showBookByPublisher(String publisher) {
		
		con= DBConnectivity.getConnection();
		
		sql = "select * from Book96 where publisher=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, publisher);
			rs= ps.executeQuery();
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				b=new Book();	
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookprice(rs.getDouble(4));
				b.setPublisher(rs.getString(5));
				b.setNoOfCopies(rs.getInt(6));
				
				b.setDescription(rs.getString(7));
				b.setRating(rs.getDouble(8));
				b.setCategory(rs.getString(9));
				b.setImage(rs.getBinaryStream(10));
				
				list.add(b);
			}
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book showBookById(int bookid) {
		con=DBConnectivity.getConnection();
		
		sql= "select * from Book96 where bookid=?";
		
		try {
			ps= con.prepareStatement(sql);
			
			ps.setInt(1, bookid);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				b=new Book();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookprice(rs.getDouble(4));
				b.setPublisher(rs.getString(5));
				b.setNoOfCopies(rs.getInt(6));
				

				b.setDescription(rs.getString(7));
				b.setRating(rs.getDouble(8));
				b.setCategory(rs.getString(9));
				b.setImage(rs.getBinaryStream(10));
			}
			
			return b;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public List<Book> ShowByCategory(String category){
	
		con=DBConnectivity.getConnection();
		
		sql= "select * from Book96 where category=?";
		
		try {
			ps= con.prepareStatement(sql);
			
			ps.setString(1, category);
			
			rs= ps.executeQuery();
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				
				b=new Book();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookprice(rs.getDouble(4));
				b.setPublisher(rs.getString(5));
				b.setNoOfCopies(rs.getInt(6));
				

				b.setDescription(rs.getString(7));
				b.setRating(rs.getDouble(8));
				b.setCategory(rs.getString(9));
				b.setImage(rs.getBinaryStream(10));
				
				list.add(b);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Set<String> categories(){
		
		con=DBConnectivity.getConnection();
		
		sql = "select category from book96";
		
		try {
			ps=con.prepareStatement(sql);
			
			rs= ps.executeQuery();
			
			Set<String> categories= new TreeSet<>();
			
			while(rs.next()) {
				
				categories.add(rs.getString(1));
				
			}
			
			return categories;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
public Set<String> authors(){
		
		con=DBConnectivity.getConnection();
		
		sql = "select author from book96";
		
		try {
			ps=con.prepareStatement(sql);
			
			rs= ps.executeQuery();
			
			Set<String> authors= new TreeSet<>();
			
			while(rs.next()) {
				
				authors.add(rs.getString(1));
				
			}
			
			return authors;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
