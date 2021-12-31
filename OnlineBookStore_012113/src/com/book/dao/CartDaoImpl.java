package com.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.pojo.Cart;
import com.book.util.DBConnectivity;
import java.sql.PreparedStatement;

public class CartDaoImpl implements CartDao {

	Connection con;
	PreparedStatement ps;
	String sql;
	ResultSet rs;
	Cart c;
	
	@Override
	public boolean addtoCart(Cart c) {
		
		con = DBConnectivity.getConnection();
		
		sql="insert into cart96 (bookid, cemail, quantity) values(?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			
			
			ps.setInt(1, c.getBookid());
			ps.setString(2, c.getCemail());
			ps.setInt(3, c.getQuantity());
			
			int i =ps.executeUpdate();
			
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeFromCart(int cartid) {
		
		con=DBConnectivity.getConnection();
		
		sql="delete from cart96 where cartid=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, cartid);
			System.out.println("ps in  remove item="+ps);
			int i =ps.executeUpdate();
			
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean clearCart(String cemail) {
		con= DBConnectivity.getConnection();
		
		sql= "delete from cart96 where cemail=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, cemail);
			
			int i = ps.executeUpdate();
			
			if(i>0) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return false;
	}

	@Override
	public boolean updateQuantity(int cartid, int quantity) {
		
		System.out.println("Inside updateQuantity");
		con = DBConnectivity.getConnection();
		
		sql="update cart96 set quantity=? where cartid=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, quantity);
			ps.setInt(2, cartid);
			
			int i= ps.executeUpdate();
			System.out.println(ps);
			
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart> showMyCart(String cemail) {
		
		con= DBConnectivity.getConnection();
		
		sql="select c.cartid, c.bookid, b.bookname, b.bookprice, c.cemail, c.quantity from cart96 c inner join book96 b on (c.bookid=b.bookid) where c.cemail=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, cemail);
			System.out.println("ps in my Cart="+ps);
			rs=ps.executeQuery();
			
			List<Cart> clist=new ArrayList<>();
			
			while(rs.next()) {
			c= new Cart();
			c.setCartid(rs.getInt(1));
			c.setBookid(rs.getInt(2));
			c.setBookname(rs.getString(3));
			c.setBookprice(rs.getDouble(4));
			c.setCemail(rs.getString(5));
			c.setQuantity(rs.getInt(6));
			
			clist.add(c);
			
			}
			return clist;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Cart checkBookId(int bookid, String cemail) {
		
		con = DBConnectivity.getConnection();
		
		sql = "select * from cart96 where bookid=? and cemail=?";
		
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1, bookid);
			ps.setString(2, cemail);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				c=new Cart();
				c.setCartid(rs.getInt(1));
				c.setBookid(rs.getInt(2));
				c.setCemail(rs.getString(3));
				c.setQuantity(rs.getInt(4));
				
				return c;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	public List<Cart> showAllCartCopy(){
		
		con= DBConnectivity.getConnection();
		
		sql="select c.cartid, c.bookid, b.bookname, b.bookprice, c.cemail, c.quantity from CartCopy96 c inner join book96 b on (c.bookid=b.bookid)";
		
		try {
			ps=con.prepareStatement(sql);
			
			//System.out.println("ps in my Cart="+ps);
			rs=ps.executeQuery();
			
			List<Cart> clist=new ArrayList<>();
			
			while(rs.next()) {
			c= new Cart();
			c.setCartid(rs.getInt(1));
			c.setBookid(rs.getInt(2));
			c.setBookname(rs.getString(3));
			c.setBookprice(rs.getDouble(4));
			c.setCemail(rs.getString(5));
			c.setQuantity(rs.getInt(6));
			
			clist.add(c);
			
			}
			return clist;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Cart showCartById(int cartid) {
		
		con=DBConnectivity.getConnection();
		
		sql="select * from CartCopy96 where cartid=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, cartid);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				c=new Cart();
				c.setCartid(rs.getInt(1));
				c.setBookid(rs.getInt(2));
				c.setCemail(rs.getString(3));
				c.setQuantity(rs.getInt(4));
				
				return c;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean deleteFromCartCopy(int cartid) {
		
		con=DBConnectivity.getConnection();
		
		sql="delete from CartCopy96 where cartid=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, cartid);
			
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

}
